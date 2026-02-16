package Team_13.CdacPortalWithQuiz.DTO;

import java.io.InputStream;

public class RecordingDTO {
	private String title;
	private InputStream stream;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public InputStream getStream() {
		return stream;
	}
	public void setStream(InputStream stream) {
		this.stream = stream;
	}
}
