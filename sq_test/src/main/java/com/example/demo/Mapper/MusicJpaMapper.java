package com.example.demo.Mapper;

import com.example.demo.Pogo.Musiclist;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface MusicJpaMapper extends JpaRepository<Musiclist, String> {
    List<Musiclist> findByMusicsrcLike(String musicname);//音乐名称模糊查询
}
