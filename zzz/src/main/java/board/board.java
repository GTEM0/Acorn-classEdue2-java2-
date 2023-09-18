package board;

public class board {

	int questionCode;
	String buyerId;
	String title;
	String questionContents;
	String writeDate;
	int Available;

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
		return Available;
	}

	public void setBbsAvailable(int bbsAvailable) {
		this.Available = bbsAvailable;
	}

	public board() {
		// TODO Auto-generated constructor stub
	}
}
