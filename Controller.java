package edu.jsp.store.Controller;

import java.util.ArrayList;

import java.util.List;

import edu.jsp.store.model.Product;
import edu.jsp.store.model.Store;

public class Controller {
	 public static Store store=null;
	public Store getStore() {
		return store=new Store();
	}
	public void addProduct(Product product) {
		if (store.getProduct()==null) {
			store.setProduct(new ArrayList<Product>());
			List<Product> products =store.getProduct();
			products.add(product);
		}else {
			store.getProduct().add(product);
		}
		
		
	}
	public void addProducts(List<Product> newProducts) {
//		store.getProduct().addAll(newProducts);
		if (store.getProduct()==null) {
			for (Product product : newProducts) {
				addProduct(product);
			}
		}else {
			store.getProduct().addAll(newProducts);
		}
	}

	public List<Product> getAllProducts(){

		return store.getProduct();
	}
	public void removeProduct(List<Integer> products) {
		ArrayList<Product> productToRemove= new ArrayList<Product>();
		// to change target
		for (Integer productTarget : products) {
			//to eliminate target
			int targetId=productTarget;
			for (Product productEliminator : store.getProduct()) {
				if (productEliminator.getId()==targetId) {
//					existingProducts.remove(productEliminator);
					productToRemove.add(productEliminator);
				}
			}
		}
		store.getProduct().removeAll(productToRemove);
	}


	public void updateProductName(int productIdToUpdate,String newName){
		Product product =getProduct(productIdToUpdate);
		for(Product currentProduct:store.getProduct()) {
			if(currentProduct==product) {
				currentProduct.setName(newName);
			}
		}
//		getProduct(productIdToUpdate).setName(newName);
	}
	public void updateProductPrice(int productIdToUpdate,Double newPrice){
		Product product =getProduct(productIdToUpdate);
		for(Product currentProduct:store.getProduct()) {
			if(currentProduct==product) {
				currentProduct.setPrice(newPrice);
			}
		}
//		getProduct(productIdToUpdate).setName(newName);
	}
	public void updateProductQuantity(int productIdToUpdate,int newQuantity){
		Product product =getProduct(productIdToUpdate);
		for(Product currentProduct:store.getProduct()) {
			if(currentProduct==product) {
				currentProduct.setQuantity(newQuantity);
			}
		}
//		getProduct(productIdToUpdate).setName(newName);
	}
	public Product getProduct(int productId) {
		for (Product product : store.getProduct()) {
			if(product.getId()==productId) {
				return product;
			}
		}
		return null;
	}
}
