package com.example.hx_test.demo.Pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "query")
public class querypojo {
    @Id
    private String schoolid;
    private String defautv;
    private String draw;
    private String isadmin;
    private String item;
    private String length;
    private String name;
    private String pageindex;
    private String pageno;
    private String schoolname;
    private String sortby;
    private String start;
    private String username;

    @Override
    public String toString() {
        return "Query{" +
                "schoolid='" + schoolid + '\'' +
                ", defautv='" + defautv + '\'' +
                ", draw='" + draw + '\'' +
                ", isadmin='" + isadmin + '\'' +
                ", item='" + item + '\'' +
                ", length='" + length + '\'' +
                ", name='" + name + '\'' +
                ", pageindex='" + pageindex + '\'' +
                ", pageno='" + pageno + '\'' +
                ", schoolname='" + schoolname + '\'' +
                ", sortby='" + sortby + '\'' +
                ", start='" + start + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid;
    }


    public String getDefautv() {
        return defautv;
    }

    public void setDefautv(String defautv) {
        this.defautv = defautv;
    }


    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }


    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPageindex() {
        return pageindex;
    }

    public void setPageindex(String pageindex) {
        this.pageindex = pageindex;
    }


    public String getPageno() {
        return pageno;
    }

    public void setPageno(String pageno) {
        this.pageno = pageno;
    }


    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }


    public String getSortby() {
        return sortby;
    }

    public void setSortby(String sortby) {
        this.sortby = sortby;
    }


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
