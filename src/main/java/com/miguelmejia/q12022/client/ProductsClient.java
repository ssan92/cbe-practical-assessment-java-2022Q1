package com.miguelmejia.q12022.client;

import com.miguelmejia.q12022.presenter.ProductApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "products-client", url = "${app.config.productsDomain}")
public interface ProductsClient {
    @GetMapping("${app.config.productsEndPoint}")
    ProductApiResponse findAllProducts();
}
