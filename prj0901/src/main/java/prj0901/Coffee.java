package prj0901;

public class Coffee {

	
	String id;
	String name;
	String price;
	public String getCode() {
		return id;
	}
	public void setCode(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Coffee [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	public Coffee(String id, String name, String price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	
}
