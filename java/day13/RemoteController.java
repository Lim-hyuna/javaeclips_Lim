package day13;
/*인터페이스 구현클래스 
  public class 구현클래스명 implements 인터페이스명 {} */
public class RemoteController implements Controller {
	//인터페이스에 선언된 추상메소드의 실체 메소드 선언
	
	private boolean power;
	//추상메소드 오버라이드
	@Override
	public void run() {
		power = true;
	}

	@Override
	public void stop() {
		power = false;
	}
	
	public void print() {
		if(power) {
			System.out.println("실행중입니다.");
		}else{
			System.out.println("정지중입니다.");
		}
	}
	

}
