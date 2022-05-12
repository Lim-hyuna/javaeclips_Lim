package day13;
//다중 인터페이스 구현 클래스 : 여러 인터페이스를 구현한 구현클래스를 만들 수 있다 
public class PlayerController implements Controller, Player{

	//인터페이스 A에 선언된 추상 메소드의 실체 메소드 선언
	@Override
	public void next() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prev() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	//인터페이스 B에 선언된 추상 메소드의 실체 메소드 선언

}
