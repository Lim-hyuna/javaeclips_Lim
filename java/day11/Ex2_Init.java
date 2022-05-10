package day11;

public class Ex2_Init {

	public static void main(String[] args) {
		Test t = new Test(4);
		t.print();
		System.out.println("------------");
		Test2.print();
	}

}

class Test{
	//멤버변수 초기화 순서 -객체멤버
	//1. 타입의 기본값으로 초기화  
	int num1;  //0으로 초기화 
	//2. 명시적 초기화 
	int num2 = 2; //2로 초기화
	int num3 = -1; 
	//3. 초기화 블록을 이용한 초기화 - 잘 사용은 안함  
	{
		num3 = 3; //-1에서 3으로 덮어써져 3으로 초기화 
	}
	int num4 = -1; 
	
	void print() {
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
	}
	//4. 생성자를 이용한 초기화 
	public Test(int num4) {
		this.num4 = num4;  //4로 덮어써짐 
	}
}

class Test2{
	//멤버변수 초기화 순서 -클래스멤버
		//1. 타입의 기본값으로 초기화  
		static int num1;  //0으로 초기화
		//2. 명시적 초기화 
		static int num2 = 2;  //2
		static int num3 = -1;
		//3. 초기화 블록을 이용한 초기화 *static{} 
		static {
			num3 = 3; //-1에서 3으로 덮어써 3으로 초기화!
		}
		public static void print() {
			System.out.println(num1);
			System.out.println(num2);
			System.out.println(num3);
		}
		//생성자 필요없음 객체없이도 클래스멤버를 부를 수 있기때문에
}		
		
		
		