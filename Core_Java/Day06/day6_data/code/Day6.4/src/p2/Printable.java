package p2;

public interface Printable {
	// javc adds : public static final -> implicitly
	double TEST_DATA= 123.45;
	
	// javac add : public abstract -> specification 
	void print(String msg) ;
}
