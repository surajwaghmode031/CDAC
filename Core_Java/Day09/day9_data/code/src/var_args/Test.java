package var_args;

public class Test {

	public static void main(String...args) {
		System.out.println("Testing no_args");
		displayNames(); // no args
		System.out.println("Testing with Animal[] array");
		Animal[]pets= {new Cat("mojo"),new Dog("Casper"),new Horse("Speedy")};
		displayNames(pets);
		System.out.println("Testing with comma (,) seperated animals");
		displayNames(new Dog("Bruno"),new Horse("SeaBiscuit"));

	}
	
	// add static method which accept variable number of args and displays the name
	private static void displayNames(Animal...animals) {
		for(Animal a : animals)
			System.out.println(a.getName());
	}

}
