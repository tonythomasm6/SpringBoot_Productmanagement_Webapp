package com.springboot_productmanagement_webapp.productmanagement_webapp.controller;

import com.springboot_productmanagement_webapp.productmanagement_webapp.model.Product;
import com.springboot_productmanagement_webapp.productmanagement_webapp.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class ProductController {

    private Logger log = LoggerFactory.getLogger(ProductController.class);

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String home(){
        log.info("Home page");
        return "index";
    }

    @GetMapping("products")
    public String getProductList(Model model){
        log.info("List products");
        model.addAttribute("products",productRepository.findAll());
        return "list";
    }

    @GetMapping("products/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/products/")
    public String save(Product product){
        log.info("adding new product");
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/products/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        log.info("product to edit is "+id);
        model.addAttribute("product",productRepository.findById(id));
        return "add";
    }

    @GetMapping("/products/delete/{id}")
    public String delete(@PathVariable("id") String id){
        log.info("Product with id "+id+" deleted !!!");
        productRepository.deleteById(id);
        log.info("Product deleted");
        return "redirect:/products";
    }
}
