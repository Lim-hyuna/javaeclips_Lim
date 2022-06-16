package day23;

import java.util.Scanner;

//가계부예제4-ConsoleProgram인터페이스 - 표준화 
public interface ConsoleProgram {
	//메뉴를 출력 후 선택하는 기능
	int selectMenu(Scanner scan);
	
	//기능 : 선택된 기능(선택한menu)에 맞게 동작하는 메소드 
	void excute(int menu); 
	
	//프로그램 실행
	void run();
}
