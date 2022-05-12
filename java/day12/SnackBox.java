package day12;

public class SnackBox extends Product {
    //스낵박스마다 몇개가 들어가있는 지 count 
	private int count;
	
	public SnackBox(String name, int price, int amount, int count) {
		super(name, price, amount);
		this.count = count;
	}
	//case 3 제품선택을 위한 생성자 
	public SnackBox(SnackBox product) {
		this(product.getName(),product.getPrice(),
				product.getAmount(), product.getCount());
	}

	@Override
	public void print() {
		System.out.println(getName()+"[박스당 "+count+"개]: "+getPrice()+"원 - "
			+getAmount());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
