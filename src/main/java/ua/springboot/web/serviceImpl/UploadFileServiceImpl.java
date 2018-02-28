package ua.springboot.web.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.UploadFile;
import ua.springboot.web.repository.UploadFileRepository;
import ua.springboot.web.service.UploadFileService;

@Service
public class UploadFileServiceImpl implements UploadFileService{

	@Autowired
	private UploadFileRepository fileRep;
	
	@Override
	public void saveFile(UploadFile file) {
		fileRep.save(file);
	}

	@Override
	public UploadFile findById(int id) {
		return fileRep.findOne(id);
	}

	@Override
	public List<UploadFile> findAllFiles() {
		return fileRep.findAll();
	}

}
