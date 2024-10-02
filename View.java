package edu.jsp.store.view;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import edu.jsp.store.Controller.Controller;
import edu.jsp.store.model.Product;
import edu.jsp.store.model.Store;

public class View {
	 static Scanner myInput= new Scanner(System.in);
	 static Controller controller = new Controller();
	 static Store store= controller.getStore();
	 static{
		 System.out.println("------welcome to store");
		 System.out.print("Enter id:");
		 store.setId(myInput.nextInt());
		 System.out.print("Enter name:");
		 myInput.nextLine();
		 store.setName(myInput.nextLine());
		 System.out.print("Enter contact:");
		 store.setContatc(myInput.nextLong());
		 myInput.nextLine();
		 System.out.print("Enter Address:");
		 store.setAddress(myInput.nextLine());
		 System.out.println();
//			System.out.println("Enter String: ");
//			String temp=myInput.nextLine();
////			System.out.println(userChoice);
//			System.out.println("temp " + temp);
	 }
	public static void main(String[] args) {
//		System.out.println("The store from view" + View.store );
//		System.out.println("The store from controller"+Controller.store  );
//		 System.out.println(store);
//		boolean flag = true;
		do {
			System.out.println("Select option from below list: ");
			System.out.println("1 Display store information\n2.Add product\n3.Display All product\n4.Update product\n5.Remove product\n6.Add Product\n0.Exit");
			System.out.println("Enter digit respective to desired option: ");
			byte userChoice =myInput.nextByte();
			myInput.nextLine();

			switch(userChoice) {
			case 0:
				System.out.println("--------Exited-------");
				System.exit(0);
				break;
			case 1:
				System.out.println(store +"\n");
			break;
			case 2:
				controller.addProduct(getProductDetails());
				System.out.println(store.getProduct());
			break;
			case 3:
				displayAllProducts();
//				System.out.println(store.getProduct());
			break;
			case 4:
				displayAllProducts();
				System.out.println("enter product id to update: ");
				int productIdToUpdate=myInput.nextInt();
				myInput.nextLine();
				System.out.println("1.Name\n2.Price\n3.Quantity\n4.Availability");
				System.out.println("Enter Option");
				byte updateOption=myInput.nextByte();
				myInput.nextLine();
				switch(updateOption) {
				case 1:
					System.out.println("Enter name to Update: ");
					String newName=myInput.nextLine();
					controller.updateProductName(productIdToUpdate, newName);
					break;
				case 2:
					System.out.println("Enter Price to Update: ");
					Double newPrice=myInput.nextDouble();
					controller.updateProductPrice(productIdToUpdate, newPrice);
					break;		
				case 3:
					System.out.println("Enter Quantity to Update: ");
					int newQuantity=myInput.nextInt();
					controller.updateProductQuantity(productIdToUpdate, newQuantity);
					break;
				case 4:
//					System.out.println("Enter Availability to Update: ");
//					String newName=myInput.nextLine();
//					controller.updateProductName(productIdToUpdate, newName);
					break;
				default:
					System.out.println("----INVALID SELECTION----");
					break;
					
				}
			break;
			case 5://remove
				if(displayAllProducts()) {
				boolean flag=true;
				ArrayList<Integer> produuctsToRemove=new ArrayList<Integer>();	
				do {
					
					System.out.println("Enter product Id to remove: ");
					int idToRemove=myInput.nextInt();
					myInput.nextLine();
					produuctsToRemove.add(idToRemove);
					System.out.println("Continue adding id to remove? y/n :");
					if (myInput.next().charAt(0)=='n') {
						flag=false;
					}
				} while (flag);
				controller.removeProduct(produuctsToRemove);
				}
				break;
			case 6:
				controller.addProducts(addProducts());
				System.out.println(store.getProduct());
				break;
			default:
				System.out.println("Invalid Choice:");
				break;
			}
		}while(true);
	}
	public static Product getProductDetails() {
		System.out.print("enter id: ");
		int productId=myInput.nextInt();
		myInput.nextLine();
		System.out.print("enter name: ");
		String productName=myInput.nextLine();
		System.out.print("enter price: ");
		double productPrice=myInput.nextDouble();
		myInput.nextLine();
		System.out.print("enter quantity:");
		int productQuantity=myInput.nextInt();
		myInput.nextLine();
		boolean productAvailability=true;
		if (productQuantity<=0) {
			productAvailability=false;
		}
		return new Product(productId,productName,productPrice,productQuantity,productAvailability);
	}
	public static List<Product> addProducts(){
		ArrayList<Product> newProductList = new ArrayList<Product>();
		boolean toContinue=true;
		do {
			newProductList.add(getProductDetails());
			System.out.println("Continue adding products ? y/n :");
			if(myInput.next().charAt(0)=='n') 
				toContinue=false;
			
		}while(toContinue);
		return newProductList;
		
	}
	public static boolean displayAllProducts() {
		List<Product> allProducts=controller.getAllProducts();
		if (allProducts==null) {
			System.out.println("no product available in the store");
			return false;
		}else {
		//header
		System.out.printf("|%-5s|%-15s|%-11s|%-10s|%-12s|","ID","NAME","PRICE","QUANTITY","AVAILABILITY");
		System.out.println();
		for (Product product : allProducts) {
			System.out.printf("|%-5d",product.getId());
			System.out.printf("|%-15s",product.getName());
			System.out.printf("|%-11f",product.getPrice());
			System.out.printf("|%-10d",product.getQuantity());
			System.out.printf("|%-12b",product.isAvailability());
			System.out.println();
			}
		return true;
		}
	}
}
	