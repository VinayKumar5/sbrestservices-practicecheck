package com.cognizant.truyum.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.exception.UserNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable String userId, @PathVariable int menuItemId) throws MenuItemNotFoundException
	{
		LOGGER.info("Start");
		LOGGER.info("In addCartItem()");		
		cartService.addCartItem(userId, menuItemId);
		LOGGER.info("End");
		
	}
	
	
	@GetMapping("/{userId}")
	public ArrayList<MenuItem> getAllCartItems(@PathVariable String userId) throws UserNotFoundException, CartEmptyException
	{
		LOGGER.info("Start");
		LOGGER.info("In getAllCartItems()");
		LOGGER.info("End");
		return cartService.getAllCartItems(userId);		
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItems(@PathVariable String userId, @PathVariable int menuItemId) throws MenuItemNotFoundException, UserNotFoundException, CartEmptyException
	{
		LOGGER.info("Start");
		LOGGER.info("In deleteCartItems()");		
		cartService.deleteCartItem(userId, menuItemId);
		LOGGER.info("End");
		
	}

}
