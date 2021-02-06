/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author user
 */
public class ConvData {
    public java.sql.Date convertData (Date data) throws Exception{
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
        String dateString = formatDate.format(data);
        if (data == null || data.equals(""))
            return null;
        
        java.sql.Date date  = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            date = new java.sql.Date(((java.util.Date)formatter.parse(dateString)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
    
}
