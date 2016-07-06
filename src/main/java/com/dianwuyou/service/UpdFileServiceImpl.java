package com.dianwuyou.service;

import com.dianwuyou.model.UpdFile;
import com.dianwuyou.model.User;
import com.dianwuyou.repo.UpdFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by hebowei on 16/7/6.
 */
@Transactional
@Service("updFileService")
public class UpdFileServiceImpl implements UpdFileService {
    @Autowired
    UpdFileRepository updFileRepository;

    public UpdFile getUserOwnedFile(User user, int fileId) {
        UpdFile file = updFileRepository.getById(fileId);
        if(file != null && file.hasAuthority(user.getId())){
            return file;
        }
        return null;
    }

    public UpdFile getUserOwnedFile(User user, String fileName) {
        UpdFile file = updFileRepository.getByFileName(fileName);
        if(file != null && file.hasAuthority(user.getId())){
            return file;
        }
        return null;
    }
}
