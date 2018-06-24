package com.hndx.demo2.controller;

import com.alibaba.fastjson.JSON;
import com.hndx.demo2.po.TblCalendar;
import com.hndx.demo2.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController  //RestController返回的数据为json格式spring boot特有
public class CalendarController {
    //注入
    @Autowired
    private CalendarService calendarService;

    @RequestMapping("/calendarInsert")
    public  Object calendarInsert(HttpServletRequest req){
        //定义并接受变量 ,通过服务端的req对象的一个方法getParameter，然后接受title这个变量
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String finishDate = req.getParameter("finishDate");
        String ifOK = req.getParameter("ifOK");
        String importance = req.getParameter("importance");
        //封装到对象中
        try {
            TblCalendar tblCalendar = new TblCalendar(title ,content,Integer.parseInt(importance),Integer.parseInt(ifOK),new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(finishDate));

            //调用业务层的方法
            //返回值
            return calendarService.calendarInsert(tblCalendar);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    @RequestMapping("/calendarDelete")
    public  Object calendarDelete(HttpServletRequest req){
        String id = req.getParameter("id");
        return calendarService.calendarDelete(Integer.parseInt(id));
    }

    @RequestMapping("/calendarUpdate")
    public  Object calendarUpdate(HttpServletRequest req){
        //定义并接受变量 ,通过服务端的req对象的一个方法getParameter，然后接受title这个变量
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String finishDate = req.getParameter("finishDate");
        String ifOK = req.getParameter("ifOK");
        String importance = req.getParameter("importance");

        TblCalendar tblCalendar = calendarService.calendarSelectOne(Integer.parseInt(id));
        if(title!=null)
            tblCalendar.setTitle(title);
        if(content!=null)
            tblCalendar.setContent(content);
        if(finishDate!=null) {
            try {
                tblCalendar.setFinishDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(finishDate));
            } catch (ParseException e) {
                e.printStackTrace();
                return  -1;
            }
        }
        if(ifOK!=null)
            tblCalendar.setIfOK(Integer.parseInt(ifOK));
        if(importance!=null)
            tblCalendar.setImportance(Integer.parseInt(importance));

        //调用业务层的方法
        //返回值
        return calendarService.calendarUpdate(tblCalendar);

    }

    @RequestMapping("/calendarSelectOne")
    public Object calendarSelectOne(HttpServletRequest req){
        String id = req.getParameter("id");
        return JSON.toJSONString(calendarService.calendarSelectOne(Integer.parseInt(id)));
    }

    @RequestMapping("/calendarSelectAll")
    public Object calendarSelectAll(HttpServletRequest req){
        String pn = req.getParameter("page");
        String size = req.getParameter("size");

        if(pn==null)
            pn = "1";
        if(size==null)
            size =  ""+ Integer.MAX_VALUE;

        List<TblCalendar> calList = calendarService.calendarSelectAll(Integer.parseInt(pn),Integer.parseInt(size));

        Map<String,Object>  result = new HashMap<>();
        result.put("rowcount",calList.size());
        result.put("data",calList);

        return JSON.toJSONString(result);
    }
    @RequestMapping("/calendarSelectByIds")
    public List<TblCalendar> calendarSelectByIds(HttpServletRequest req){
        String ids = req.getParameter("ids");
        return calendarService.calendarSelectByIds(ids);
    }
}
