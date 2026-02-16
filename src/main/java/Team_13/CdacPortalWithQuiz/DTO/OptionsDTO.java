package Team_13.CdacPortalWithQuiz.DTO;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import Team_13.CdacPortalWithQuiz.models.Question;

public class OptionsDTO {
	private int que_id;
	private String optionString;
	private boolean correct;
	public int getQue_id() {
		return que_id;
	}
	public void setQue_id(int que_id) {
		this.que_id = que_id;
	}
	public String getOptionString() {
		return optionString;
	}
	public void setOptionString(String optionString) {
		this.optionString = optionString;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	
}
