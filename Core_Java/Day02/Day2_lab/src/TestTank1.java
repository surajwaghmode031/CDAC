class Tank{
private int level;

public Tank(int level){
this.level=level;
}

  // setter
public void setLevel(int level1){
level= level1;
}

  // getter
public int getLevel(){
return level;
}
}
public class TestTank1{
public static void main(String[]args){

Tank t1 = new Tank(10);
Tank t2 = new Tank(20);
System.out.println("1: t1.level: " + t1.getLevel() + ", t2.level: " + t2.getLevel());
t1=t2;
System.out.println("1: t1.level: " + t1.getLevel() + ", t2.level: " + t2.getLevel());
t1.setLevel(27);
t1.setLevel(t1.getLevel()+10);

System.out.println("1: t1.level: " + t1.getLevel() + ", t2.level: " + t2.getLevel());
System.out.println("1: t1.level: " + t1.getLevel() + ", t2.level: " + t2.getLevel());
}
}
