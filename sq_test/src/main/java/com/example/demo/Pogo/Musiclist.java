package com.example.demo.Pogo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "musiclist")
public class Musiclist {
    @Id
    private long musicid;
    private String musicname;
    private String musicsrc;
    private long musiclike;
    private String author;
    private String musicdate;
    private String school;
    private String remark;
    private String musictype;
    private String musicdescribe;
    private String musicfirst;
    private String imagesrc;


    public long getMusicid() {
        return musicid;
    }

    public void setMusicid(long musicid) {
        this.musicid = musicid;
    }


    public String getMusicname() {
        return musicname;
    }

    public void setMusicname(String musicname) {
        this.musicname = musicname;
    }


    public String getMusicsrc() {
        return musicsrc;
    }

    public void setMusicsrc(String musicsrc) {
        this.musicsrc = musicsrc;
    }


    public long getMusiclike() {
        return musiclike;
    }

    public void setMusiclike(long musiclike) {
        this.musiclike = musiclike;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getMusicdate() {
        return musicdate;
    }

    public void setMusicdate(String musicdate) {
        this.musicdate = musicdate;
    }


    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public String getMusictype() {
        return musictype;
    }

    public void setMusictype(String musictype) {
        this.musictype = musictype;
    }


    public String getMusicdescribe() {
        return musicdescribe;
    }

    public void setMusicdescribe(String musicdescribe) {
        this.musicdescribe = musicdescribe;
    }


    public String getMusicfirst() {
        return musicfirst;
    }

    public void setMusicfirst(String musicfirst) {
        this.musicfirst = musicfirst;
    }


    public String getImagesrc() {
        return imagesrc;
    }

    public void setImagesrc(String imagesrc) {
        this.imagesrc = imagesrc;
    }

}
