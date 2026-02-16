package Team_13.CdacPortalWithQuiz.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import Team_13.CdacPortalWithQuiz.models.Options;
import Team_13.CdacPortalWithQuiz.models.Subject;

public class QuestionListDTO {
	private int id;
	private String question;
	private int quizId;
	private List<OptionsDTO> options;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public List<OptionsDTO> getOptions() {
		return options;
	}
	public void setOptions(List<OptionsDTO> options) {
		this.options = options;
	}
	

}
