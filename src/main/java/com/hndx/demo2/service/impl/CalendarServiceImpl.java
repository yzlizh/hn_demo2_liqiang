package com.hndx.demo2.service.impl;

import com.hndx.demo2.dao.CalendarDao;
import com.hndx.demo2.po.TblCalendar;
import com.hndx.demo2.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private CalendarDao calendarDao;

    @Override
    public int calendarInsert(TblCalendar tblCalendar) {
        return calendarDao.calendarInsert(tblCalendar);
    }

    @Override
    public int calendarDelete(int id) {
        return calendarDao.calendarDelete(id);
    }

    @Override
    public int calendarUpdate(TblCalendar tblCalendar) {
        return calendarDao.calendarUpdate(tblCalendar);
    }

    @Override
    public TblCalendar calendarSelectOne(int id) {
        return calendarDao.calendarSelectOne(id);
    }

    @Override
    public List<TblCalendar> calendarSelectAll(int pn, int size) {
        return calendarDao.calendarSelectAll(pn,  size);
    }

    @Override
    public List<TblCalendar> calendarSelectByIds(String ids) {
        return calendarDao.calendarSelectByIds(ids);
    }
}
