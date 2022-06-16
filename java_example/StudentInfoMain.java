package day23;

import java.util.Scanner;

public class StudentInfoMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentInfoManager sm = new StudentInfoManager(scan);

		sm.run();
		scan.close();

	}

}
