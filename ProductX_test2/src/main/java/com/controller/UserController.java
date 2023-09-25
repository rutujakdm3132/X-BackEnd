package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Basket;

import com.model.Product;
import com.model.User;
import com.service.UserServiceInterface;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	UserServiceInterface userService;
	
	//UserControllerOperaions	
	@PostMapping("/save")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		
		User u= userService.insertData(user) ;
		
		return ResponseEntity.status(HttpStatus.CREATED).header("Add","User created").body(u);
	}
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) throws Exception
	{
		String tempEmail =user.getEmail();
		if(tempEmail !=null && !"".equals(tempEmail)) {
			User userObj=userService.getUserByEmail(tempEmail);
			if(userObj!=null) {
				throw new Exception("User with "+tempEmail+" is already exit");
			}
		}
		User userObj1=null;
		userObj1=userService.insertData(user);
		return userObj1;
	}
	@PostMapping("/loginUser")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmail=user.getEmail();
		String tempPass=user.getPassword();
		User userObj=null;
		if(tempEmail !=null && tempPass!=null) {
			userObj=userService.findByEmailIdAndPassword(tempEmail, tempPass);
		}
		if(userObj==null) {
			throw new Exception("Bad Creadentials");
		}
		return userObj;
	}

	@GetMapping("get/{id}")
	public User findOneUser(@PathVariable int id) {
		return userService.getOneUser(id);
	}

	@DeleteMapping("delete/{id}")
	public String deleteOneUser(@PathVariable int id) {
		return userService.deleteOneUser(id);
	}

	@PutMapping("update/{id}")
	public User updateUserName(@RequestBody User u,@PathVariable int id) {
		return userService.updateUserName(u,id);
	}

	@GetMapping("/find/{email}")
	public User getUser(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}
	
	//ProductControllerOperaions
	
	@PostMapping("/addproduct")
	public Product insertProduct(@RequestBody Product p) {
		return userService.insertProduct(p);
	}

	@DeleteMapping("delete/product/{pId}")
	public String deleteOneProduct(@PathVariable int pId) {
		return userService.deleteOneProduct(pId);
	}
	
	@GetMapping("getall/products")
	public List<Product> getAllProduct() {
		List<Product> list = userService.getAllProduct();
		return list;
	}
	
	@GetMapping("getproduct/{pId}")
	public Product findOneProduct(@PathVariable int pId) {
		return userService.getOneProduct(pId);
	}
	
	 @GetMapping("/byCategory/{category}")
	    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
	        List<Product> products = userService.getProductsByCategory(category);
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }
	
	 @GetMapping("/byCity/{city}")
	    public ResponseEntity<List<Product>> getProductsByCity(@PathVariable String city) {
	        List<Product> products = userService.getProductsByCity(city);
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }
	 
	 @GetMapping("/byCompany/{pCompany}")
	    public ResponseEntity<List<Product>> getProductsByCompany(@PathVariable String pCompany) {
	        List<Product> products = userService.getProductsByCompany(pCompany);
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }

	
	//LogIn controller
	
	

	
	//Basket Controller
	
	@GetMapping("/getuserbasket/{userId}")
	public List<Basket> getFromBasket(@PathVariable int id) {
		return userService.getFromCart(id);
	}

	@PostMapping("/addtobasket")
	public Basket addToBasket(@RequestBody Basket basket) {
		return userService.addToBasket(basket);
	}

	@DeleteMapping("deletebasket/{id}")
	public void deleteBasket(@PathVariable int id) {
		userService.deleteBasket(id);
		
	}

}
