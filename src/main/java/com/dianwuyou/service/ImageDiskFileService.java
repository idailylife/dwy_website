package com.dianwuyou.service;

import com.dianwuyou.model.Task;
import com.dianwuyou.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by hebowei on 16/7/10.
 * 负责管理直接存储成磁盘文件的图片
 */
public interface ImageDiskFileService {
    void saveTaskCreationImage(final User user, final Task task) throws IOException;
}
