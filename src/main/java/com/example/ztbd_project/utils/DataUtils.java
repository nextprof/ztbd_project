package com.example.ztbd_project.utils;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUtils {

    private static final DateTimeFormatter SQL_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static String[] deserializerFormatters = new String[]{
            "dd.MM.yyyy HH:mm:ss",
            "dd.MM.yyyy HH:mm",
            "dd.MM.yyyy",
            "yyyy-MM-dd'T'HH:mm:ss",
            "yyyy-MM-dd'T'HH:mm",
            "yyyy-MM-dd'T'HH:mm:ss",
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd HH:mm",
            "dd.MM.yyyy HH:mm",
            "MM/dd/yyyy HH:mm:ss",
            "MM/dd/yyyy HH:mm",
            "MM/dd/yyyy",
            "yyyy.MM.dd",
            "yyyy.MM.dd HH:mm",
            "yyyy.MM.dd HH:mm:ss",
    };

    static public LocalDateTime getDateFromString(String dateString) {
        if (dateString == null)
            return null;
        Pattern p = Pattern.compile(".*([01]?[0-9]|2[0-3]):[0-5][0-9].*");
        Matcher m = p.matcher(dateString);
        if (!m.matches()) {
            dateString = dateString + " 00:00:00";
        }
        for (String deserializerFormat : DataUtils.deserializerFormatters) {
            try {

                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(deserializerFormat);

                LocalDateTime dateTime = LocalDateTime.parse(dateString, dateTimeFormatter);
                return dateTime;
            } catch (DateTimeParseException e) {
            }
        }
        try {
            OffsetDateTime zonedDate = OffsetDateTime.parse(dateString, DateTimeFormatter.ISO_ZONED_DATE_TIME);
            return zonedDate.withOffsetSameInstant(ZoneOffset.UTC).toLocalDateTime();
        } catch (DateTimeParseException e) {
        }
        try {
            return LocalDateTime.parse(dateString);
        } catch (DateTimeParseException e) {

        }
        return null;
    }
}
