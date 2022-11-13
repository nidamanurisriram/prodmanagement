package com.cst.store.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cst.store.entity.Product;
import com.cst.store.model.ProductInfo;
import com.cst.store.repository.ProductRepo;
import com.cst.store.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductControl {

	@Autowired
	ProductService pservice;
	
	@Autowired
	ProductRepo prepo;

	@GetMapping
	public ModelAndView indexPage() {
		
		ModelAndView model = new ModelAndView("Index");
		
		return model;
		
	}
	
	@GetMapping("/application")
    public ModelAndView appPage() {
		
		ModelAndView model = new ModelAndView("Application");
		
		return model;
		
	}
	
	@GetMapping("/updation")
    public ModelAndView updatePage( ModelAndView model) {
		
	    model = new ModelAndView("Update");
		
		return model;
		
	}
	
	@GetMapping("/viewProduct")
        public ModelAndView viewProduct() {
		
		ModelAndView model = new ModelAndView("Product");
		
		List<Product> product = prepo.findAll();
		
		model.addObject("product", product);
		
		return model;
		
	}
	
	@PostMapping("/saveProduct")
	public ModelAndView saveProduct(@ModelAttribute ProductInfo pinfo) {
		
		ModelAndView model = new ModelAndView("redirect:/product/viewProduct");
		
		pservice.saveProduct(pinfo);
		
		return model;
		
	}
	
	@PostMapping("/updateProduct")
	public ModelAndView updateProduct(@ModelAttribute ProductInfo pinfo) {
		
		ModelAndView model = new ModelAndView("redirect:/product/viewProduct");
		
		pservice.updateProduct(pinfo);
		
		return model;
		
	}
	
	@GetMapping("/deleteProduct")
	
	    public ModelAndView deleteProduct(@ModelAttribute ProductInfo pinfo) {
		
		ModelAndView model = new ModelAndView("redirect:/product/viewProduct");
		
		pservice.deleteProduct(pinfo);
		
		return model;
		
	}
	
	@PostMapping("/updateStudentUsingEditButton")
	
       public ModelAndView updateProductUsingButton( @ModelAttribute ProductInfo pinfo, ModelAndView model) {
		
		Product product = this.prepo.getById(pinfo.getPid());
		
		product.setPname(pinfo.getPname());
		
		product.setPrice(pinfo.getPrice());
		
		product.setQuantity(pinfo.getQuantity());
		
		this.prepo.save(product);
		
        model = new ModelAndView("redirect:/product/viewProduct");
		
		return model;
	}
	
	@GetMapping("/deleteproductUsingDeleteButton/{pid}")
	
	public ModelAndView deleteProductUsingButton(@PathVariable long pid, ModelAndView model) {
		
		Optional<Product> product = this.prepo.findById(pid);
		
		this.prepo.delete(product.get());
		
        model = new ModelAndView("redirect:/product/viewProduct");
		
		return model;
	}
	
}
