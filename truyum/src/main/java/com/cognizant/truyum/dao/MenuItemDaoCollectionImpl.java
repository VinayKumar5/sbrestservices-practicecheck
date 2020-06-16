package com.cognizant.truyum.dao;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	
	private	ArrayList<MenuItem> menuItems=null;
	private ClassPathXmlApplicationContext context;
	
	

	public MenuItemDaoCollectionImpl() {
		super();
		context = new ClassPathXmlApplicationContext("truyum.xml");		
		menuItems = (ArrayList<MenuItem>)context.getBean("menuItems", java.util.ArrayList.class);
		context.close();
	}

	@Override
	public ArrayList<MenuItem> getMenuItemListCustomer() {	
		
		return menuItems;			
	}

	@Override
	public MenuItem getMenuItem(int id) throws MenuItemNotFoundException {
		
		MenuItem item=null;
		boolean found=false;
		
		for(MenuItem i:menuItems)
		{
			if(i.getId()==id)
			{
				item=i;
				found=true;
				break;
			}
		}
		
		if(!found)
		{
			throw new MenuItemNotFoundException("Menu Item Not Found");
		}
		
		return item;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) throws MenuItemNotFoundException {
		
		int index=0;
		boolean found=false;
		
		for(MenuItem m:menuItems)
		{
			if(m.getId()==menuItem.getId())
			{		
				found=true;
				break;
			}
			index++;
		}
		//System.out.println(index);
		
		if(!found)
			throw new MenuItemNotFoundException("Menu Item Not Found");
		
		menuItems.set(index, menuItem);
				
	}

}
