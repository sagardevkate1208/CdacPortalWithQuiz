package Team_13.CdacPortalWithQuiz.DTO;

import java.time.LocalDate;

import org.springframework.stereotype.Component;


public class ShowScoreDTO {
	
	private String name;
	private int score;
	private LocalDate date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
