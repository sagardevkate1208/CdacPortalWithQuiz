package Team_13.CdacPortalWithQuiz.models;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;


import org.springframework.stereotype.*;


@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quizId;
	private String subject;
	
	
	@OneToMany(mappedBy = "quizId" ,cascade = CascadeType.ALL)
	private List<Question> questions;
    
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	private LocalDate date;
	
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
}
