package com.cognizant.truyum.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.exception.UserNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {
	
	@Autowired
	private CartDao cartDao;
	
	public void addCartItem(String user, int menuItemId) throws MenuItemNotFoundException
	{
		cartDao.addCartItem(user, menuItemId);
	}
	
	public ArrayList<MenuItem> getAllCartItems(String userId) throws UserNotFoundException, CartEmptyException
	{
		return cartDao.getAllCartItems(userId);		
	}
	
	public void deleteCartItem(String userId, int menuItemId) throws MenuItemNotFoundException, UserNotFoundException, CartEmptyException
	{
		cartDao.deleteCartItem(userId, menuItemId);
	}

}
