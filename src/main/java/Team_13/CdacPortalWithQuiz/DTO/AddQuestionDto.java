package Team_13.CdacPortalWithQuiz.DTO;

import java.util.List;

import Team_13.CdacPortalWithQuiz.models.Options;

public class AddQuestionDto {
	private String subject;
	private String question;
	private List<Options> optionlist;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Options> getOptionlist() {
		return optionlist;
	}
	public void setOptionlist(List<Options> optionlist) {
		this.optionlist = optionlist;
	}
	
	
}
