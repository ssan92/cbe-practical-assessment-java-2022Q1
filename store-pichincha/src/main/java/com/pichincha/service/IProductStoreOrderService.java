package com.pichincha.service;

import java.util.List;

import com.pichincha.entity.ProductStoreOrder;

public interface IProductStoreOrderService {

	ProductStoreOrder saveUpdate(ProductStoreOrder productStoreOrder);

	void delete(Long orderId) throws Exception;

	List<ProductStoreOrder> getAllProductStoreOrders();

	List<ProductStoreOrder> getProductStoreOrdersByOrderId(long orderId);

	ProductStoreOrder getProductStoreOrdersByOrdIdStorIdProdId(long orderId, long storeId, long productId);

	void deleteAll(List<ProductStoreOrder> productoPedidoTiendas);
}
