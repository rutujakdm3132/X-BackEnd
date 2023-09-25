package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BasketRepository;
import com.dao.ProductRepository;
import com.dao.UserRepository;
import com.exception.NoSuchProductExist;
import com.exception.NoSuchUserExist;
import com.model.Basket;

import com.model.Product;

import com.model.User;

@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	UserRepository userRepo;

	@Autowired
	ProductRepository productRepo;

	@Autowired
	BasketRepository basketRepo;

	// User service Operations
	@Override
	public User insertData(User u) {
		return userRepo.save(u);
	}

	public User findByEmailIdAndPassword(String email, String password) {

		return userRepo.findByEmailIdAndPassword(email, password);
	}



	@Override
	public User getOneUser(int id) {
		return userRepo.findById(id).orElseThrow(() -> new NoSuchUserExist("User does not exist with id: " + id));
	}

	@Override
	public String deleteOneUser(int id) {
		userRepo.deleteById(id);
		return "User Deleted " + id;
	}

	@Override
	public User updateUserName(User u, int id) {
		User existingUserName = userRepo.findById(id)
				.orElseThrow(() -> new NoSuchUserExist("User does not exist with this id"));
		// existingUserName.setUsername(u.getUsername());
		// existingUserName.setPassword(u.getPassword());
		if (u.getUsername() != null) {
			existingUserName.setUsername(u.getUsername());
		} else if (u.getPassword() != null) {
			existingUserName.setPassword(u.getPassword());
		} else if (u.getMobile() != 0) {
			existingUserName.setMobile(u.getMobile());
		} else if (u.getFullName() != null) {
			existingUserName.setFullName(u.getFullName());
		} else if (u.getEmail() != null) {
			existingUserName.setEmail(u.getEmail());
		}
		return userRepo.save(existingUserName);
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	// Product service Operations
	@Override
	public Product insertProduct(Product p) {
		return productRepo.save(p);
	}

	@Override
	public String deleteOneProduct(int id) {
		productRepo.deleteById(id);
		return "Product Deleted " + id;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> list = productRepo.findAll();
		return list;
	}

	@Override
	public Product getOneProduct(int id) {
		return productRepo.findById(id)
				.orElseThrow(() -> new NoSuchProductExist("Product does not exist with id: " + id));
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return productRepo.findByCategory(category);
	}

	@Override
	public List<Product> getProductsByCity(String city) {
		return productRepo.findByCity(city);
	}

	@Override
	public List<Product> getProductsByCompany(String pCompany) {
		return productRepo.findBypCompany(pCompany);
	}

	// LogIn service operations

	// Basket service operations

	@Override
	public List<Basket> getFromCart(int userId) {
		return basketRepo.findBasketByUserId(userId);
	}

	@Override
	public Basket addToBasket(Basket basket) {
		return basketRepo.save(basket);
	}

	@Override
	public void deleteBasket(int id) {

	}

}
