import java.util.*;
public class Compare{
public static void main(String[]args){
Scanner sc = new Scanner(System.in);
System.out.println("Enter numbers:");
int num1 = sc.nextInt();
int num2 = sc.nextInt();
if(num1>num2)
System.out.println("num1 is greater");
else if(num1<num2)
System.out.println("num2 is greater");
else
System.out.println("num1 and num2 are equal");
}
}