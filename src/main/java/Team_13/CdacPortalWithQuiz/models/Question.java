package Team_13.CdacPortalWithQuiz.models;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;


@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String question;
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn
	private Subject quizId;
	@OneToMany(mappedBy = "que_id",cascade =CascadeType.ALL)
	private List<Options> options;
	

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

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}

	public Subject getQuizId() {
		return quizId;
	}

	public void setQuizId(Subject quizId) {
		this.quizId = quizId;
	}
}


