package edu.jsp.store.model;

import java.util.List;

public class Store {
	private int id;
	private String name;
	private long contact;
	private String address;
	
	private List<Product> product ;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContatc() {
		return contact;
	}

	public void setContatc(long contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address + "]";
	} 
	
}
