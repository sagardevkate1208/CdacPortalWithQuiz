package Team_13.CdacPortalWithQuiz.models;


import javax.persistence.*;

@Entity
public class Options {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn
	private Question que_id;
	private String optionString;
	private boolean correct;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOptionString() {
		return optionString;
	}
	public void setOptionString(String optionString) {
		this.optionString = optionString;
	}
	public void setQue_id(Question que_id) {
		this.que_id = que_id;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public Question getQue_id() {
		return que_id;
	}
	public void setQues_id(Question que_id) {
		this.que_id = que_id;
	}

}
