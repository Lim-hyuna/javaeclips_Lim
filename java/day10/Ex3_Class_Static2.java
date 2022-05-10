package day10;

import day11.Ex1_Class_Student;

public class Ex3_Class_Static2 {
	public static void main(String[] args) {
		//클래스를 호출하면 메모리가 올라옴 
		
		Ex1_Class_Student t1 = new Ex1_Class_Student();
		//t1.printX();
		Ex1_Class_Student t2 = new Ex1_Class_Student();
		Ex1_Class_Student t3 = new Ex1_Class_Student();
		//Ex5_Test1.printCount();
		//sum()에 static이 없을 경우 Ex3_Class_Static2 객체를 생성후 사용가능  
		/*sum()은 객체 메소드이기 때문에 클래스 메소드인 main에서 호출하려면 
		 객체를 생성한 후, 객체를 통해 호출해야한다. */
		Ex3_Class_Static2 ex3 = new Ex3_Class_Static2();
		System.out.println(ex3.sum(1,2));
	}
	public int sum(int num1, int num2) {
		return num1 + num2;
	}
}

class Test1{
	int x;
	static int count;//Test1 클래스로 만들어진 객체의 수 
	
	void printX() {
		System.out.println(x);
	}
	static void printCount() {
		System.out.println(count);
	}
	public Test1() {count++;}
}