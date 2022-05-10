package day11;

import java.util.Scanner;

public class Ex1_Class_Student {

	public static void main(String[] args) {
		/* 메뉴
		 * 1. 학생 정보 입력
		 2. 학생 정보 출력
		 3. 프로그램 종료
		 메뉴를 선택하세요:
		 */
		Scanner scan = new Scanner(System.in);
		Student1 st = new Student1(null,0,0,0);
		int menu = -1;
		for( ; menu != 3 ; ) {
		 System.out.println("메뉴\n1. 학생 정보 입력\n2. 학생 정보 출력\n3. 프로그램 종료");
		 System.out.print("메뉴를 선택하세요. : ");
		 menu = scan.nextInt();
		 switch(menu) {
		 case 1:
			 System.out.print("이름: ");
			 String str=scan.next();
			 System.out.print("학년: ");
			 int x=scan.nextInt();
			 System.out.print("반: ");
			 int y=scan.nextInt();
			 System.out.print("번호: ");
			 int z=scan.nextInt();
			 st = new Student1(str,x,y,z);
			 break;
		 case 2: st.print();
			 break;
		 case 3: System.out.println("프로그램을 종료합니다.");
			 break;
			 default:
				 System.out.println("잘못된 메뉴 입니다.");
		 }
		}
		scan.close();
	}

}
//학생(Student) 클래스
class Student1{
	//학생 이름, 학년, 반, 번호를 필드로 가짐
	String name;
	int grade; 
	int classNumber;
	int number;
	
	//학생 정보를 출력하는 메소드를 가짐(print)
	void print() {
		System.out.println(grade+"학년 "+classNumber+"반 "+number+"번 "+name);
	}
	
	//학생 이름, 학년, 반, 번호를 이용하여 필드를 초기화하는 생성자를 가짐
	public Student1(String name, int grade, int classNumber, int number) {
		this.name = name;
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;
	}
	
}