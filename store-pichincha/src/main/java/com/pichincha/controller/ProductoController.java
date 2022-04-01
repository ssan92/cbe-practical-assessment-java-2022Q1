package com.pichincha.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pichincha.dto.ProductDto;
import com.pichincha.dto.ProductParentDto;
import com.pichincha.entity.Product;
import com.pichincha.entity.Store;
import com.pichincha.entity.StoreProduct;
import com.pichincha.exception.ModelNotFoundException;
import com.pichincha.service.IProductService;
import com.pichincha.service.IStoreProductService;
import com.pichincha.service.IStoreService;

@RestController
@RequestMapping("/product")
public class ProductoController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private IProductService productService;
	@Autowired
	private IStoreService storeService;
	@Autowired
	private IStoreProductService storeProductService;

	private List<Product> products;

	/*
	 * @PostConstruct public void init() { products =
	 * productService.getAllProducts(); List<ProductDto> dtosProducts =
	 * consumeProductsFromMock().getProds(); List<ProductDto> newProducts = new
	 * ArrayList<>(); newProducts = dtosProducts.stream() .filter(proDto ->
	 * products.stream().filter(prod ->
	 * proDto.getCod().equals(prod.getCod())).count() == 0)
	 * .collect(Collectors.toList()); newProducts.forEach(prod -> products.add(new
	 * Product(prod.getName(), prod.getCod(), BigDecimal.valueOf(prod.getPrice()),
	 * Long.valueOf(prod.getStock()))));
	 * productService.guardarListaProductos(productos); }
	 */

	private ProductParentDto consumeProductsFromMock(String mockUrl) {
		ResponseEntity<ProductParentDto> response = restTemplate.getForEntity(mockUrl, ProductParentDto.class);
		return response.getBody();

	}

	/*
	 * @GetMapping("/productos") public ResponseEntity<ProductParentDto>
	 * listarProductos() { List<ProductDto> producDtos = new ArrayList<>();
	 * productos.forEach(prod -> producDtos.add(new ProductDto(prod.getCod(),
	 * prod.getName()))); ProductParentDto respuestaProducto = new
	 * ProductParentDto(); respuestaProducto.setProds(producDtos); return new
	 * ResponseEntity<ProductParentDto>(respuestaProducto, HttpStatus.OK); }
	 */

	@PutMapping("/saveProductsStore/{storeId}/{url}")
	public ResponseEntity<Object> saveProductsStore(@PathVariable Long storeId, @PathVariable String url) {
		Store store = storeService.getStoreById(storeId);
		if (store == null) {
			throw new ModelNotFoundException("Store doesn't exist.");
		}
		List<ProductDto> dtosProducts = consumeProductsFromMock(url).getProds();
		List<ProductDto> productsToBeAdded = dtosProducts.stream().filter(proDto -> proDto.getStock() > 5l)
				.collect(Collectors.toList());
		List<StoreProduct> storeProducts = new ArrayList<>();
		productsToBeAdded.forEach(prod -> {
			storeProducts.add(new StoreProduct(store, Product.builder().name(prod.getName()).cod(prod.getCod())
					.price(BigDecimal.valueOf(prod.getPrice())).stock(prod.getStock()).build()));
		});
		storeProductService.saveList(storeProducts);
		return new ResponseEntity<Object>("Products added successfully.", HttpStatus.OK);
	}
}
