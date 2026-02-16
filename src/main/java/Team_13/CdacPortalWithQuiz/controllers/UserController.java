package Team_13.CdacPortalWithQuiz.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;



import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties.Gridfs;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.util.StreamUtils;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;

import Team_13.CdacPortalWithQuiz.DTO.LoginStatusDto;
import Team_13.CdacPortalWithQuiz.DTO.ProfilePicDTO;
import Team_13.CdacPortalWithQuiz.models.User;
import Team_13.CdacPortalWithQuiz.models.mongoVideo;

import Team_13.CdacPortalWithQuiz.models.studymaterial;
import Team_13.CdacPortalWithQuiz.repository.UserRepository;
import Team_13.CdacPortalWithQuiz.services.MailService;
import Team_13.CdacPortalWithQuiz.services.OtpGenerator;
import Team_13.CdacPortalWithQuiz.services.UserServicesImpl;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	UserServicesImpl uservice;
	@Autowired
	OtpGenerator op1;
	//////////////
	@Autowired
	GridFsTemplate gridfs;
	@Autowired
	GridFsOperations gridop;
	///////

	
	@PostMapping("/register")
	public boolean registerUser(@RequestBody User user)
	{
		boolean status = uservice.registerService(user);
		return status;
	}
	
	@PostMapping("/login")
	public LoginStatusDto loginUser(@RequestParam String email,String password)
	{
		return uservice.loginService(email, password);
	}
	
	@PostMapping("/ForgetPasswordGenerateOtp")
	public boolean generateOtp(@RequestParam String email)
	{
		
		if(uservice.sendOtp(email))
		{
		return true;
		}
	
			return false;
	
	}
	
	@PostMapping("/verifyOtp")
	public boolean verifyOtp(@RequestParam String otp)
	{
		
		if(op1.verifyOtp(otp))
		{
		   return true;
		}
		return false;
	}
	
	@PostMapping("/updatePassword")
	public boolean updatePassword(@RequestParam String newPassword,@RequestParam String email )
	{
		
		uservice.passwordUpdateService(email, newPassword);
	    return true;
	}
	@PostMapping("/imageUpload")
	public boolean uplaodImage(@RequestBody MultipartFile profilePic,int id)
	{
		System.out.println(profilePic);
		System.out.println(id);
		ProfilePicDTO newPic = new ProfilePicDTO();
		newPic.setId(id);
		newPic.setProfilePic(profilePic);
		
	  return uservice.uploadImage(newPic);
    }
	@GetMapping( value = "/getpropic",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageWithMediaType(@RequestParam int id) throws IOException {
		 return uservice.getImage(id);	
	}
	
//	@PostMapping("/mongo")
//	public String method1(@RequestBody MultipartFile videorec)throws IOException
//	{
//		DBObject metadata = new BasicDBObject();
//		metadata.put("type","video");
//		metadata.put("title", "myvideo");
//		ObjectId id = gridfs.store(videorec.getInputStream(),metadata);
//		System.out.println(id.toString());
//		return id.toString();
//	}
//	
//	@GetMapping("/videoView.mp4")
//	public void getVideo(HttpServletResponse response)throws Exception
//	{
//		GridFSFile file1= gridfs.findOne(new Query(Criteria.where("_id").is("624b465c73c54149c75743be")));  
//		mongoVideo video = new mongoVideo();
//		video.setStream(gridop.getResource(file1).getInputStream());
//		try {
//		FileCopyUtils.copy(video.getStream(),response.getOutputStream());
//		}
//		catch(Exception e)
//		{
//			
//		}
//	}
}
