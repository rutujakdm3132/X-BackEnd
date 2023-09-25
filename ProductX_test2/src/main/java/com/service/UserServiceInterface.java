package com.service;

import java.util.List;

import com.model.Basket;

import com.model.Product;

import com.model.User;

public interface UserServiceInterface {

	//User Interface methods
	public User findByEmailIdAndPassword(String email ,String password);
	
	public User insertData(User u);

	public User getOneUser(int id);

	public String deleteOneUser(int id);

	public User updateUserName(User u, int id);

	public User getUserByEmail(String email);

	//product interface
	
	public Product insertProduct(Product p);
	
	public String deleteOneProduct(int id);
	
	public Product getOneProduct(int id);
	
	public List<Product> getAllProduct();
	
	List<Product> getProductsByCategory(String category);
			
	List<Product> getProductsByCity(String city);

	List<Product> getProductsByCompany(String pCompany);

	//User login Interface methods 
	


	//Basket Interface methods
	public List<Basket> getFromCart(int userId);
	
	public Basket addToBasket(Basket basket);
	
	public void deleteBasket(int id);

	
	
	
}
