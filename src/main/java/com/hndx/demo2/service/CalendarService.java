package com.hndx.demo2.service;

import com.hndx.demo2.po.TblCalendar;

import java.util.List;

public interface CalendarService {
    public int calendarInsert(TblCalendar tblCalendar);
    public int calendarDelete(int id);
    public int calendarUpdate(TblCalendar tblCalendar);
    public TblCalendar calendarSelectOne(int id);
    public List<TblCalendar> calendarSelectAll(int pn, int size);
    public List<TblCalendar> calendarSelectByIds(String ids);
}
