class Sum
{
public static void main(String[]args)
{
// parse convert string into double 
double num1= Double.parseDouble(args[0]);
double num2= Double.parseDouble(args[1]);
System.out.println("sum" +(num1+num2));
//typecast- we cannot cast string into doublr
//double num1=(double)args[0]; // gives error

}
}