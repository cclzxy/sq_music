package com.example.demo.Service.AnnounceService;

import com.example.demo.Pogo.Announce;

import java.util.List;

public interface AnnounceService {
    List<Announce> FindAllAnnounces();
    Announce findannounce();
    int updateannounce(String contents);
}
