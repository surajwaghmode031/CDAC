package com.shop.tester;

import static com.shop.utils.ShopUtils.*;

import java.util.Map;

import com.shop.core.Category;
import com.shop.core.Product;

public class Test4 {

	public static void main(String[] args) {
		// get populated Map of products
		Map<Integer, Product> productMap = populateProductMap(populateProductList());
		//display the map entries ........
		System.out.println("All products");
		productMap.forEach((k,v) -> System.out.println(v));
		Category category=Category.BISCUITS;
		//remove all products from Category.BISCUITS .....
		productMap.values().removeIf(p -> p.getProductCategory()==category);		
		//display map again
		System.out.println("Map again -");
		productMap.forEach((k,v) -> System.out.println(v));
	}

}
