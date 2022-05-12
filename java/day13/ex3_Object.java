package day13;
//API클래스_Object-equals
public class ex3_Object {

	public static void main(String[] args) {
		A a1 = new A(1, 2);
		A a2 = new A(1, 2);
		//오버라이딩 하지 않은 것은 아래와 같은 코드를 씀
		if(a1 == a2) {
			System.out.println("공유 중입니다.");
		}else {
			System.out.println("공유하고 있지 않습니다.");
		}
		//오버라이딩은 equals로 확인 가능함 
		if(a1.equals(a2)) {
			System.out.println("같은 필드를 가진 객체입니다.");
		}else {
			System.out.println("다른 객체 입니다.");
		}
		//[ toString() ]객체의 문자 정보 리턴 
		System.out.println(a1.toString());
		//System.out.println(a2.toString());
	    
		//=을 통해 객체를 저장하면 공유 a1과 a3이 같은 개체를 공유
		A a3 =a1;
		//a3의 num1의 값을 변경 => a1의 num1의 값도 같이 변경 
		a3.setNum1(3);
		System.out.println("-----------");
		System.out.println(a3.toString());
		System.out.println(a1.toString());

	
			//clone을 통해 객체를 복사하면 새로운 객체를 생성한 후 필드를 복사하여 객체를 반환 
			a3 =(A)a1.clone();
			//a3의 num1의 값을 변경 => a1의 num1의 값도 같이 변경 
			a3.setNum1(5);
			System.out.println("-----------");
			System.out.println(a3.toString());
			System.out.println(a1.toString());
		}

}

class A implements Cloneable{
	private int num1;
	private int num2;
	
	public A(int num1, int num2) {
		this.num1 = num1;
		this.num1 = num2;
	}
	/*[equals]
	@Override
	public boolean equals(Object obj) {
		//두 객체의 주소가 같은지 확인 => 두 객체가 같은 객체를 공유하는 지 확인 
		if(this == obj) {
			return true;
		}
	
		//상대 객체가 없으면 비교 불가능 
		if(obj == null) {
			return false;
		}
		//obj가 A로 타입변환이 불가능하면 비교할 수 없다 
		if(!(obj instanceof A)) {
			return false;
		}
		A object = (A)obj;
		if(num1 != object.num1) {
			return false;
		}
		if(num2 != object.num2) {
			return false;
		}
		return true;
	}
	*/
	
	//[해시코드] 소스-제너럴 해시코드 ->자동생성됨 
	@Override
	public int hashCode() {
		final int prime = 31; //임의의 숫자
		int result = 1;
		//num1 =1, num2 =2
		result = prime * result + num1; //32
		result = prime * result + num2; //31*32 +2 => 994
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		if (num1 != other.num1)
			return false;
		if (num2 != other.num2)
			return false;
		return true;
	}
	//toString 소스 ->제너럴 toString() ->자동생성됨 
	@Override
	public String toString() {
		return "A [num1=" + num1 + ", num2=" + num2 + "]";
	}
	
	//gerset
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	/*toString 오버라이딩
	@Override
	public String toString() {
		return "num1 : " +num1+", num2 : "+num2;
	} */
	
	//[ clone() ]
	//일반적인 clone은 얕은 복제. 깉은 복
	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone(); //써라운드 위드 캐치 누름 
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
}