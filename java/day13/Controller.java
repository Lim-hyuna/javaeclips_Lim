package day13;

//인터페이스선언 
public interface Controller {
	/* 상수-필드 선언 : 
	 * 타입 상수명 = 값; 상수명은 관례로 대문자! */
	/*public static final*/ int NUM=19; //NUM은 꼭 초기화 해줘야함!
	
	/* 추상메소드 : (-주로 씀!)
	 * 타입 메소드명(매개변수); 
	 * 추상메소드를 추가하면 구현클래스에 오버라이드를 꼭 해줘야함 => default라는 기능이추가된 이유 */ 
	/*public abstract*/ void run();
	/*public abstract*/ void stop();
	/*public abstract*/ void print();
	
	/* 디폴트 메소드 : -거의 사용은 안함 ->추상메소드로 재선언 할 수 있다 
	 * default 리턴타입 메소드명(매개변수){}
	 * 오버라이드 하지 않아도 인터페이스에 뒤늦게 기능이 추가되면 default()메소드에 쓰면된다  */
	default void test() {
		System.out.println("테스트입니다.");
	}
	
	/* 정적메소드 : static-클래스
	 * static 리턴타입 메소드명(매개변수){}*/
	
}
