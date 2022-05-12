package day13;

public class Ex1_Interface1 {

	public static void main(String[] args) {
		//인터페이스 예제 
		//Controller con = new Controller(); //에러 => 인터페이스로 객체를 생성X
		
		/*구현클래스로 호출  
		RemoteController rc =new RemoteController();
		rc.print();
		rc.run();
		rc.print();
		rc.stop();
		rc.print(); 
		*/
		
		//인터페이스 호출 
		//다형성-자동타입변환 인터페이스 변수 = 구현객체;
		Controller rc =new RemoteController();
		rc.print();
		rc.run();
		rc.print();
		rc.stop();
		rc.print();
		
		/* 익명 구현 객체 -일회용 이름없는-구현클래스를 만들어 객체를 생성
		 *             -인터페이스를 이용하여 같은 종류의 객체를 1개만 만들면 될때 사용 재사용X
		 * 인터페이스 변수 = new 인터페이스(){
		 * //인터페이스에 선언된 추상메소드의 실체 메소드 선언 }; 
		 * */
		Controller rc2 = new Controller() {
			//인터페이스에 선언된 추상메소드의 실체 메소드 선언
			@Override
			public void stop() {
				System.out.println("중지");
			}
			@Override
			public void run() {
				System.out.println("시작");
			}
			@Override
			public void print() {
				System.out.println("출력");
			}
		//추가로 메소드 추가 가능하나 익명구현객체 안에서만 사용가능 
		};	
		rc2.print();
		rc2.run();
		rc2.print();
		rc2.stop();
		rc2.print();

	}

}
