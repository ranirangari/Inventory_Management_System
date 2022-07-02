package com.inventory.model;

public class ItemBean {

	private int id;
	private String itemCode;
	private String itemName;
	private String itemBrand;
	private String itemCategory;
	private String itemDescription;
	private String itemQuantity;
	private float itemPrice;
	private boolean status;
	private String errormsg;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	// public boolean isActive() {
	// return isActive;
	// }

	// public void setActive(boolean isActive) {
	// this.isActive = isActive;
	// }

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	@Override
	public String toString() {
		return "ItemBean [id=" + id + ", itemCode=" + itemCode + ", itemName=" + itemName + ", itemBrand=" + itemBrand
				+ ", itemCategory=" + itemCategory + ", itemDescription=" + itemDescription + ", itemQuantity="
				+ itemQuantity + ", itemPrice=" + itemPrice + ", status=" + status + ", errormsg=" + errormsg + "]";
	}

}
