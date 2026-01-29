package com.app.controller.study.quiz.quiz04;

public class Request {

	String category;
	String product;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Request [category=" + category + ", product=" + product + "]";
	}
	
	
	
}
