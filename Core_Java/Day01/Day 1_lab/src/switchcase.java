import java.util.*;
class switchcase{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.println("Enter two numbers:");
int n1 = sc.nextInt();
int n2 = sc.nextInt();
int result;
System.out.println(" 0.exit\n 1.Addition\n 2.Substaction\n 3.Multipication\n 4.Division\n");
System.out.println("Enter choicer:");
int choice= sc.nextInt();
if(choice!=0)
{
switch(choice){
case 1: System.out.println("---Addition---");
       result=n1+n2;
       System.out.println(result);
break;
case 2: System.out.println("---Substraction---");
       result=n1-n2;
       System.out.println(result);
       break;
case 3: System.out.println("---Multipication---");
       result=n1*n2;
       System.out.println(result);
       break;
case 4: System.out.println("---division---");
       result=n1/n2;
       System.out.println(result);
       break;
default:
      System.out.println("Invalid CAhoice....!");
}
}
}
}


       
       
