package com.yedam.app.board.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@Value("${file.upload.path}") //파일 경로 //application.properties KEY 값
	private String uploadPath; //
	
	@GetMapping("upload")
	public void getUploadPath() { //페이지 호출
	}
	
	@PostMapping("/uploadsAjax")
	@ResponseBody
//	public List<String> uploadFile(@RequestPart MultipartFile[] uploadFiles) { 
//		List<String> imageList = new ArrayList<>();

	public void uploadFile(@RequestPart MultipartFile[] uploadFiles) { //사용자가 보낸 멀티미디어 파일 -> 배열로 저장 ( 다중처리 가능 )
		// MultipartFile[] : Spring이 제공
		
	    for(MultipartFile uploadFile : uploadFiles){
	    	
	    	//image로 시작하는 타입인지 확인 ( 동영상 등 다른 파일을 다 다중처리할 경우 생략하면 됨.)
	    	if(uploadFile.getContentType().startsWith("image") == false){
	    		System.err.println("this file is not image type");
	    		return;
	    		//return null;
	        }
	    	
	        String originalName = uploadFile.getOriginalFilename(); //사용자가 업로드한 파일 이름.
	        String fileName = originalName.substring(originalName.lastIndexOf("//")+1); //받아온 정보 필요한 만큼만 이름을 추출함.
	        
	        System.out.println("fileName : " + fileName);
	    

	        //날짜 폴더 생성
	        String folderPath = makeFolder();
	        //UUID //unique한 이름으로 지정함.
	        String uuid = UUID.randomUUID().toString();
	        //저장할 파일 이름 중간에 "_"를 이용하여 구분
	        
	        //1)
//	        String saveName = uploadPath + File.separator + folderPath +File.separator + uuid + "_" + fileName;
	        
	        //2)
	        String uploadFileName = folderPath +File.separator + uuid + "_" + fileName;
	        String saveName = uploadPath + File.separator + uploadFileName;
	        
	        // Path : 업로드한 실제 경로( c:드라이브/upload/2023/06/12/sldkfm+이미지이름.jpg )를 가지고 있음. //
	        Path savePath = Paths.get(saveName);
	        //Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
	        System.out.println("path : " + saveName);
	        try{
	        	//transferTo : 업로드하는 역할 - 내부에 저장된 실제 파일은 Path에 저장된 경로로 보내주는 역할?
	        	uploadFile.transferTo(savePath);
	            // ★★★ uploadFile에 파일을 업로드 하는 메서드 transferTo(file) ★★★ 가장 핵심!!
	        } catch (IOException e) {
	             e.printStackTrace();	             
	        }
	        
	        //DB에 해당 경로 저장
	        //1) 사용자가 업로드할 때 사용한 파일 명.
	        //2) 실제 서버에 업로드할 때 사용한 경로.
	        //---> 1), 2) 둘다 같이 저장해야함.
	        //imageList.add(setImagePath(uploadFileName));
	        String imagePath = uploadFileName.replace(File.separator, "/");
	        System.out.println("uploadFileName : "+uploadFileName); 
	        	// 2023\06\12\952ccf68-03f5-47e5-8124-a3def63db88a_말.jpg
	        	// 운영체제 or 리눅스에서 경로 --> \ 역슬래시로 적용
	        		
	        System.out.println("imagePath : "+imagePath);
	        	// 2023/06/12/952ccf68-03f5-47e5-8124-a3def63db88a_말.jpg
	        	// 경로에선 /슬래시로 구분함.
	     }
	    
	    //return imageList;
	}

	private String makeFolder() {
		//오늘 날짜를 기준으로 파일 이름에 붙여줘서 unique하게 지정함. //서버에서 충돌되지 않도록하기 위함
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		// LocalDate를 문자열로 포멧
		String folderPath = str.replace("/", File.separator);

		File uploadPathFoler = new File(uploadPath, folderPath); //사용자가 업로드한 파일을 가공한 후(L68~) 파일 경로 밑에 생성해줌.(L12)
		// File newFile= new File(dir,"파일명");

		if (uploadPathFoler.exists() == false) {
			uploadPathFoler.mkdirs();
			// 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다.
			// mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
			// mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
		}
		return folderPath;
	}
	
//	private String setImagePath(String uploadFileName) {
//		return uploadFileName.replace(File.separator, "/");
//	}
}
