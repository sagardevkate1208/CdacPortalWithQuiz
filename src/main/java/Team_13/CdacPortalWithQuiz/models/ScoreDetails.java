package Team_13.CdacPortalWithQuiz.models;


import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;


@Entity
public class ScoreDetails {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int scoreId;
	private LocalDate date;
	private int score;
	@OneToOne
	@JoinColumn
	private User userID;
	@OneToOne
	@JoinColumn
	private Subject quizId;
	public int getScoreId() {
		return scoreId;
	}
	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public User getUserID() {
		return userID;
	}
	public void setUserID(User userID) {
		this.userID = userID;
	}
	public Subject getQuizId() {
		return quizId;
	}
	public void setQuizId(Subject quizId) {
		this.quizId = quizId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
    
}
