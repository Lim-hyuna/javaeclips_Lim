package day23;

import java.util.*;

public class StudentInfoManager implements ConsoleProgram{

	private Scanner scan;
	private int exitMenu = 8;
	private List<Score> listSc = new ArrayList<Score>();
	private List<Student> listStd = new ArrayList<Student>();
	private Map<Student, Score> mapSS = new HashMap<Student, Score>();
	 // Set<Student>keySet() = mapSS.keySet();
	
	public StudentInfoManager(Scanner scan) {
		this.scan = scan != null ? scan : new Scanner(System.in);
	}
	//------------------------------------------------------------------------------------------------
	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("====학생관리프로그램====");
		System.out.println("1. 학생 정보 등록");
		System.out.println("2. 학생 정보 수정");
		System.out.println("3. 학생 정보 삭제");
		System.out.println("4. 학생 성적 추가");
		System.out.println("5. 학생 성적 수정");
		System.out.println("6. 학생 성적 삭제");
		System.out.println("7. 학생 정보 출력");
		System.out.println("8. 프로그램 종료");
		System.out.println("===================");
		System.out.print("메뉴 선택: ");
		 int menu=scan.nextInt();
		 return menu;
	}
//------------------------------------------------------------------------------------------------
	@Override
	public void excute(int menu) {
		switch(menu) {
		case 1://학생정보 등록
			Student std = inputStudent();
			insertStudent(std);
			break;
		case 2://학생정보 수정
			Student modStd = inputSearchStudent();
			int index = listStd.indexOf(modStd); 
			if(index >= 0) {
				inputAddStudent(modStd);
				listStd.set(index, modStd);
			}else {
				printMessage("등록되지 않은 학생정보입니다. 학생 정보를 입력하세요.");
			}
			break;
		case 3://학생정보 삭제
			Student delStd = inputSearchStudent();
			if(listStd.remove(delStd)) {
				printMessage("학생정보를 삭제했습니다.");
			}else {
				printMessage("등록되지 않은 학생정보입니다. 삭제할 수 없습니다.");
			}
			break;
		case 4: //학생성적 추가
			Student std1 = inputSearchStudent();
			int index1 = listStd.indexOf(std1); 
			if(index1 >= 0) {
				listStd.set(index1, std1);
				Score sc = inputScore();
				insertScore(sc);
				Set<Map.Entry<Student, Score>> entrySet = mapSS.entrySet();
				Iterator<Map.Entry<Student, Score>> entryIterator = entrySet.iterator();
				while(entryIterator.hasNext()) {
					Map.Entry<Student, Score>entry = entryIterator.next();
					std1= entry.getKey();
					sc = entry.getValue(); 
				}
				// System.out.println(std1+sc);
			}else {
				printMessage("등록되지 않은 학생정보입니다. 학생 정보를 입력하세요.");
			}
			break;
		case 5: //학생성적 수정
			//modifyScore();
			break;
		case 6: //학생성적 삭제
			break;
		case 7: //학생정보 출력 
			break;
		case 8:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다. 다시 선택해주세요.");
		}
		
	}
//------------------------------------------------------------------------------------------------
	/*
	private boolean modifyScore() {
		//학년/ 반 번호로 찾기
		Student std = inputSearchStudent();
		mapSS.get(std);
		//과목 항목을 출력 
		if(mapSS.get(std) == listStd) {
			System.out.println(mapSS.get(subject));
			return true;
		}
		//해당하는 과목을 기입하여 찾고
		System.out.println("수정할 과목을 입력하세요: ");
		String subject = scan.next();
		//중간,기말,수행인지 기입하여 선택
		System.out.println("중간,기말,수행 중에 수정할 성적을 입력하세요: ");
		String score = scan.next();
		//학년,학기,과목이 같은 성적이 성적리스트에 없으면 없다고 알림
		Score tmp = new Score(grade, termNum, subject);
		int index = list.indexOf(tmp);
		if(index < 0) {
			System.out.println("---------------------");
			return false;
		//해당 점수 수정 
		
		System.out.println("중간: ");
		int middleScore = scan.nextInt();
		System.out.println("기말: ");
		int finalScore = scan.nextInt();
		System.out.println("수행: ");
		int performScore = scan.nextInt();
		
		tmp = new Score(subject, middleScore, finalScore, performScore);
		listSc.remove(tmp); //기존에 있던 학생 정보를 삭제 
		listSc.add(tmp); //수정한 학생 정보를 추가 
		return true;
	}     */
//------------------------------------------------------------------------------------------------
	private void insertScore(Score sc) {
		if(sc == null) {
			return;
		}
		if(listSc.contains(sc)) {
		printMessage("이미 추가된 성적입니다.");
		return;
		}
		listSc.add(sc);
		
		printMessage("성적이 추가되었습니다.");
	}	 
//------------------------------------------------------------------------------------------------
	private Score inputScore() {
		try {
			System.out.println("-----------------------------------");
			System.out.print("과목명을 입력: ");
			String subject = scan.next();	
			System.out.print("중간점수(1~100사이정수): ");
			int middleScore = scan.nextInt();
			System.out.print("기말점수(1~100사이정수): ");
			int finalScore = scan.nextInt();
			System.out.print("수행점수(1~100사이정수): ");
			int performScore = scan.nextInt();
			return new Score(subject, middleScore, finalScore, performScore);
			}catch(Exception e){
				printMessage("입력에서 잘못된 값을 입력했습니다. 입력이 취소됩니다.");
				scan.nextLine(); 
				return null;
			}
		}    
//------------------------------------------------------------------------------------------------
	private void inputAddStudent(Student std) {
		if(std == null) {
			printMessage("학생 정보가 없습니다.");
			return;
		}
		try {
		   System.out.print("수정할 학생 정보 입력(학년,반,번호,이름): ");
		   int grade=scan.nextInt();
		   int classNum=scan.nextInt();
		   int num=scan.nextInt();
		   String name = scan.next();
		   std.modify(grade, classNum, num, name);
		   System.out.println(std);
		}catch(Exception e){
			printMessage("입력에서 잘못된 값을 입력했습니다. 입력이 취소됩니다.");
			scan.nextLine();
			return;
		}	
	
	}
//------------------------------------------------------------------------------------------------
	private Student inputSearchStudent() {
		try {
		   System.out.println("검색할 학생 정보를 입력하세요.");
		   System.out.print("학생 정보를 입력(예:학년,반,번호): ");
		   int grade =scan.nextInt();
		   int classNum= scan.nextInt();
		   int num=scan.nextInt();
		   return new Student(grade, classNum, num, null);
		}catch(Exception e){
			printMessage("입력에서 잘못된 값을 입력했습니다. 입력이 취소됩니다.");
			scan.nextLine(); 
			return null;
		}
}
//------------------------------------------------------------------------------------------------
	private void insertStudent(Student std) {
		if(std == null) {
			return;
		}
		if(listStd.contains(std)) {
		printMessage("이미 추가된 학생입니다. 학생정보 수정을 이용하세요.");
		return;
		}
		listStd.add(std);
		listStd.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getGrade() != o2.getGrade()) {
					return o1.getGrade() - o2.getGrade();
				}
				if(o1.getClassNum() != o2.getClassNum()) {
					return o1.getClassNum() - o2.getClassNum();
				}
				if(o1.getNum() != o2.getNum()) {
					return o1.getNum() - o2.getNum();
				}
				return 0;
			}
		});
		printMessage("학생 정보가 추가되었습니다.");
	}
//------------------------------------------------------------------------------------------------
	private Student inputStudent() {
		
		try {
		   System.out.print("학생 정보를 입력(예:학년,반,번호,이름): ");
		   int grade =scan.nextInt();
		   int classNum= scan.nextInt();
		   int num=scan.nextInt();
		   String name = scan.next();
		   return new Student(grade, classNum, num, name);
		}catch(Exception e){
			printMessage("입력에서 잘못된 값을 입력했습니다. 입력이 취소됩니다.");
			scan.nextLine(); 
			return null;
			}
		
	}	
//------------------------------------------------------------------------------------------------	
	@Override
	public void run() {
		int menu = -1;
		do {
			try {
				menu = selectMenu(scan);
				excute(menu);
			}catch(InputMismatchException e) {
				printMessage("잘못된 형태의 메뉴를 입력했습니다.");
				scan.nextLine();
			}catch(RuntimeException e) {
				printMessage(e.getMessage()); 
			}catch(Exception e) {
				printMessage("예외발생: "+e.getMessage());
			}
		}while(menu != exitMenu);
		
	}
//------------------------------------------------------------------------------------------------
	private void printMessage(String message) {
		System.out.println("---------------------------");
		System.out.println(message);
		System.out.println("---------------------------");
		}
//------------------------------------------------------------------------------------------------
	
}//StudentInfoManager 종료 
