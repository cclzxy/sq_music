package com.example.demo.Pogo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "announce")
public class Announce {
    @Id
    private long ancid;
    private String contents;
    private String color;
    private String speed;


    public long getAncid() {
        return ancid;
    }

    public void setAncid(long ancid) {
        this.ancid = ancid;
    }


    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

}
