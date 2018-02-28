package ua.springboot.web.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javassist.bytecode.ByteArray;
import ua.springboot.web.entity.UploadFile;
import ua.springboot.web.repository.UserRepository;
import ua.springboot.web.service.UploadFileService;

@Controller
@RequestMapping("/file")
public class UploadFileController {

	@Autowired
	private UploadFileService fileService;
	
	@GetMapping("/upload")
	public String showUploadPage() {
		return "file/upload";
	}
	
	@PostMapping("/upload")
	public String saveFileToDB(@RequestParam("fileUpload") MultipartFile file) throws IOException {
		if(!file.isEmpty() && file!=null) {
			UploadFile uploadFile = new UploadFile();
			uploadFile.setFileName(file.getOriginalFilename());
			uploadFile.setFileData(file.getBytes());
			fileService.saveFile(uploadFile);
		}
		return "redirect:/file/preview";
	}
	
	@GetMapping("/preview")
	public String showPreviewPage(Model model) {
		UploadFile file=fileService.findById(1);
		String encodeFile = new String(Base64.encodeBase64(file.getFileData()));
		model.addAttribute("imageSrc", encodeFile);
		return "file/preview";
	}
	
	@PostMapping("upload/to-project")
	public String saveFileToProject(@RequestParam("fileUpload") MultipartFile file) throws IOException {
		
		String rootPath = System.getProperty("user.dir");
		File uploadDir = new File(rootPath + File.separator + "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "upload");
		if(!uploadDir.exists()) {
			uploadDir.mkdir(); 
			}
		if(!file.isEmpty() && file != null) {
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			File destination = new File(uploadDir.getAbsolutePath()+ File.separator + file.getOriginalFilename());				ImageIO.write(image, "jpg", destination);
		}
		
		return "redirect:/file/preview";
	}
}
/*


@GetMapping("/upload")
public String showUploadForm() {
	// form - enctype="multipart/form-data"
	// <input type="file" name="fileUpload">
	String methodName = "showUploadForm";
	log.debug("Start: " + methodName);
	return "file/upload";
}


@PostMapping("/upload/to-db")
public String saveFileToDatabase(@RequestParam("fileUpload") MultipartFile file) throws IOException {
	if (file != null && file.getSize() > 0) {
		UploadFile uploadFile = new UploadFile(); // id = null
		uploadFile.setFileName(file.getOriginalFilename());
		uploadFile.setFileData(file.getBytes());
		uploadFileService.saveFile(uploadFile); 
		// id = value in DB
	}
	return "redirect:/file/show";
}



@PostMapping("/upload/project-directory")
public String saveFileToProjectWorkspace(@RequestParam("fileUpload") MultipartFile file) throws IOException {

	String rootPath = System.getProperty("user.dir");
	File uploadDir = new File(rootPath + File.separator + 
			"src" + File.separator + "main" + File.separator
			+ "webapp" + File.separator + "upload"); 
	 E:/LOGOS/Test/SpringBootWebApp/src/main/webapp/upload 

	if (!uploadDir.exists()) uploadDir.mkdir();
	
	if (!file.isEmpty() && file != null) {
		BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
		File destination = new File(uploadDir.getAbsolutePath() + File.separator + file.getOriginalFilename());
		ImageIO.write(image, "png", destination);
	}
	return "redirect:/file/show";
}


 SAVE FILE TO FOLDER ON DISK(specific location)
@PostMapping("/upload/disk")
public String saveFileBySpecificPathOnDisk(@RequestParam("fileUpload") MultipartFile file) throws IOException {
	String localDisk = "E:";
	File rootPath = new File(localDisk + File.separator + "tmp"); // E:/tmp
	if(!rootPath.exists()) rootPath.mkdir();
	
	if (!file.isEmpty() && file != null) {
		BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
		File destination = new File(rootPath.getAbsolutePath() + File.separator + file.getOriginalFilename());
		ImageIO.write(image, "png", destination);
	}
	return "redirect:/file/show";
}

 SHOW IMAGE FROM DATABASE
@GetMapping("/show")
public String showImageFromDatabase(Model model) {
	
	Show only 1 file from DB 
	UploadFile file = uploadFileService.findUploadFileById(1);
	String encodedFile = new String(Base64.encodeBase64(file.getFileData()));
	model.addAttribute("imageSrc", encodedFile);
	
	<-- <img src="data:image/png;base64,${imageSrc}"/> -->
	
	//List<UploadFile> file = uploadFileService.findAllFiles();
    //List<String> encodedFiles = new ArrayList<>();
	//for (int i = 0; i < file.size(); i++ ) {
	//	String encodeToBase64 = new String(Base64.encodeBase64(file.get(i).getFileData()));
	//	encodedFiles.add(encodeToBase64);
	//}
	//model.addAttribute("imageSrcs", encodedFiles);
	
	return "file/preview";
}


@GetMapping("/show/from-disk")
public String getFileFromDisk(Model model) throws IOException {
	String localDisk = "E:";
	File file = new File(
			localDisk + File.separator + 
			"tmp" + File.separator + 
			"server.conf.png");  // E:/tmp/server.conf.png
	byte[] encodeFileToByte = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
	String encodedFileBase64 = new String(encodeFileToByte);
	model.addAttribute("imageFromDisk", encodedFileBase64);
	return "file/preview";
}

//======================================================================================	

@PostMapping("/upload")
public String saveUploadedFile(@RequestParam MultipartFile fileUpload) throws IOException {
	if (fileUpload != null && fileUpload.getSize() > 0) {
		UploadFile file = new UploadFile();
		file.setFileName(fileUpload.getOriginalFilename());
		file.setFileData(fileUpload.getBytes());
		uploadFileService.saveFile(file);
	}
	return "redirect:/";
}

@GetMapping("/listOfFiles")
public String readImageFromDB(Model model) throws IOException {

	// Read From DB
	UploadFile file = uploadFileService.findUploadFileById(2);
	String base64EncodedStr = new String(Base64.encodeBase64(file.getFileData()));
	model.addAttribute("imageSrc", base64EncodedStr);

	// Read From Local disk
	File diskFile = new File("E:/tmp/12.PNG");
	byte[] encodeDiskImage = Base64.encodeBase64(FileUtils.readFileToByteArray(diskFile));
	model.addAttribute("imageSrcFromDisk", new String(encodeDiskImage));
	return "file/file";
}

@PostMapping("/upload/1")
public String saveUploadedFileToDisk(@RequestParam(name = "fileUpload") MultipartFile fileUpload) {
	if (!fileUpload.isEmpty() && fileUpload != null) {
		try {
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(fileUpload.getBytes()));
			File destination = new File("E:/tmp/" + fileUpload.getOriginalFilename());
			ImageIO.write(src, "png", destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	return "redirect:/";
}
*/
