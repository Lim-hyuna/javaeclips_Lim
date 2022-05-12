package day12;

public class Ex1_Inheritance1 {

	public static void main(String[] args) {
		Child c = new Child();
		c.x= 10;
		c.y= 20; //같은 패키지라 사용가능 
		// c.z= 30; //private라 안됨
		c.setZ(30); //setter 이용해서 필드값 적용가능 
		
		

	}

}
//코드 중복을 줄이기 위해 상속을 사용함 
class Parent{
	//아무나 공용-자식클랙스도 호출가능 
	public int x;
	//자식에게만 물려줌 
	protected int y;
	//물려주기는 하나 접근제한이 있음 
	private int z;
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	public Parent(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
}

class Child extends Parent{
	//부모 필드 x,y,z
    //본인필드 
	private int s;
	public void print() {
		System.out.println(x); //public : 전부 호출가능
		System.out.println(y); //protected : 나+ 같은 패키지+자식 사용가능 
		System.out.println(getZ()); //z에 직접적으로 접근할 수 없기 때문에 getter를 이용하여 접근 
		//System.out.println(z); //private : 나만 쓸수있음 에러발생 
		System.out.println(s);

	}
	public Child() {
		//자식생성자에 부모생성자가 첫번째줄로 와야함
		//super(0,0,0);
		//this(0,0,0,0); 같이 쓸수 없음 super를 또 호출되기 때문에 super는 한번만 호출됨 
		this(0,0,0,0); //super(0,0,0); //this()생성자와 super()생성자는 같이 쓸 수 없다 => this()에서 부모생성자를 이미 호출했기 때문
	}
	//생성자 
	public Child(int x, int y, int z, int s) {
		super(x,y,z);
		this.s = s;
	}
}