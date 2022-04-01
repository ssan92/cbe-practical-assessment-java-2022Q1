package com.pichincha.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.entity.ProductStoreOrder;
import com.pichincha.repo.IProductStoreOrderRepo;
import com.pichincha.service.IProductStoreOrderService;

@Service
public class ProductStoreOrderServiceImpl implements IProductStoreOrderService {

	@Autowired
	private IProductStoreOrderRepo productStoreOrderRepo;

	@Override
	public ProductStoreOrder saveUpdate(ProductStoreOrder pedido) {
		return productStoreOrderRepo.save(pedido);
	}

	@Override
	public void delete(Long idPedido) throws Exception {
		Optional<ProductStoreOrder> PedidoOpt = productStoreOrderRepo.findById(idPedido);
		if (PedidoOpt.isPresent()) {
			productStoreOrderRepo.delete(PedidoOpt.get());
		} else {
			throw new Exception("Can't be deleted, order doesn't exist.");
		}
	}

	@Override
	public void deleteAll(List<ProductStoreOrder> productoPedidoTiendas) {
		productStoreOrderRepo.deleteAll(productoPedidoTiendas);
	}

	@Override
	public List<ProductStoreOrder> getAllProductStoreOrders() {
		return productStoreOrderRepo.findAll();
	}

	@Override
	public ProductStoreOrder getProductStoreOrdersByOrdIdStorIdProdId(long orderId, long storeId, long productId) {
		return productStoreOrderRepo.findByOrderIdAndStoreIdAndProductId(orderId, storeId, productId);
	}

	@Override
	public List<ProductStoreOrder> getProductStoreOrdersByOrderId(long orderId) {
		return productStoreOrderRepo.getByOrderId(orderId);
	}
}