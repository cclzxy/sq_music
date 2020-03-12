package com.example.demo.Mapper;

import com.example.demo.Pogo.Comment;
import com.example.demo.Pogo.Musiclist;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MusicMapper {
    //评论添加
    @Insert("insert into comment values(#{commentid},#{comment},#{comtime},#{comscore},#{coma},#{comb},#{comc},#{comd},#{come})")
    int addcomment(int commentid, String comment,String comtime,String comscore,String coma,String comb,String comc,String comd,String come);

    //评论展示
    @Select("select * from comment")
    List<Comment> findAllcomment();

    //查询所有音乐，返回List
    @Select("select * from musiclist")
    List<Musiclist> FindAllmusic();

    //查询音乐数量，用作分页
    @Select("select count(1) from musiclist")
    int pagemusic();

    //新增音乐
    @Insert("insert into musiclist(musicname,musicsrc,author,musicdate,imagesrc,musictype,musicdescribe) values(#{musicsrc},#{musicname},#{author},#{musicdate},#{imagesrc},#{musictype},#{musicdescribe})")
    int intosql(String musicname, String musicsrc, String author, String musicdate, String imagesrc, String musictype, String musicdescribe);

    //删除音乐
    @Delete("delete from musiclist where musicid=#{musicid}")
    void delmusic(int musicid);

    //
    @Select("select musicname from musiclist where musicsrc=#{musicsrc}")
    String findamusic(String musicsrc);

    //查询热度前10名的音乐
    @Select("select  * from musiclist order by musiclike desc limit 0,10")
    List<Musiclist> FindTopmusic();

    //分页查询音乐(第一个是从第几个开始，第二个是一次性拿多少个)
    @Select("select * from musiclist limit #{pagenum},#{pagesize}")
    List<Musiclist> findmusicbypage(int pagenum, int pagesize);

    //查询所有音乐，进行时间排序
    @Select("select * from musiclist order by musicdate desc limit #{pagenum},#{pagesize}")
    List<Musiclist> FindAllmusicBydate(int pagenum, int pagesize);
}
