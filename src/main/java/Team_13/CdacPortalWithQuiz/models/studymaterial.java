package Team_13.CdacPortalWithQuiz.models;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fs.files")
public class studymaterial{

	@Id
	private String _id;
	
}
