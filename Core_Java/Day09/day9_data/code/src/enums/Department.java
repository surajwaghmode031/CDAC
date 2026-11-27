package enums;

/*
 * enums are internally public final class extends by  Enum from java.lang.Enum 
 * 
 *    public final class Department extends Enum{
 *    
 *    // construcor 
 *    private Department(String s, int i)   // String s : name of constant   , int i : ordinal (index no)
 *    {
 *    super(s,i)
 */

public enum Department {
	//typically enums have : set of related constants
	RND, FINANCE, MARKETING,HR,PRODUCTION;  // internally public static final
	
	// can you override toString() in your enum? : yes
//	@Override
//	public String toString() {
//		return name().toLowerCase();
//	}
//	

}
