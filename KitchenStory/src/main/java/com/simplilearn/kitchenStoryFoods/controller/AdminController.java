package com.simplilearn.kitchenStoryFoods.controller;

import com.simplilearn.kitchenStoryFoods.models.Products;
import com.simplilearn.kitchenStoryFoods.service.ProductService;
import com.simplilearn.kitchenStoryFoods.service.PurchaseService;
import com.simplilearn.kitchenStoryFoods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class AdminController {

    public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/productImages";
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    PurchaseService purchaseService;

    //Admin module
    @GetMapping("/admin")
    public String getAdminPage(){

        return "adminHome";

    }

    //Users Module
    @GetMapping("/admin/userData")
    public ModelAndView getUserData(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",userService.getAllUsers());
        mv.setViewName("userData");
        return mv;

    }


    @GetMapping("/admin/userData/sort")
    public ModelAndView sortingOfUsers(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",userService.findAllUsersOrderByName());
        mv.setViewName("userData");
        return mv;
    }
    @GetMapping("/admin/users/delete/{id}")
    public String deleteUser(@PathVariable int id){

    return "redirect:/admin/userData";
    }

    // Product module
    @GetMapping("/admin/products")
    public ModelAndView getProductData(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("products",productService.getAllProducts());
        mv.setViewName("products");
        return mv;

    }

    @PostMapping("/admin/products/add")
    public String addProductData(@ModelAttribute Products product, @RequestParam("productImage")MultipartFile multipartFile, @RequestParam("imageName") String imageName) throws IOException {

        String imageUUID;

        if(!multipartFile.isEmpty()){

            imageUUID = multipartFile.getOriginalFilename();

            Path filenameAndPath = Paths.get(uploadDir,imageUUID);
            Files.write(filenameAndPath,multipartFile.getBytes());

        }else{

            imageUUID = imageName;
        }
        product.setImageName(imageUUID);
        productService.saveProduct(product);
        return "redirect:/admin/products";

    }

    @GetMapping("/admin/products/add")
    public ModelAndView productAdded(){

        ModelAndView mv = new ModelAndView();
        mv.addObject("product", new Products());
        mv.setViewName("productsAdd");

        return mv;

    }


    //purchase module

    @GetMapping("/admin/purchaseData")
    public ModelAndView getPurchaseDetails(){

        ModelAndView mv = new ModelAndView();
        mv.addObject("purchases",purchaseService.getPurchaseData());
        mv.setViewName("purchaseReport");
        return mv;
    }


    @GetMapping("/admin/purchase/sortByName")
    public ModelAndView getPurchaseDetailsSortByName(){

        ModelAndView mv = new ModelAndView();
        mv.addObject("purchases",purchaseService.getPurchaseDataSortedWithName());
        mv.setViewName("purchaseReport");
        return mv;
    }

    @GetMapping("/admin/purchase/sortByPrice")
    public ModelAndView getPurchaseDetailsSortByPrice(){

        ModelAndView mv = new ModelAndView();
        mv.addObject("purchases",purchaseService.getPurchaseDataSortedWithPrice());
        mv.setViewName("purchaseReport");
        return mv;
    }
}
