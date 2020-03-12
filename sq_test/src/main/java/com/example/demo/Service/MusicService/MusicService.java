package com.example.demo.Service.MusicService;

import com.example.demo.Pogo.Comment;
import com.example.demo.Pogo.Musiclist;

import java.sql.Date;
import java.util.List;

public interface MusicService {
    List<Musiclist> FindAllmusic();

    List<Musiclist> FindAllmusicBydate(int pagenum, int pagesize);

    int pagemusic();

    int intosql(String musicname, String musicsrc, String author, String musicdate, String imagesrc, String musictype, String musicdescribe);

    void delmusic(int musicid);

    String findamusic(String musicsrc);

    List<Musiclist> FindTopmusic();

    List<Comment> findAllcomment();

    List<Musiclist> findmusicbypage(int pagenum, int pagesize);

    int addcomment(int commentid, String comment, String comtime, String comscore, String coma, String comb, String comc, String comd, String come);

}
