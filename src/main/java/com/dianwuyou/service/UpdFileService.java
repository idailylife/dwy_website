package com.dianwuyou.service;

import com.dianwuyou.model.UpdFile;
import com.dianwuyou.model.User;

/**
 * Created by hebowei on 16/7/6.
 */
public interface UpdFileService {
    UpdFile getUserOwnedFile(User user, int fileId);
    UpdFile getUserOwnedFile(User user, String fileName);
}
