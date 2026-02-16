package Team_13.CdacPortalWithQuiz.services;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;

import Team_13.CdacPortalWithQuiz.models.Notes;
import Team_13.CdacPortalWithQuiz.models.RecordingsManagement;
import Team_13.CdacPortalWithQuiz.models.User;
import Team_13.CdacPortalWithQuiz.models.mongoVideo;
import Team_13.CdacPortalWithQuiz.repository.FacultyRepository;
import Team_13.CdacPortalWithQuiz.repository.UserRepository;



@Service
public class MongoDBServices {
	@Autowired
	GridFsTemplate gridfstemplete;
	@Autowired
	GridFsOperations gridop;
	@Autowired
	FacultyRepository facrepo;
	@Autowired
	UserRepository userrepo;
	
	public boolean method1(MultipartFile videorec ,String moduleName,String topicName, int userid)throws IOException
	{
		DBObject metadata = new BasicDBObject();
		metadata.put("type","video");
		metadata.put("title", moduleName+topicName);
		ObjectId id = gridfstemplete.store(videorec.getInputStream(),videorec.getName(),metadata);
		RecordingsManagement recMgmt = new RecordingsManagement();
		recMgmt.setModuleName(moduleName);
		recMgmt.setObjectId(id.toString());
		recMgmt.setTopicName(topicName);
		recMgmt.setUploadDate(LocalDate.now());
		User user = userrepo.getUserById(userid);
		recMgmt.setUser(user);
		facrepo.addRecording(recMgmt);
		return true;
	}

	public boolean addNotes(MultipartFile file, String moduleName, String topicName, int userid) throws IOException {
		
		DBObject metadata = new BasicDBObject();
		metadata.put("type","pdf");
		metadata.put("title", moduleName+topicName);
		ObjectId id = gridfstemplete.store(file.getInputStream(),file.getName(),metadata);
		Notes note = new Notes();
		note.setBaseId(id.toString());
		note.setTopicName(topicName);
		note.setUploadDate(LocalDate.now());
		User user = userrepo.getUserById(userid);
		note.setUser(user);
		facrepo.addNote(note);
		return true;
	}

}
