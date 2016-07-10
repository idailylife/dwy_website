package com.dianwuyou.service;

import com.dianwuyou.model.Task;
import com.dianwuyou.model.User;
import com.dianwuyou.util.Constants;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by hebowei on 16/7/10.
 */
@Service("imageDiskFileService")
public class ImageDiskFileServiceImpl implements ImageDiskFileService {
    public void saveTaskCreationImage(User user, Task task) throws IOException {
        String storePath = Constants.UPLOAD_FILE_STORE_LOCATION  +
                "/" + user.getId() + "/" + task.getId() + "/";
        File file = new File(storePath);
        if(!file.exists()){
            if(!file.mkdirs()){
                throw new IOException("Cannot make directory to save image");
            }
        }
        file = new File(storePath + task.getImage().getOriginalFilename());
        FileCopyUtils.copy(task.getImage().getBytes(), file);
    }
}
