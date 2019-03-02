//Author:Vipul Thakur
package com.capgemini.salesmanagement.bean;


import java.time.LocalDate;

public class Sale
{
	private int saleId;
	private int prodCode;
	private String productName;
	private String category;
	private LocalDate saleDate;
	private int quantity;
	private float lineTotal;
	

	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public int getProdCode() {
		return prodCode;
	}
	
	public void setProdCode(int prodCode) {
		this.prodCode = prodCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public LocalDate getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getLineTotal() {
		return lineTotal;
	}
	public void setLineTotal(float lineTotal) {
		this.lineTotal = lineTotal;
	}
	
	@Override
	public String toString() 
	{
		return "=========================================="+"saleId= "+saleId+"\n"+"prodCode= "+prodCode+"\n"+"productName= "+productName+"\n"+"category= "+category+"\n"+"saleDate= "+saleDate+"\n"+"quantity= "+quantity+"\n"+"lineTotal= "+lineTotal+"\n"+"==========================================";
	}
	
}
