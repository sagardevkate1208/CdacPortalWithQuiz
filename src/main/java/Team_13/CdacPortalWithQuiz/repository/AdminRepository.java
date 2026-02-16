package Team_13.CdacPortalWithQuiz.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import Team_13.CdacPortalWithQuiz.models.User;

@Repository
public class AdminRepository {

	@PersistenceContext
	EntityManager em;

	public long getFacCount() {
		return  (long) em.createQuery("select count(f) from User f where f.role='faculty'").getSingleResult();
	}

	public long getStudentCount() {
		return (long) em.createQuery("select count(f) from User f where f.role='student'").getSingleResult();
	}

	public long getRecordingCount() {
		return (long) em.createQuery("select count(u) from RecordingsManagement u ").getSingleResult();
	}

	public long getNotesCount() {
		return (long) em.createQuery("select count(s) from Notes s ").getSingleResult();
	}

	public List<User> getFacList() {
		List<User> list = em.createQuery("select u from User u where u.role='faculty'").getResultList();
		return list;
	}

	public List<User> getStudList() {
		List<User> list = em.createQuery("select u from User u where u.role='student'").getResultList();
		return list;
	}

	@Transactional
	public void updateUser(User u1) {
		em.merge(u1);
	}

}
