package com.dianwuyou.repo;

import com.dianwuyou.model.UpdFile;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by hebowei on 16/7/6.
 */
@Transactional
@Repository("updFileRepository")
public class UpdFileRepoImpl extends AbstractDao<Integer, UpdFile> implements UpdFileRepository {
    public UpdFile getById(int id) {
        return getByKey(id);
    }

    public UpdFile getByFileName(String fileName) {
        return (UpdFile) createEntityCriteria().add(Restrictions.eq("filename", fileName))
                .uniqueResult();
    }
}
