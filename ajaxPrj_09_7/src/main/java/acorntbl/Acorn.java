package acorntbl;

public class Acorn {

	String id;
	String pw;
	String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Acorn [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}	
	public Acorn() {
		
	}
	
	public Acorn(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }
	
}


    

    // 나머지 클래스 멤버와 메소드들...


