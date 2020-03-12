package com.example.demo.Service.MusicService;

import com.example.demo.Mapper.MusicMapper;
import com.example.demo.Pogo.Comment;
import com.example.demo.Pogo.Musiclist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service
public class MusicServiceImpl implements MusicService{
    @Autowired
    MusicMapper musicMapper;
    @Override
    public List<Musiclist> FindAllmusic() {
        return musicMapper.FindAllmusic();
    }

    @Override
    public List<Musiclist> FindAllmusicBydate(int pagenum,int pagesize) {
        return musicMapper.FindAllmusicBydate(pagenum,pagesize);
    }

    @Override
    public int pagemusic() {
        return musicMapper.pagemusic();
    }

    @Override
    public int intosql(String musicname, String musicsrc, String author, String musicdate, String imagesrc, String musictype, String musicdescribe) {
        return musicMapper.intosql(musicname,musicsrc,author,musicdate,imagesrc,musictype,musicdescribe);
    }

    @Override
    public void delmusic(int musicid) {
        musicMapper.delmusic(musicid);
    }


    @Override
    public String findamusic(String musicsrc) {
        return musicMapper.findamusic(musicsrc);
    }

    @Override
    public List<Musiclist> FindTopmusic() {
        return musicMapper.FindTopmusic();
    }

    @Override
    public List<Comment> findAllcomment() {
        return musicMapper.findAllcomment();
    }

    @Override
    public List<Musiclist> findmusicbypage(int pagenum, int pagesize) {
        return musicMapper.findmusicbypage(pagenum,pagesize);
    }

    @Override
    public int addcomment(int commentid, String comment, String comtime, String comscore, String coma, String comb, String comc, String comd, String come) {
        return musicMapper.addcomment(commentid,comment,comtime,comscore,coma,comb,comc,comd,come);
    }

}
