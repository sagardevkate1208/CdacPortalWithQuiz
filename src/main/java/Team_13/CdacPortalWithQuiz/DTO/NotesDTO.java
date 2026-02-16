package Team_13.CdacPortalWithQuiz.DTO;

import org.springframework.web.multipart.MultipartFile;

public class NotesDTO {
	
	private int notelink;
	private String topicName;
	private int id;
	private MultipartFile file;
	public int getNotelink() {
		return notelink;
	}
	public void setNotelink(int notelink) {
		this.notelink = notelink;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	

}
