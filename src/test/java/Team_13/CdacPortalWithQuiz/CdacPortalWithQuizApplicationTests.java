package Team_13.CdacPortalWithQuiz;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.sql.SelectFragment;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import Team_13.CdacPortalWithQuiz.models.Subject;

@SpringBootTest
class CdacPortalWithQuizApplicationTests {

	@PersistenceContext
	EntityManager em;
	@Test
	void contextLoads() {
	}

	@Test
	public void otpGen()
	{
		String otp = "";
		Random rnd = new Random();
	    String selectFrom="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		while(otp.length()<6)
		{
			char ch = selectFrom.charAt(rnd.nextInt(selectFrom.length()));
			otp=otp+ch;
		}
		System.out.println(otp);
	
	}
	@Test
public List<Subject> getSubjectList() {
		List <Subject> subList= em.createQuery("select s from Subject s").getResultList(); 
		System.out.println(subList);
		return subList;
	}
	@Test
	public List<String> studentMailList()
	{
		List<String> emailList = em.createQuery("select email from User u.email where u.role=student").getResultList();
		System.out.println(emailList);
		return emailList;
	}
	
}
