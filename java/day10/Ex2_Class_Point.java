package day10;

public class Ex2_Class_Point {

	public static void main(String[] args) {
		//객체메소드여서 클래스 이름으로 호출할 수 없다
		//Point.print(); =>에러발생 
		//print()메소드는 객체 메소드이기 때문에 객체를 생성 후 호출해야 한다.
		Point1 p1 = new Point1(10,20);
		p1.print();
		//printDimensional() 메소드는 클래스 메소드이기 때문에 클래스 이름으로 호출할 수 있다.
		Point1.printDimensional();
		//클래스 메소드는 객체를 이용하여 호출할 수 있지만 경고가 뜬다.
		p1.printDimensional();
		
		System.out.println();
	}

}

class Point1{
	//클래스변수
	static String dimensional="이차원";
	
	//필드객체 
	int x, y;
	
	//this.필드명 -> 나자신 [객체] 참조변수  
	public Point1(int x, int y){
		//내 필드 x,y에 매개변수 x,y의 값을 저장 
		//this.필드변수 ->매개변수명과 필드명 같을 때 사용 
		this.x = x;
		this.y = y;
		
	}
	
	//this() 내생성자 => 이미 만들어진 생성자를 호출하면 코드가 줄어드는 경우 사용
	//생성자가 중복된 코드 발생(오버로딩) => 코드의 길이를 줄이기위해서 사용함 
	//this()는 다른생성자에서 **첫번째줄에서 사용!
	public Point1(){
		this(0,0);
	}
	//메소드안에 객체변수가 있으면 클래스변수가 있어도 static을 붙이지 않는다
	public void print() {
		System.out.println("차원 : " + dimensional);
		System.out.println("좌표 : " + x + ", " + y);
	}
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//메소드안에 클래스변수만 있을때는 static 붙여도됨 
	public static void printDimensional() {
		System.out.println("차원 : " + dimensional);
	}
}