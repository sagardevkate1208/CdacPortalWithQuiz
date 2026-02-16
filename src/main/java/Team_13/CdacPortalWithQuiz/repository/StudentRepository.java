package Team_13.CdacPortalWithQuiz.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.transaction.Transactional;

import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;

import Team_13.CdacPortalWithQuiz.DTO.ShowScoreDTO;
import Team_13.CdacPortalWithQuiz.DTO.StudentDashboardDTO;
import Team_13.CdacPortalWithQuiz.models.Notes;
import Team_13.CdacPortalWithQuiz.models.Notices;
import Team_13.CdacPortalWithQuiz.models.Question;
import Team_13.CdacPortalWithQuiz.models.RecordingsManagement;
import Team_13.CdacPortalWithQuiz.models.ScoreDetails;
import Team_13.CdacPortalWithQuiz.models.Subject;
import Team_13.CdacPortalWithQuiz.models.User;

@Repository
public class StudentRepository {

	@PersistenceContext
	EntityManager em;
	
	public List<ScoreDetails> dashBoard(User student)
	{
		List<ScoreDetails> scoreList =  new ArrayList<>();
		scoreList = em.createQuery("select s from ScoreDetails s where s.userID.portalId=:id").setParameter("id", student.getPortalId()).getResultList();
		return scoreList;
	}

	public List<Subject> getSubjectList() {
		
		List <Subject> subList= em.createQuery("select s from Subject s").getResultList(); 
		
		return subList;
	}

	public List<Notices> getNoticeList() {
		List<Notices> noticeList = em.createQuery("From Notices n ORDER BY n.uploadDate").getResultList();
		return noticeList;
	}

	@Transactional
	public boolean addScore(ScoreDetails score) {
		try {
		em.persist(score);
		}
		catch(Exception e) {
		return false;
		}
		return true;
	}

	public List<ShowScoreDTO> getScores(int id) {
		List<ScoreDetails> scoreList = em.createQuery("select s from ScoreDetails s where s.userID.portalId=:ids").setParameter("ids", id).getResultList();
        List<ShowScoreDTO> scoreDtoList = new ArrayList<ShowScoreDTO>();
		
		for(ScoreDetails score: scoreList)
		{
			ShowScoreDTO sco = new ShowScoreDTO();
			sco.setName(score.getQuizId().getSubject());
			sco.setDate(score.getDate());
			sco.setScore(score.getScore());
			scoreDtoList.add(sco);
		}
		return scoreDtoList;
	}
	public List<Question> getQuiz(int id)
	{
		List<Question> queList = em.createQuery("select q from Question q where q.quizId.id = :id").setParameter("id",id).getResultList();
		return queList;
	}

	public Subject geSubject(int quizid) {
		Subject subject = em.find(Subject.class, quizid);
		return subject;
	}

	public List<Notices> getNotices() {
		List<Notices> notices = em.createQuery("select n from Notices n").getResultList();
		return notices;
	}

	public List<RecordingsManagement> getVidList() {
		 List<RecordingsManagement> list = em.createQuery("select r from RecordingsManagement r").getResultList();
		 List<RecordingsManagement> newList = new ArrayList<RecordingsManagement>();
		 for(RecordingsManagement record : list)
		 {
			 record.setUser(null);
			 newList.add(record);
		 }
		 return newList;
	}

	public List<Notes> getnoteList() {
		List<Notes>  list = em.createQuery("select n from Notes n").getResultList();
		return list;
	}
	
}
