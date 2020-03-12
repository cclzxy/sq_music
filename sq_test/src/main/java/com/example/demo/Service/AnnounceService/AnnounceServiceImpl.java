package com.example.demo.Service.AnnounceService;

import com.example.demo.Mapper.AnnounceMapper;
import com.example.demo.Pogo.Announce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnounceServiceImpl implements AnnounceService {
    @Autowired
    AnnounceMapper announceMapper;

    @Override
    public List<Announce> FindAllAnnounces() {
        return announceMapper.FindAllAnnounces();
    }

    @Override
    public Announce findannounce() {
        return announceMapper.findannounce();
    }

    @Override
    public int updateannounce(String contents) {
        return announceMapper.updateannounce(contents);
    }
}
