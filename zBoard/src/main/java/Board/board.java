package Board;

public class board {

	int questionCode;
	String buyerId;
	String title;
	String questionContents;
	String writeDate;
	int bbsAvailable;

	@Override
	public String toString() {
		return "board [questionCode=" + questionCode + ", buyerId=" + buyerId + ", title=" + title
				+ ", questionContents=" + questionContents + ", writeDate=" + writeDate + ", bbsAvailable="
				+ bbsAvailable + "]";
	}

	public int getQuestionCode() {
		return questionCode;
	}

	public void setQuestionCode(int questionCode) {
		this.questionCode = questionCode;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuestionContents() {
		return questionContents;
	}

	public void setQuestionContents(String questionContents) {
		this.questionContents = questionContents;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public int getBbsAvailable() {
		return bbsAvailable;
	}

	public void setBbsAvailable(int bbsAvailable) {
		this.bbsAvailable = bbsAvailable;
	}

	public board() {
		// TODO Auto-generated constructor stub
	}

	public board(int questionCode, String buyerId, String title, String questionContents, String writeDate,
			int bbsAvailable) {
		super();
		this.questionCode = questionCode;
		this.buyerId = buyerId;
		this.title = title;
		this.questionContents = questionContents;
		this.writeDate = writeDate;
		this.bbsAvailable = bbsAvailable;
	}
	
}
