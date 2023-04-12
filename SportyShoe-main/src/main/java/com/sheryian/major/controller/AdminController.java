package com.sheryian.major.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sheryian.major.dto.ProductDTO;
import com.sheryian.major.model.Category;
import com.sheryian.major.model.Product;
import com.sheryian.major.repository.UserRepository;
import com.sheryian.major.service.CategoryService;
import com.sheryian.major.service.ProductService;
import com.sheryian.major.service.UserService;

@Controller
public class AdminController {
	public static String uploadDir= System.getProperty("user.dir")+"/src/main/resources/static/productImages";   //System.getProperty("user.dir"): ye apko root folder(src) tak ka path dega,ye btayega ki apka applicatio kha hai
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;

	@GetMapping("/admin")
	public String adminHome() {
		return "adminHome";
	}

	@GetMapping("/admin/categories")
	public String getCat(Model model) {
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categories";
	}

	@GetMapping("/admin/categories/add") // get request from categories.html
	public String getCatAdd(Model model) {
		model.addAttribute("category", new Category());
		return "categoriesAdd";
	}

	@PostMapping("/admin/categories/add") // get request from categories.html
	public String postCatAdd(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}

	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCat(@PathVariable int id) {
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
	}

	@GetMapping("/admin/categories/update/{id}")
	public String updateCat(@PathVariable int id, Model model) {
		Optional<Category> category = categoryService.getCategoryById(id);
		if (category.isPresent()) {
			model.addAttribute("category", category.get()); 			
			return "categoriesAdd";
		} else {
			return "404";
		}
	}
	
	// product Section
	@GetMapping("/admin/products")
	public String products(Model model) {
		model.addAttribute("products",productService.getAllProduct());	
		return "products";
	}
	
	// Opens product add
	@GetMapping("/admin/products/add")
	public String productAddGet(Model model) {
		model.addAttribute("productDTO",new ProductDTO());              
		model.addAttribute("categories", categoryService.getAllCategory());	   
	return "productsAdd";
	}
	
	// for submit in product add
	@PostMapping("/admin/products/add")
	public String productAddPost(@ModelAttribute("productDTO") ProductDTO productDTO,
								@RequestParam("productImage") MultipartFile file,
								@RequestParam ("imgName") String imgName) throws IOException {
		
		
		Product product=new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
		product.setPrice(productDTO.getPrice());
		product.setWeight(productDTO.getWeight());
		product.setDescription(productDTO.getDescription());
		
		
		String imageUUID;
		if(!file.isEmpty()) {
			imageUUID =file.getOriginalFilename();        // get the name of file
			Path fileNameAndPath =Paths.get(uploadDir, imageUUID);      // gives name and path of file
			Files.write(fileNameAndPath, file.getBytes());              
		}else{                                       
	
			imageUUID=imgName;
		}
		product.setImageName(imageUUID);  
		productService.addProduct(product);
		return "redirect:/admin/products";
	}
	
	
	@GetMapping("/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		productService.removeProductById(id);
		return "redirect:/admin/products";
	}
	
	@GetMapping("/admin/product/update/{id}")
		public String updateProductGet(@PathVariable long id, Model model) {
		Product product =productService.getProductById(id).get();
		
		ProductDTO productDTO =new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setCategoryId((product.getCategory().getId()));
		productDTO.setPrice(product.getPrice());
		productDTO.setWeight((product.getWeight()));
		productDTO.setDescription(product.getDescription());
		productDTO.setImageName(product.getImageName());
		
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("productDTO", productDTO);  
		
		return "productsAdd";
		
	}

	
	// USER SECTION: list of Users
		@GetMapping("/admin/users")
		public String users(Model model) {
			model.addAttribute("users",userService.getAllUser());	
			return "users";
		}
		
		@GetMapping("/admin/user/delete/{id}")    
		public String deleteUser(@PathVariable int id) {
			userService.removeUserById(id);
			return "redirect:/admin/users";
		}
	
	
	
}
	





