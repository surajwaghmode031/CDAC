package tester;

import java.util.ArrayList;
import java.util.List;
import static utils.Utils.*;

import fruits.Apple;

public class Test2 {

	public static void main(String[] args) {
		// ArrayList<Apple>  , LinkedList<Orange> , Vector<Mango>
		//below is ok 
//		ArrayList<Apple> apples=new ArrayList<>();
//		apples.add(new Apple());
//		apples.add(new Apple());
//		apples.add(new Apple());
//OR 
		ArrayList<Apple> apples=new ArrayList<>(List.of(new Apple(),new Apple(),new Apple()));
		displayTastes(apples);
		
	}

}
