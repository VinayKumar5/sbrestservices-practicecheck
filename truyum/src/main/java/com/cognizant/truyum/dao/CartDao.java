package com.cognizant.truyum.dao;

import java.util.ArrayList;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.exception.UserNotFoundException;
import com.cognizant.truyum.model.MenuItem;

public interface CartDao {
	
	public void addCartItem(String user, int menuItemId) throws MenuItemNotFoundException;
	public ArrayList<MenuItem> getAllCartItems(String userId) throws UserNotFoundException, CartEmptyException;	
	public void deleteCartItem(String userId, int menuItemId) throws UserNotFoundException,CartEmptyException,MenuItemNotFoundException; 

}
