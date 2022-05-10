package day11;

import day11_1.Ex5_B; //day11_1.* 모든 클래스를 가져온다는 뜻 '*'모든이란 뜻으로 해석가능


public class Ex5_AccessModifier {

	public static void main(String[] args) {
		Ex5_A t1 = new Ex5_A();
		//public은 모두 사용 가능
		System.out.println(t1.num1);
		//default는 같은 패키지내에서 사용 가능
		System.out.println(t1.num2);
		//private은 내 클래스에서만 사용 가능 
		// System.out.println(t1.num3); //에러발생
		
		//import로 불어오면 가능 
		Ex5_B t2 = new Ex5_B();
		//public은 모두 사용 가능
		System.out.println(t2.num1);
		//default는 같은 패키지내에서 사용 가능한데//패키지가 달라서 에러 발생
		//System.out.println(t2.num2);
		//private은 내 클래스에서만 사용 가능 
		// System.out.println(t2.num3); //에러발생

		//public int num = 1; /에러발생 /지역변수라 접근제한자 X
		
	}
	public int num = 1; //가능함 접근제한자는 지역변수에는 붙을 수 없음 

}
