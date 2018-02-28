package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.UploadFile;

public interface UploadFileService {

	void saveFile(UploadFile file);
	UploadFile findById(int id);
	List<UploadFile> findAllFiles();
}
