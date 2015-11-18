package com.ai.crm.customerorder.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.model.ShoppingCart;
import com.ai.crm.customerorder.repository.interfaces.IShoppingCartRepository;
@Component
public class ShoppingOrderRepository implements IShoppingCartRepository {

	//@Autowired
	SessionFactory sessionFactory;
	
	public ShoppingOrderRepository() {
	}
	
	public ShoppingOrderRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.openSession();
	}

	@Override
	public void saveShoppingCart(ShoppingCart shoppingCart) throws Exception {
		currentSession().save(shoppingCart);
		
	}

	@Override
	public ShoppingCart getShoppingCartByID(long shoppingCartId) throws Exception {
		ShoppingCart shoppingCart= (ShoppingCart)currentSession().get(ShoppingCart.class, shoppingCartId);
		return shoppingCart;
	}

	@Override
	public ShoppingCart createNewShoppingCart(ShoppingCart shoppingCart) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	


}
