class Box1 {
    int l, b, h;

    Box1(int l, int b, int h) {   // constructor name must match class name 
        this.l = l;                // no return type not even void : constructor implicitly return address of current reference type of object 
        this.b = b;
        this.h = h;
    }
}

public class TestBox1 {
    public static void main(String[] args) {
        Box1 b1 ;   // b1 refrance type object create on stack and  0 object create on heap 
        b1= new Box1(1, 2, 3); //  1 object create on heap
        Box1 b2 = b1;
        b1 = new Box1(3, 4, 5);   // 0 objects eligible for GC
        Box1 b3 = b1;
        b2 = new Box1(4, 5, 6);   // 1 object eligible for GC
    }
}
