package com.dianwuyou.model;

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

    @Column(name = "content", nullable = false)
    @Lob
    private Blob content;

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
}
