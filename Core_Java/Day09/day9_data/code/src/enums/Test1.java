package enums;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			//System.out.println("valid departments choose from:"+Department.values()); // Department.values() : return array enum 
			                                                                         // o/P : [Lenums.Department;@5f184fc6
			System.out.println("valid departments choose from:"+Arrays.toString(Department.values()));
			
			System.out.println("Enter department name: ");
			Department selectedDepartment= Department.valueOf(sc.next().toUpperCase());
			//=> parsing (string --> enum): success
			
			System.out.println("you chose : "+selectedDepartment);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
