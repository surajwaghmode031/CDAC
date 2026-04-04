import java.util.*;
class PrintAverage{
public static void main(String[]args){
Scanner sc = new Scanner(System.in);
System.out.println("Enter 5 numbers:");
int n1 = sc.nextInt();
int n2 = sc.nextInt();
int n3 = sc.nextInt();
int n4 = sc.nextInt();
int n5 = sc.nextInt();

int average = (n1+n2+n3+n4+n5)/5;
System.out.println(average);
}
}