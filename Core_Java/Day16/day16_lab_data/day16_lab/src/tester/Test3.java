package tester;

import java.util.TreeSet;
import static utils.Utils.*;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * Write a static method in a non generic Utils interface 
 - to get sum of all numbers(integer | double | float | byte ..), stored in the Set .
Test cases - HashSet<Integer> , LinkedHashSet<Double> , TreeSet<Long>

		 */
		TreeSet<Long> longSet=new TreeSet<>();
		longSet.add(123l);
		longSet.add(12l);
		longSet.add(1235678l);
		sumOfNumbers(longSet);
		

	}

}
