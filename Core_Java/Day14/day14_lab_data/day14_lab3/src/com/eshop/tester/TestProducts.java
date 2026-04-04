/*
 * Given - 2 products are equal iff
 *  - product id  & category is same
 *  - example of composite UID 
 *  Follow mandatory as well as optional part of the contract
 */
package com.eshop.tester;

import com.eshop.core.Product;
import static com.eshop.core.Category.*;

import java.util.HashSet;

public class TestProducts {

	public static void main(String[] args) {
		Product product1 = new Product(101, "Bread", FOOD, 100, 50);
		Product product2 = new Product(10, "Biscuits", FOOD, 100, 50);
		Product product3 = new Product(101, "Bread", FOOD, 100, 50);
		Product product4 = new Product(10, "Sunflower Oil", OIL, 100, 50);
		Product product5 = new Product(101, "Rice", GRAINS, 100, 50);
		// add these products to the HashSet .
		// Expected o/p - products - 1,2,4,5 should get added & 3rd product should not
		// get
		// added.
		HashSet<Product> products=new HashSet<>();
		System.out.println(products.add(product1));
		System.out.println(products.add(product2));
		System.out.println(products.add(product3));
		System.out.println(products.add(product4));
		System.out.println(products.add(product5));
		System.out.println(products.size());

	}

}
