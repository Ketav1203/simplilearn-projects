package com.simplilearn.kitchenStoryFoods.controller;


import com.simplilearn.kitchenStoryFoods.models.Users;
import com.simplilearn.kitchenStoryFoods.service.ProductService;
import com.simplilearn.kitchenStoryFoods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    public int userId;

    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }

    @GetMapping("/logout")
    public String showLogoutPage(){
        return "index";
    }
    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String validateLoginDetails(@RequestParam("email")String email,@RequestParam("password") String password){

        Users user = userService.getUserDetailByEmail(email);
        if(user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)){
            userId=user.getId();
            if(password.equals("admin"))
                return "adminHome";
            return "redirect:/shop";
        }else {
            return "login";
        }
    }

    @GetMapping("/register")
    public ModelAndView showRegisterPage(){

        ModelAndView mv = new ModelAndView();
        mv.addObject("user",new Users());
        mv.setViewName("register");
        return mv;

    }

    @PostMapping("/register")
    public String showLogin(@ModelAttribute("user")Users user){
        userService.saveUser(user);
        return "login";
    }
    @GetMapping("/shop")
    public ModelAndView getShopPage(){

        ModelAndView mv = new ModelAndView();

        mv.addObject("products",productService.getAllProducts());
        mv.setViewName("shop");

        return mv;


    }

    @GetMapping("/shop/highToLow")
    public ModelAndView sortLowToHigh(){

        ModelAndView mv = new ModelAndView();
        mv.addObject("products",productService.getSortedHighToLow());
        mv.setViewName("shop");
        return mv;
    }

    @GetMapping("/shop/lowToHigh")
    public ModelAndView sortHighToLow(){

        ModelAndView mv = new ModelAndView();

        mv.addObject("products",productService.getSortedLowToHigh());
        mv.setViewName("shop");
        return mv;
    }
}
