package com.inventory.model;

public class Category {

	private int id;
	private String itemCategory;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", itemCategory=" + itemCategory + "]";
	}
	
		
	}

