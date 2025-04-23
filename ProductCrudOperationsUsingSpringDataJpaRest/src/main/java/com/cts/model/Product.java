package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity  // creating the table by default name (product)
@Table(name = "productinfo") //create the table by the user defined name

@Data

public class Product {


	public Product(String productName, int productPrice, String productCategory, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}
	@Id  // declaring primary key --> mandatory 
	@Column(name = "pid") // column name by the user defined name --> optional
	@GeneratedValue   // auto generate value --> optional
	private int productId;
	@NotBlank(message="poduct null or blank cannot be used try again!!!") // not allow " "
	//@NotNull
	//@NotEmpty -> not allow "" , " "
	private String productName;
	@Column(name = "price")
	@Min(value=100,message= "ProductPrice must be above 100")
	@Max(value=1000,message= "ProductPrice must be below 100")
	private int productPrice;
	
	@Size(min=5,max=12 , message="should be have min and max range")
	private String productCategory;
	@Column(name = "quantity")
	@Positive(message ="Quantity cannot to close")
	private int productQuantity;
 
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
}
