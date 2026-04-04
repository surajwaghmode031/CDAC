package com.shop.tester;

import static com.shop.utils.ShopUtils.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.shop.core.Product;

public class Test5 {

	public static void main(String[] args) {
		// get product list
		List<Product> products = populateProductList();
		// display all products - FP
		products.forEach(p -> System.out.println(p));// internal iteration
		// custom ordering using anonymous inner class
//		Collections.sort(products, new Comparator<Product>() {
//
//			@Override
//			public int compare(Product o1, Product o2) {
//				// TODO Auto-generated method stub
//				return o1.getManufactureDate().compareTo(o2.getManufactureDate());
//			}
//
//		});
		//list , comparator
		Collections.sort(products,(p1,p2) -> p1.getManufactureDate().compareTo(p2.getManufactureDate()) );
		
		System.out.println("Sorted List");
		products.forEach(p -> System.out.println(p));
		

	}

}
