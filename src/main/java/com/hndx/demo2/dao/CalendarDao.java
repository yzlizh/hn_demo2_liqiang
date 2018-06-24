package com.hndx.demo2.dao;

import com.hndx.demo2.po.TblCalendar;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CalendarDao {
    //insert
    @Insert("insert into tblCalendar(id,title,content,finishDate,ifOK,importance) values(SEQ_CALENDARID.nextval,#{title},#{content},#{finishDate},#{ifOK},#{importance})")
    public int calendarInsert(TblCalendar tblCalendar);

    //delete
    @Delete("delete from tblCalendar where id=#{id}")
    public int calendarDelete(int id);

    //update
    @Update("update tblCalendar set title=#{title},content=#{content},finishDate=#{finishDate},ifOK=#{ifOK},importance=#{importance} where id=#{id}")
    public int calendarUpdate(TblCalendar tblCalendar);

    //selectOne
    @Select("select * from tblCalendar where id=#{id} ")
    public TblCalendar calendarSelectOne(int id);

    //selectAll
    @Select("select * from (select t.* ,rownum rn from (select * from TBLCALENDAR order by id) t where rownum<=#{pn}* #{size} ) where rn>(#{pn}-1)*#{size}")
    public List<TblCalendar> calendarSelectAll(@Param("pn") int pn ,@Param("size") int size);


    // byids
    @Select("select * from tblCalendar where id in (#{id}) ")
    public List<TblCalendar> calendarSelectByIds(String ids);
}
