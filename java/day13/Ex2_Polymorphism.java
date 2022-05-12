package day13;
//매개변수의 다형성 -1
public class Ex2_Polymorphism {

	public static void main(String[] args) {
		//controller배열 생성
		Controller controller[] = new Controller[3];
		controller[0] = new RedioController();
		controller[1] = new TvController();
		controller[2] = new TvController();
		
		controller[1].run();
		for(int i=0; i<900; i++) {
			if(controller[1] instanceof RedioController) {
				RedioController tmp = (RedioController)controller[1];
				tmp.frequencyUp();
			}
			if(controller[1] instanceof TvController) {
				TvController tmp = (TvController)controller[1];
				tmp.channelUp();
			}
		}
		System.out.println("--------------");
		for(Controller tmp : controller) {
			printController(tmp);
			System.out.println("--------------");
		}
	}
	//매개변수의 다형성 - 오버로딩을 줄이기 위해서 
	//매개변수가 인터페이스이면 호출할 때 인터페이스를 구현한 구현객체가 와야함 
	public static void printController(Controller con) {
		con.print();
	}
	/* 오버로딩 아래 두줄을 줄일수 있다 
	public static void printController(TvController con) {
		con.print();
	}
	public static void printController(RedioController con) {
		con.print();
	} */

}
