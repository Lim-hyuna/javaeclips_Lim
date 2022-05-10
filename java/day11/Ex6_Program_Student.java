package day11;

import java.util.Scanner;

public class Ex6_Program_Student {
	/* 학생 정보(이름,학년,반,번호,국어,영어,수학 성적)를 관리하는 프로그램을 작성하세요.
	 * [기능 구현을 한다]
	 * 1. 프로그램의 기능을 정리(요구사항 정리) =>주석
	 *  -학생정보 입력
	 *    - 학년, 반, 번호, 이름, 국어, 영어, 수학 성적을 한번에 입력받음 
	 *      or 학년, 반, 번호만 입력하고 이름, 국어, 영어, 수학성적은 나중에 수정해서 더해도됨
	 *    - 입력한 학생정보를 저장 
	 *  -학생정보 출력
	 *    - 전체 학생의 학년, 반, 번호, 이름, 국어, 영어, 수학 성적을 출력
	 *  -학생정보 수정
	 *    - 1.학년, 반, 번호를 입력받음
	 *    - 2.입력받은 정보와 일치하는 학생이 있으면 이름, 국어, 영어, 수학 성적을 전부 수정 
	 *  -학생정보 삭제
	 *    - 학년, 반, 번호를 입력받음  
	 *    - 입력받은 정보와 일치하는 학생이 있으면, 삭제 
	 *  -프로그램 종료
	 *  [클래스 생성을 첫번째로 하고]
	 * 2. 실행하기 위해 필요한 클래스가 있는 지 확인하고, 있으면 생성 
	 *     //부연설명:클래스-(설계도)(정보를 효과적으로 관리하기위해서) 객체(부품) 
	 *  -학생 클래스 : 필드설정(학년, 반, 번호, 이름, 국어, 영어, 수학 성적)-객체생성
	 *  -기능 : 
	 *    - 학생정보를 출력
	 *    - 학년, 반, 번호가 주어졌을 때 일치하는 지 확인하는 기능(1.학생정보 수정)
	 *    - 이름, 국어, 영어, 수학을 수정하는 기능(2.학생정보 수정) 
	 *  -생성자 : 이름, 학년, 반, 번호, 이름, 국어, 영어, 수학 성적이 주어졌을 때 초기화하는 생성자
	 * 3. 기능을 구현 
	 *  -클래스 정의 및 구현
	 *  -반복문을 메뉴출력 및 메뉴 선택
	 *  -선택한 메뉴에 따른 조건문 생성 
	 * */
	public static void main(String[] args) {
		
		//기능구현
		Ex6_Student st = new Ex6_Student("",1,1,1,0,0,0);
			st.print();
			
		
		Scanner scan= new Scanner(System.in);
		int menu = -1;
		int index=0; //여기서 index는 현재 저장된 학생 수 
		int grade, classNumber, number;
		String name;
		double kor,eng,math;
		final int max = 30; //학생수 최대 30명
		Ex6_Student std[] = new Ex6_Student[max];
		
		for(;menu != 5; ) {
		//메뉴를 출력하고,메뉴를 선택 	
		 menu = selectMenu(scan); //메소드 호출 
		  
		  switch(menu) {
		  case 1: //학생정보 입력 
			  System.out.print("학생 정보를 입력(예:학년,반,번호,이름): ");
			   grade =scan.nextInt();
			   classNumber= scan.nextInt();
			   number=scan.nextInt();
			   name = scan.next();
			  System.out.print("학생 성적을 입력(예:국어,영어,수학): ");
			   kor=scan.nextDouble();
			   eng=scan.nextDouble();
			   math=scan.nextDouble();
			  //Ex6_Student의 생성자를 이용하여 객체를 생성한 후 학생 배열 std에서 
			  //index번지에 저장
               std[index]=new Ex6_Student(name,grade,classNumber,number,kor,eng,math);
			  //index를 1증가
               index++;
			  break;
		  case 2: //학생정보 출력
			 //반복문을 이용하여 0번지부터 index명만큼 학생정보를 출력 
			  for(int i=0;i<index;i++) {
				  std[i].print(); 
			   }
			  break;
		  case 3: //학생정보 수정 modify
			  //학년,반,번호를 입력
			  System.out.println("수정할 학생정보 입력(예:학년,반,번호):");
			  grade=scan.nextInt();
			  classNumber=scan.nextInt();
			  number=scan.nextInt();
			  //반복문을 통해 0~index번지만큼 학생정보를 하나씩 가져와서
			   for(int i=0;i<index;i++) {
			   //입력받은 정보와 일치하는 학생이 있는지 확인해서 있으면 
			      if(std[i].equal(grade, classNumber, number)){
				   //이름.국어,영어,수학성적을 입력 받은 후 
				   System.out.print("수정할 학생 이름과 성적을 입력(예:이름,국어,영어,수학): ");
				   name = scan.next();
				   kor=scan.nextDouble();
				   eng=scan.nextDouble();
				   math=scan.nextDouble();
				    std[i].modify(name, kor, eng, math);
				    break;
			   }
			   //등록된 학생 전체를 확인해서 일치하는 학생이 없으면 없으면 등록된 학생이 아닙니다.라고 출력
			   if(i+1==index){
				   System.out.println("등록된 학생이아닙니다.");
				   break;
			   }
		      }
			 break;
		  case 4: //학생정보 삭제
			  //학년, 반, 번호를 입력받음  
			  System.out.print("삭제할 학생정보를 입력(예 학년,반,번호): ");
			  grade=scan.nextInt();
			  classNumber=scan.nextInt();
			  number=scan.nextInt();
			  int delIndex = -1;
			  //반복문을 이용하여 0~index번지의 학생을 비교하여 일치하는 학생 정보가 있으면 
			  //delIndex번지인지 기억하고  반복문을 종료 
			  for(int i=0;i<index;i++) {
			      if(std[i].equal(grade, classNumber, number)){
			        delIndex=i;
				    break;
				    }
			     }
			//delIndex가 0이상이면 => 일치하는 학생이 있으면 
			  //반복문을 이용하여 delIndex번지부터 delIndex-1까지	 
			  if(delIndex>=0) {
				    for(int i=delIndex;i < delIndex-1 ; i++) {
				    	std[i] = std[i+1];
				    }
				   //index를 1감소
				    index--;
			  } else {
					   System.out.println("등록된 학생이아닙니다.");
			  }
			  break;
		  case 5: //프로그램 종료
			  System.out.println("프로그램을 종료 합니다.");
			  break;
			  default: System.out.println("잘못된 메뉴입니다.");
		  }
		}
		scan.close();
	}
	/*기능 : 메뉴를 출력하고 메뉴를 입력하면 입력한 메뉴를 돌려주는 메소드
	 * 매개변수 : 입력받기 위한 Scanner => Scanner scan
	 * 리턴타입 : 입력한 메뉴 => 정수 => int
	 * 메소드명 : selectMenu */
   public static int selectMenu(Scanner scan) {
	 System.out.println("------------메뉴------------");
	 System.out.println("1. 학생정보 입력");
	 System.out.println("2. 학생정보 출력");
	 System.out.println("3. 학생정보 수정");
	 System.out.println("4. 학생정보 삭제");
	 System.out.println("5. 프로그램 종료");
	 System.out.print("메뉴를 선택하세요.: ");
	 int menu=scan.nextInt();
	 System.out.println("---------------------------");
	 return menu;
	}
	
}      
