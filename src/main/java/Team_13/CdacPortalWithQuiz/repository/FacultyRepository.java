package Team_13.CdacPortalWithQuiz.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Team_13.CdacPortalWithQuiz.models.MongoDBRepo;
import Team_13.CdacPortalWithQuiz.models.Notes;
import Team_13.CdacPortalWithQuiz.models.Notices;
import Team_13.CdacPortalWithQuiz.models.Question;
import Team_13.CdacPortalWithQuiz.models.RecordingsManagement;
import Team_13.CdacPortalWithQuiz.models.Subject;

@Repository
@Transactional
public class FacultyRepository {
	@PersistenceContext
	EntityManager em;
	@Autowired
	MongoDBRepo mongo;

	public void addSubject(Subject subject) {
		em.merge(subject);
	}

	public Subject fetchSubjectByName(String subject) {
		Subject sub = (Subject) em.createQuery("select s from Subject s where s.subject = :subject ")
				.setParameter("subject", subject).getSingleResult();
		return sub;
	}

	public void addQuestion(Question q1) {
		em.persist(q1);
	}

	public long getCountNotes(int i) {
		System.out.println(i);
		long count = (long) em.createQuery("select count(a) from Notes a where a.user.portalId=:id")
				.setParameter("id", i).getSingleResult();
		System.out.println(count);
		return count;
	}

	public long getCountRecording(int i) {
		long count = (long) em.createQuery("select count(a) from RecordingsManagement a where a.user.portalId=:id")
				.setParameter("id", i).getSingleResult();
		return count;
	}

	public long getCountNotices(int i) {

		long count = (long) em.createQuery("select count(a) from Notices a where a.user.portalId=:id")
				.setParameter("id", i).getSingleResult();
		return count;
	}

	public long getCountQuiz(int i) {
		long count = (long) em.createQuery("select count(a) from Subject a where a.user.portalId=:id")
				.setParameter("id", i).getSingleResult();
		System.out.println(count);
		return count;
	}

	@Transactional
	public boolean addNotice(Notices newNotice) {

		try {
			em.persist(newNotice);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public List<String> studentMailList() {
		List<String> emailList = em.createQuery("select u.email from User u where u.role='student'").getResultList();
		System.out.println(emailList);
		return emailList;
	}

	@Transactional
	public void addRecording(RecordingsManagement recMgmt) {
		em.persist(recMgmt);
	}

	public List<Notes> getNotesList() {
		return em.createQuery("select n from Notes n ").getResultList();
	}

	@Transactional
	public void addNote(Notes note) {
		em.persist(note);
	}

	@Transactional
	public void deleteMaterial(String baseId) {
		System.out.println(baseId);
		em.createQuery("delete from Notes n where n.baseId=:baseId").setParameter("baseId", baseId).executeUpdate();
		mongo.deleteById(baseId);

	}

}
