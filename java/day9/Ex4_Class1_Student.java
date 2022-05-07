package day9;

public class Ex4_Class1_Student {

	public static void main(String[] args) {
		HighSchoolStudent std = new HighSchoolStudent("운호", "임현아", 1, 10, 23);
		std.print();

	}

}
/* 고등학생 클래스에 필요한 필드를 주석으로 써 보고 선언해보세요. */
class HighSchoolStudent{
	//필드작성 : 학생이름, 이름, 학년, 반, 번호, 국어, 영어, 수학 
	String schoolName;
	String name;
	int grade;
	int classNumber;
	int number;
	int kor;
	int eng;
	int math;
	
	//학생 정보를 출력하는 기능
	void print() {
		System.out.println("고등학교 : "+schoolName);
		System.out.println("이름 : "+name);
		System.out.println("학년 : "+grade);
		System.out.println("학반 : "+classNumber);
		System.out.println("번호 : "+number);
	}
	//생성자 : 우클릭 > 소스 >  제너럴 컨스트럭터 유징 필드 
	public HighSchoolStudent(String schoolName, String name, int grade, int classNumber, int number) {
		this.schoolName = schoolName;
		this.name = name;
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;
	}
	

	
}