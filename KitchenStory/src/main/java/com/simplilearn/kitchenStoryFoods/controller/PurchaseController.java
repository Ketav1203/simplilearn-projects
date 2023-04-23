package com.simplilearn.kitchenStoryFoods.controller;


import com.simplilearn.kitchenStoryFoods.models.Products;
import com.simplilearn.kitchenStoryFoods.models.Purchase;
import com.simplilearn.kitchenStoryFoods.models.Users;
import com.simplilearn.kitchenStoryFoods.service.ProductService;
import com.simplilearn.kitchenStoryFoods.service.PurchaseService;
import com.simplilearn.kitchenStoryFoods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PurchaseController {

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    PurchaseService purchaseService;
    @Autowired
    HomeController homeController;

    @GetMapping("/shop/addToCart/{id}")
    public ModelAndView addTOCart(@PathVariable("id")Long id){

        Products product = productService.findProductById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("cart",product);
        mv.setViewName("cart");
        return mv;
    }

    @GetMapping("/checkout/{id}")
    public ModelAndView addTOCheckout(@PathVariable("id")Long id){

        Products product = productService.findProductById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("cart",product);
        mv.setViewName("checkout");
        return mv;
    }

    @PostMapping("/payNow/{id}")
    public ModelAndView generateReceipt(@PathVariable("id")Long id){

        Users user = userService.findUserById(homeController.userId);
        Products product = productService.findProductById(id);
        Purchase purchase = new Purchase();
        purchase.setName(user.getFirstName()+" "+user.getLastName());
        purchase.setPrice(product.getPrice());
        purchase.setProduct(product.getName());
        purchase.setQuantity(1);
        purchaseService.savePurchaseData(purchase);

        ModelAndView mv = new ModelAndView();
        mv.addObject("cart",product);
        mv.setViewName("orderPlaced");
        return mv;
    }

}
