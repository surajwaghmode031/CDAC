import java.util.*;
public class Season{
public static void main(String[]args){
Scanner sc = new Scanner(System.in);
System.out.println("Enter mounth (1-12):");
int mounth = sc.nextInt();
switch(mounth){
case 3 :
case 4 :
case 5 :
case 6 :
       System.out.println("Summer..!");
       break;
case 7 :
case 8 :
case 9 :
case 10 :
         System.out.println("Monsoon..!");
         break;
case 11 :
case 12 :
case 1 :
case 2 :
        System.out.println("Winter..!");
        break;
default:
      System.out.println("Invalid mounth..!");
}
}
}
     

