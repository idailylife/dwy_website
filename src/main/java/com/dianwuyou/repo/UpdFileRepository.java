package com.dianwuyou.repo;

import com.dianwuyou.model.UpdFile;

/**
 * Created by hebowei on 16/7/6.
 */
public interface UpdFileRepository {
    UpdFile getById(int id);
    UpdFile getByFileName(String fileName);
    //Does not allow creating independent UpdFile
    //Save and update operations are restricted by calling methods in User (or other models)
}
