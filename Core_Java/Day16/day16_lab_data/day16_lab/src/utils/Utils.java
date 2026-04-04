package utils;

import java.util.List;
import java.util.Set;

import fruits.Fruit;
import fruits.Mango;

public interface Utils {
/*add static method in a non generic Utils i/f
 * 	 - to display taste of all fruits from the fruit basket , represented by a List
 */ 
	static void displayTastes(List<? extends Fruit> basket)
	{
			basket.forEach(f -> f.taste());
	}
	/* after type erasure
	 * static void displayTastes(List basket)
	{
			basket.forEach((Fruit f) -> f.taste());
	}
	 */
	/*
	 * Write a static method in a non generic Utils interface 
 - to get sum of all numbers(integer | double | float | byte ..), stored in the Set .
	 */
	static double sumOfNumbers(Set<? extends Number> numbers)
	{
		double sum=0;
		for (Number n : numbers) {
			sum += n.doubleValue();
		}
		return sum;
	}
	/*
	 * Write a static method in a non generic Utils interface , which can add ONLY Mangoes(i.e Mango , Alphonso,Kesar ...)  to a fruit basket: List
Test cases - ArrayList<Fruit> .

	 */
	static void addMangoes(List<? super Mango> basket,Mango ...mangos)
	{
		for(Mango m : mangos)
			basket.add(m);
	}
 

}
