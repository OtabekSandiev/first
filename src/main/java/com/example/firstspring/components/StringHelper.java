package com.example.firstspring.components;



import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringHelper {

    public String toString(Object o){
        try {
            return String.valueOf(o);
        }catch (Exception e){
            return null;
        }
    }

    public String capitalize(String s){
        return StringUtils.capitalize(s);
    }

    public String dateToString(String date){
        //dd-mm-yyyy
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }

    public String parseToDate(String s){
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return String.valueOf(format.parse(s));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
