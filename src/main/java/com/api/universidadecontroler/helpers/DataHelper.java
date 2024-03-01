package com.api.universidadecontroler.helpers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataHelper {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public static Date converterStringParaData(String dataString) throws ParseException {
        return formatter.parse(dataString);
    }
    public static String converterDataParaString(Date data) {
        return formatter.format(data);
    }
}