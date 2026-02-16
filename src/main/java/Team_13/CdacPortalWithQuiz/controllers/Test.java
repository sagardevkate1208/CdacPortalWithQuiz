//package Team_13.CdacPortalWithQuiz.controllers;
//
//import com.google.api.client.http.FileContent;
//import com.google.api.services.drive.Drive;
//import com.google.api.services.drive.model.File;
//
//public class Test {
//	
//	public void method1()
//	{
//	File fileMetadata = new File();
//	 Drive drive = driveFactory.getDrive(this.credential);
//	fileMetadata.setName("photo.jpg");
//	java.io.File filePath = new java.io.File("F:\\CDAC\\FinalProject-Team-13\\Demo.jpg");
//	FileContent mediaContent = new FileContent("image/jpeg", filePath);
//	File file = driveI.files().create(fileMetadata, mediaContent)
//	    .setFields("id")
//	    .execute();
//	System.out.println("File ID: " + file.getId());
//	}
//
//}
