package com.cst.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst.store.entity.Product;
import com.cst.store.model.ProductInfo;
import com.cst.store.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo prepo;
	
	public void saveProduct(ProductInfo pinfo) {
		
		Product product = new Product();
		
		product.setPname(pinfo.getPname());
		
		product.setQuantity(pinfo.getQuantity());
		
		product.setPrice(pinfo.getPrice());
		
		prepo.save(product);
		
	}
	
    public void updateProduct(ProductInfo pinfo) {
		
		Product product = prepo.getById(pinfo.getPid());
		
		product.setPname(pinfo.getPname());
		
        product.setQuantity(pinfo.getQuantity());
		
		product.setPrice(pinfo.getPrice());		
		
		prepo.save(product);
		
	}
	
	public void deleteProduct(ProductInfo pinfo) {
		
		Product product = prepo.getById(pinfo.getPid());
		
		prepo.delete(product);
		
	}

//	public void deleteProductUsingButton(Long pid) {
//		
//		Product product = prepo.getById(pid);
//		
//		prepo.delete(product);
//	}

}
