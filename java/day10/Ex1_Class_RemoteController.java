package day10;

import java.util.Scanner;

public class Ex1_Class_RemoteController {

	public static void main(String[] args) {
		/* 메뉴를 출력 후 메뉴에 맞는 기능을 동작하도록 코드를 작성하세요
		 * 메뉴
		 * 1. 채널 UP
		 * 2. 채널 DOWN
		 * 3. 채널 변경
		 * 4. 볼륨 UP
		 * 5. 볼륨 DOWN
		 * 6. 전원
		 * 7. 종료
		 * 메뉴를 선택하세요 : 6
		 * TV를 켰습니다.
		 * * 메뉴
		 * 1. 채널 UP
		 * 2. 채널 DOWN
		 * 3. 채널 변경
		 * 4. 볼륨 UP
		 * 5. 볼륨 DOWN
		 * 6. 전원
		 * 7. 종료
		 * 메뉴를 선택하세요 : 3
		 * 채널 입력 : 100
		 * 채널  : 100
		 * * 메뉴
		 * 1. 채널 UP
		 * 2. 채널 DOWN
		 * 3. 채널 변경
		 * 4. 볼륨 UP
		 * 5. 볼륨 DOWN
		 * 6. 전원
		 * 7. 종료
		 * 메뉴를 선택하세요 : 7
		 * */
		int menu = -1;
		Scanner scan = new Scanner(System.in);
		RemoteController rm = new RemoteController();
		
		for(;menu !=7;) {
			   System.out.println("메뉴\n1. 채널 UP\n2. 채널 DOWN\n3. 채널 변경\n4. 볼륨 UP\n5. 볼륨 DOWN\n6. 전원\n7. 종료");	
			   System.out.print("메뉴를 선택하세요. : ");
			   menu=scan.nextInt();
				
			   switch(menu) {
				   case 1 : 
					   rm.channelUp();
					   break;
				   case 2 :
					   rm.channelDown();
					   break;
				   case 3 :
					   System.out.print("채널 입력: ");
					   int ch = scan.nextInt();
					   rm.channelChange(ch);
					   break;
				   case 4 :
					   rm.volumeUp();
					   break;
				   case 5 :
					   rm.volumeDown();
					   break;
				   case 6 :
					   rm.turn();
					   break;
				   case 7 : 
					   System.out.println("프로그램 종료");
					   break;
				   default:
					   System.out.println("잘못된 메뉴입니다.");
			   }   
		   }
			scan.close();
}
}


/* TV 리모컨 클래스를 생성하고, 객체를 생성 후 기능들을 테스트해보세요.  */

class RemoteController{

	boolean power;
	int channel=0;
	int volume=0;
	int minVolume=0;
	int maxVolume=32;
	int minChannel=1;
	int maxChannel=999;
	//TV를 키거나 끄는 메소드
	void turn() {
		power = !power;
		if(power) {
			System.out.println("TV가 켜졌습니다.");
		}else {
			System.out.println("TV가 꺼졌습니다.");
		}
		}
    //볼륨을 한칸씩 올리는 기능 
	void volumeUp() { 
	   if(power) {
		   if(volume<maxVolume){
			   volume++;
		   }
		   System.out.println("소리: "+ volume);
	   }
	}
	//볼륨을 한칸씩 내리는 기능
	   void volumeDown() { 
		   if(power) {
			   if(volume>minVolume){
				   volume--;
			   }
			   System.out.println("소리: "+ volume);
		   }
	   }
     
	//채널을 한칸씩 올리는 기능   
	   void channelUp() { 
		   if(power) {
			   if(channel<maxChannel){
				   channel++;
			   }
			   System.out.println("채널: "+ channel);
		   }
	   }
	//채널을 한칸씩 내리는 기능 
	   void channelDown() { 
		   if(power) {
			   if(channel>minChannel){
				   channel--;
			   }
			   System.out.println("채널: "+ channel);
		   }
	   }
	   
	 //채널을 변경하는 기능 
	   void channelChange(int ch) {
		   if(power) {
			   if(ch < minChannel) {
				   channel=minChannel;
			   }else if(ch >maxChannel) {
				   channel=maxChannel;
			   }else {
				   channel=ch;
			   }
			   System.out.println("채널:"+channel);
		   }
		  
	   }
	   
	//생성자만들기
	   public RemoteController() {
			channel = minChannel;
			volume = minVolume;//volume은 초기값이 0이라서 이코드 생략가능 
		}
		public RemoteController(int ch,int v) {
			if(ch>=minChannel && ch<=maxChannel ) {
				channel=ch;
			}else {
				channel=minChannel;
			}
			if(v>=minVolume && v<=maxVolume ) {
				volume=v;
			}else {
				volume=minVolume;
			}
		}
	
	}	