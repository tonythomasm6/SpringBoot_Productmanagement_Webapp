package com.springboot_productmanagement_webapp.productmanagement_webapp.boot;

import com.springboot_productmanagement_webapp.productmanagement_webapp.model.Product;
import com.springboot_productmanagement_webapp.productmanagement_webapp.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class startup implements CommandLineRunner { // Implements commandline runner to implement run on startup of app

    private ProductRepository productRepository;

    private Logger log = LoggerFactory.getLogger(startup.class);

    @Autowired // Product repository autowired to access database methods.
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override // Method implemented by implementing CommandLineRunner which will be called on startup.
    public void run(String... args) throws Exception {
        log.info("In run method");
        //Saving first product
        Product p = new Product();
        p.setName("Dell XPS");
        p.setCategory("Laptop");
        p.setDescription("Dell top tier laptop");
        p.setPrice(3000);
try {
    //productRepository.save(p);
    //log.info("Product p saved !!!");
}
catch(Exception e){
    log.info("Exception caught on saving product :"+e);
}
        //Saving second product
 try {
    // productRepository.save(new Product("Nikon D500", "Camera", "DSLR camera", 1500));
     //log.info("Second product saved !!!");
 }
 catch(Exception e){
     log.info("Exception caught on saving product 2 "+e);
 }

    }
}
