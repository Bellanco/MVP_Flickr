package com.deromang.daggersample.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import timber.log.Timber;

public class DateUtils {

    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String DETAIL_DATE_FORMAT = "yyyy-MM-dd' 'HH:mm:ss";

    private static String formatDate(String date, String inputDateFormat, String outputDateFormat) {
        if (date != null) {
            try {
                DateFormat input = new SimpleDateFormat(inputDateFormat);
                DateFormat outPut = new SimpleDateFormat(outputDateFormat);
                return outPut.format(input.parse(date));
            } catch (ParseException e) {
                String message = new StringBuilder("Error formateando fecha [date=").append(date)
                        .append(" | inputDateFormat=").append(inputDateFormat)
                        .append(" | outputDateFormat=").append(outputDateFormat)
                        .append("]").toString();
                Timber.e(e, message);
            }
        }
        return "";
    }

    public static String getDate(String date) {
        return formatDate(date, DETAIL_DATE_FORMAT, DATE_FORMAT);
    }

}
