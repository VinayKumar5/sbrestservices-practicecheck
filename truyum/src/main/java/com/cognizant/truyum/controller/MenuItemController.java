package com.cognizant.truyum.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	
	@Autowired
	private MenuItemService menuItemService;
	
	@GetMapping
	public ArrayList<MenuItem> getAllMenuItems()
	{
		LOGGER.info("Start");
		LOGGER.info("In getAllMenuItems()");
		LOGGER.info("End");
		return menuItemService.getMenuItemListCustomer();
	}
	
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable int id) throws MenuItemNotFoundException 
	{
		LOGGER.info("Start");
		LOGGER.info("In getMenuItem()");
		LOGGER.info("End");
		return menuItemService.getMenuItem(id);						
	}
	
	@PutMapping()
	public void modifyMenuItem(@RequestBody MenuItem menuItem)throws MenuItemNotFoundException
	{
		LOGGER.info("Start");
		LOGGER.info("In modifyMenuItem()");		
		menuItemService.save(menuItem);
		LOGGER.info("End");
	}

}
