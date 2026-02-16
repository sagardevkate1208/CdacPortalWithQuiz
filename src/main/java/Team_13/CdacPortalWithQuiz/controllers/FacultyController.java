package Team_13.CdacPortalWithQuiz.controllers;



import java.time.LocalDate;
import java.util.List;

import javax.mail.Multipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Team_13.CdacPortalWithQuiz.DTO.AddQuestionDto;
import Team_13.CdacPortalWithQuiz.DTO.FacultyDashboardDTO;
import Team_13.CdacPortalWithQuiz.DTO.MongoDTORecording;
import Team_13.CdacPortalWithQuiz.DTO.NotesDTO;
import Team_13.CdacPortalWithQuiz.models.Notes;
import Team_13.CdacPortalWithQuiz.models.Options;
import Team_13.CdacPortalWithQuiz.models.Question;
import Team_13.CdacPortalWithQuiz.models.Subject;
import Team_13.CdacPortalWithQuiz.models.User;
import Team_13.CdacPortalWithQuiz.repository.FacultyRepository;
import Team_13.CdacPortalWithQuiz.repository.UserRepository;
import Team_13.CdacPortalWithQuiz.services.FacultyServices;
import Team_13.CdacPortalWithQuiz.services.MongoDBServices;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/Faculty")
public class FacultyController {
	@Autowired
	FacultyRepository faculty;
	@Autowired
	UserRepository userRepo;
	@Autowired
	FacultyServices facService;
	@Autowired
	MongoDBServices mongoService;
	@PostMapping("CreateQuiz")
	public boolean addSubject(@RequestParam String sub,@RequestParam String email)
	{
		Subject subject = new Subject();
		User user =  userRepo.fetchUser(email);//faculty
		subject.setSubject(sub);
		subject.setUser(user);
		subject.setDate(LocalDate.now());
		faculty.addSubject(subject);
		return true;
	}
	@PostMapping("AddQuestion")
	public boolean addQuestion(@RequestBody AddQuestionDto addques)
	{
		Subject sub = faculty.fetchSubjectByName(addques.getSubject());
		Question q1 = new Question();
		q1.setQuizId(sub);
		q1.setQuestion(addques.getQuestion());
		List<Options> option =  addques.getOptionlist();
		for(Options opt : option)
		{
			opt.setQues_id(q1);
		}
		q1.setOptions(option);
		faculty.addQuestion(q1);
		return true;
	}
	@GetMapping("dashboard")
	public FacultyDashboardDTO fetchDashboardDet(int portalId)
	{
		FacultyDashboardDTO facDash = facService.getDashDet(portalId);
		return facDash;
	}
	
	@PostMapping("/Notices")
	public boolean sendNotice(@RequestParam int id,String subject, String notice )
	{
		
		return facService.uploadNotice(id, subject, notice);
	}
	@PostMapping("/PrioNotices")
	public boolean sendPrioNotice(@RequestParam int id,String subject, String notice)
	{
		 return facService.uploadPrioNotice(id, subject, notice);
	}
	@PostMapping("/AddRec")
	public boolean addRec(@RequestBody MultipartFile videodetails,@RequestParam String moduleName,String topicName,int id)
	{
		try {
		mongoService.method1(videodetails,moduleName, topicName,id);
		}
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	@GetMapping("/getStudyMaterial")
	public List<Notes> getNotes()
	{
		return faculty.getNotesList();
	}
	@PostMapping("/addStudyMaterial")
	public boolean addNotes(@RequestBody MultipartFile file,@RequestParam String moduleName,String topicName,int id)
	{
		
		try {
		mongoService.addNotes(file,moduleName,topicName,id);
		}
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	@PostMapping ("/deleteMaterial")
	public boolean deleteMaterial(@RequestParam String baseId)
	{
		faculty.deleteMaterial(baseId);
		return true;
	}


	
}
