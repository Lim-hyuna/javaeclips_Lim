package day12;

public class Ex4_Final {

	public static void main(String[] args) {
		FinalTest ft = new FinalTest();
		ft.print();
		

	}

}
//String은 final 클래스이기 때문에 상속이 불가능 
//class KoreanString extends String{} 에러

class FinalTest{
	private final int max = 30; //final필드 =불변의 객체 
	public void print() {
		//max = 20; //수정X => max는 final이 붙어있기 때문
		System.out.println(max);
	}
}
class FinalTestChild extends FinalTest{
	//print()를 오버라이드 할수 없다 => print()에 final이 붙어있기 때문 
	//public final void print() {}
}


