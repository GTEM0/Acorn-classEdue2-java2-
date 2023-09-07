package acorntbl;

public class Movies {

	String title;
	String price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Movies [title=" + title + ", price=" + price + "]";
	}
	public Movies(String title, String price) {
		super();
		this.title = title;
		this.price = price;
	}
	
	public Movies() {
		
	}
}
