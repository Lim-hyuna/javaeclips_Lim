package day11;

import java.util.Scanner; //java.util.은 패키지임 기능들을 묶어놓은 것 
//java라는 폴더안에 util폴더안에 Scanner클래스가 있다라는 뜻 

public class Ex4_Final {

	public static void main(String[] args) {
	 System.out.println(Math.PI);//상수이름은 PI처럼 대문자로 써야함
	 System.out.println(Integer.MAX_VALUE); //MAX_VALUE 다른 단어 연결시'_'이용하여 구분
	 

	}

}

class Tv{
	//final 상수변수 -바뀌지 않는 값!
	private final static int MIN_CHANNEL = 1; //final static이붙으면 굵은글씨로 기울어짐
	private int channel; //현재 채널 
	//public 접근제한자- 공용
	public void print() {
		System.out.println("최소채널 : "+MIN_CHANNEL);
		System.out.println("현재채널 : "+channel);
	}
	public Tv(int channel) {
		this.channel = channel;
		//minChannel = 2; //에러발생 final이 붙어 값을 바꿀수 없음!
	}
	int a;
	static int b;
	final static int C=1; //final은 굵은 글씨, static은 기울어짐 
	
	
}