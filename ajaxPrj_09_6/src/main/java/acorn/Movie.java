package acorn;

public class Movie {

	String title;
	String price;
	
	public Movie() {
		
	}
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
		return "movie [title=" + title + ", price=" + price + "]";
	}
	public Movie(String title, String price) {
		super();
		this.title = title;
		this.price = price;
	}
	
	
}
