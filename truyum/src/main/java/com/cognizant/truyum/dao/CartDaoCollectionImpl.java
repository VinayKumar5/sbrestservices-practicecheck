package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.exception.UserNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component
public class CartDaoCollectionImpl implements CartDao {
	
	private HashMap<String,Cart> userCarts;
	
	public CartDaoCollectionImpl()
	{
		super();
		userCarts=new HashMap<String, Cart>();
	}

	@Override
	public void addCartItem(String user, int menuItemId) throws MenuItemNotFoundException {
		
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem=null;
		
		try {
			menuItem=menuItemDao.getMenuItem(menuItemId);			
		}
		catch(MenuItemNotFoundException e)
		{
			e.printStackTrace();		
		}
		
		if(userCarts.containsKey(user)) {
			
			ArrayList<MenuItem> menuItems=userCarts.get(user).getMenuItems();
			menuItems.add(menuItem);
		}
		else
		{
			Cart cart=new Cart();
			cart.getMenuItems().add(menuItem);
			userCarts.put(user,cart);
		}
		
		
	}

	@Override
	public ArrayList<MenuItem> getAllCartItems(String userId)throws UserNotFoundException, CartEmptyException{
		
		if(userCarts.containsKey(userId))
		{
			Cart cart=userCarts.get(userId);
			ArrayList<MenuItem> menuItems=cart.getMenuItems();
			
			if(menuItems.isEmpty())
			{
				throw new CartEmptyException("Cart is empty");
			}
			else
			{
				double total=0.0;
				for(MenuItem m:menuItems)
				{
					total+=m.getPrice();
				}
				userCarts.get(userId).setTotal(total);
			}
			return menuItems;
		}
		else
		{
			throw new UserNotFoundException("User "+userId+" does not exist");
		}	
		
	}

	@Override
	public void deleteCartItem(String userId, int menuItemId) throws CartEmptyException, MenuItemNotFoundException, UserNotFoundException {
		
		if(userCarts.containsKey(userId)) 
		{
			Cart cart=userCarts.get(userId);
			ArrayList<MenuItem> menuItems=cart.getMenuItems();
			
			if(menuItems.isEmpty())
			{
				throw new CartEmptyException("Cart is empty");
			}
			else
			{
				boolean isDeleted=false;
				int index=0;
				for(MenuItem m:menuItems)
				{
					if(m.getId()==menuItemId)
					{						
						menuItems.remove(index);
						isDeleted=true;
					}
					index++;						
				}
				
				if(!isDeleted)
				{
					throw new MenuItemNotFoundException("Menu Item Not Found");
				}
				
			}		
			
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
				
	}

}
