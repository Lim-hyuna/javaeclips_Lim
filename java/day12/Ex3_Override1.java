package day12;

public class Ex3_Override1 {
	
	public static void main(String[] args) {
		//오버라이드 
		Animal a = new Animal();
		a.bark();
		Dog d= new Dog();
		d.bark();
		Cat c=new Cat();
		c.bark();
		//String클래스는 final클래스로서 자식을 가질수 없는 즉 부모로 사용불가한 클래스
		//String str;
	}

}
class Animal{
	public void bark() {
		System.out.println("짖다");
	}
	
}

class Dog extends Animal{
	
	public void bark() {
		System.out.println("------------");
		//super.메소드()는 첫번재가 아니어도 된다 
		super.bark(); //부모 클래스의 메소드 뒤에 새로운 기능을 추가 
		System.out.println("멍멍");
		System.out.println("------------");
	}
}

class Cat extends Animal{
	//어노테이션 
	@Override //기능상으로는 특별한 역할은 안하지만 문법체크를 해줌 
	public void bark() {
		//부모 클래스의 메소드를 사용하지 않고 재정의 
		System.out.println("야옹");
	}
}