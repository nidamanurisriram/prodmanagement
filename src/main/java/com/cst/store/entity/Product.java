package com.cst.store.entity;

import javax.persistence.*;

import lombok.*;  

@Data
@Entity
@Table(name="product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
	private Long pid;
    
    @Column
	private String pname;
	
    @Column
	private Long quantity;
	
    @Column
	private Double price;
	
	public Product(String pname, Long quantity, Double price) {
		super();
		this.pname = pname;
		this.quantity = quantity;
		this.price = price;
	}
	
}
