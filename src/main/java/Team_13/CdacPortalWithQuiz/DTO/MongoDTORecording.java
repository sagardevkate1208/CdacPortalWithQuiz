package Team_13.CdacPortalWithQuiz.DTO;

import org.springframework.web.multipart.MultipartFile;

public class MongoDTORecording {
	
	MultipartFile videorec;
	String moduleName;
	String topicName;
	int userid;
	public MultipartFile getVideorec() {
		return videorec;
	}
	public void setVideorec(MultipartFile videorec) {
		this.videorec = videorec;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
