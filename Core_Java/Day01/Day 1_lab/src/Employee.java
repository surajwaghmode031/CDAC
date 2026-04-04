import java.util.*;
public class Employee{
public static void main(String[]args){
Scanner sc = new Scanner(System.in);
System.out.println("Enter emp id:");
int id = sc.nextInt();
System.out.println("Enter salary:");
double s = sc.nextDouble();
System.out.println("Enter first name:");
String name = sc.next();
System.out.println("emp id: "+id);
System.out.println("emp salary: "+s);
System.out.println("name: "+name);
}
}