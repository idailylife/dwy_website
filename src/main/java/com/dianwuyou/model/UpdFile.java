package com.dianwuyou.model;

import com.dianwuyou.util.Encoding;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.sql.Blob;

/**
 * Created by hebowei on 16/6/10.
 * 上传的(隐私)文件存储在这
 */
@Entity
@Table(name = "file")
public class UpdFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "filename", unique = true, nullable = false)
    @Length(max = 128)
    private String filename;

    @Column(name = "owner", nullable = false)
    private Integer owner;    //Set to OWNER_PUBLIC for public visibility
    public final static int OWNER_PUBLIC = 0;

    @Column(name = "content", nullable = false)
    @Lob
    private Blob content;

    public UpdFile(){
        owner = OWNER_PUBLIC;
    }

    public UpdFile(int ownerId){
        owner = ownerId;
    }

    /**
     * Add random uuid(trimmed to 16 bytes) as the prefix of filename
     * @param filename
     */
    public void setFilenameWithUuid16(String filename){
        this.filename = Encoding.getRandomUUID().substring(16) + "_" + filename;
    }

    public boolean hasAuthority(int userId){
        if(owner.equals(OWNER_PUBLIC))
            return true;
        else if(owner.equals(userId))
            return true;
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Blob getContent() {
        return content;
    }

    public void setContent(Blob content) {
        this.content = content;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }
}
