package com.example.demo.Mapper;

import com.example.demo.Pogo.Announce;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnnounceMapper {
    @Select("select * from announce")//找到所有评论
    List<Announce> FindAllAnnounces();
    @Select("select * from announce where ancid=1")//找到一个公告
    Announce findannounce();
    @Update("update announce set contents=#{contents} where ancid=1")//更新公告
    int updateannounce(String contents);
}
