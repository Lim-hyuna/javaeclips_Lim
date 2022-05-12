package day12;

public class Car {
	private Tire tire[];
	
	public Car(Tire[] tire) {
		this.tire = tire;
	}
	public void print() {
			if(tire == null) {
			return;
		}
		for(Tire tmp : tire) {
		System.out.println(tmp.getPosition()+", 압력: "+tmp.getPressure()+", 상태: "+tmp.getState());
	    }
	}

	//번지index,번지에 tire 저장
	public void repare(int index, Tire tire) {
		if(this.tire == null || this.tire.length <= index) {
			return;
		}
		this.tire[index]= tire;    
	}
  
}
