package com.cognizant.truyum.model;

import java.util.ArrayList;

public class Cart {

	private ArrayList<MenuItem> menuItems;
	private double total;

	public Cart() {
		super();
		menuItems=new ArrayList<>();
		total=0.0;
	}

	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(ArrayList<MenuItem> menuItems) {
		menuItems = menuItems;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [MenuItems=" + menuItems + ", total=" + total + "]";
	}
	

}
