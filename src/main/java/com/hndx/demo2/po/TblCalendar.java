package com.hndx.demo2.po;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TblCalendar {
    //0 定义字段
    private int id;
    private String title;
    private String content;
    private int importance;
    private int ifOK;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date  finishDate;

    //1 定义属性 alt+insert
   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public int getIfOK() {
        return ifOK;
    }

    public void setIfOK(int ifOK) {
        this.ifOK = ifOK;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    //2空构造
    public TblCalendar() {
    }

    //3构造的重载
    public TblCalendar(String title, String content, int importance, int ifOK, Date finishDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.importance = importance;
        this.ifOK = ifOK;
        this.finishDate = finishDate;
    }

    //4重写方法toString()
    @Override
    public String toString() {
        return "TblCalendar{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", importance=" + importance +
                ", ifOK=" + ifOK +
                ", finishDate=" + finishDate +
                '}';
    }
}
