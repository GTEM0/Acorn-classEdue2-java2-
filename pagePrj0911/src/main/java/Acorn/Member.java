package Acorn;

public class Member {

	String m_id;
	String m_pw;
	String m_name;
	
	public Member(String m_id, String m_pw, String m_name) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		
	}
	public String getM_id() {
		return m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	
	@Override
	public String toString() {
		return "Member [m_id=" + m_id + ", m_pw=" + m_pw + ", m_name=" + m_name + "]";
	}
	
	
	
	
}
