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
			if(!file.isEmpty() && file != null) {
				BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
				File destination = new File(uploadDir.getAbsolutePath()+ File.separator + file.getOriginalFilename());
				ImageIO.write(image, "jpg", destination);
			}
		}
		return "redirect:/file/preview";
	}
}
