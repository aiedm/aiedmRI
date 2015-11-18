package com.ai.crm.customerorder.repository.interfaces;

import com.ai.crm.customerorder.domain.model.ShoppingCart;

public interface IShoppingCartRepository {
	void saveShoppingCart(ShoppingCart shoppingCart) throws Exception;
	ShoppingCart getShoppingCartByID(long shoppingCartId)  throws Exception;
	public ShoppingCart createNewShoppingCart(ShoppingCart shoppingCart) throws Exception;
}
