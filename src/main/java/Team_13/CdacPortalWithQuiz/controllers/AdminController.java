
package Team_13.CdacPortalWithQuiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Team_13.CdacPortalWithQuiz.DTO.AdminDashboardDTO;
import Team_13.CdacPortalWithQuiz.models.User;
import Team_13.CdacPortalWithQuiz.services.AdminServices;

@RestController
@CrossOrigin
@RequestMapping("/Admin")
public class AdminController {
	@Autowired
	AdminServices adminServ;
	
	@GetMapping ("/getDashdetails")
	public AdminDashboardDTO getDashDetails()
	{
		return adminServ.getDashDetails();
	}
	
	@GetMapping("/getFacultyList")
	public List<User> getfacList()
	{
		List<User> list = adminServ.getfacList();
		return list;
	}
	@GetMapping("/getStudentList")
	public List<User> getStdList()
	{
		List<User> list = adminServ.getStudList();
		return list;
	}
	@PostMapping("/disableAcc")
	public void disableAccount(@RequestParam int id)
	{
		adminServ.disableAcc(id);
	}
	@PostMapping("/enableAcc")
	public void enableAccount(@RequestParam int id)
	{
		adminServ.enableAcc(id);
	}
}
