package com.medicalpractitioner.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeProcessor {
    public static LocalDate StrTransIntoLocalDate(String strDate){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate = LocalDate.parse(strDate, fmt);
        return parsedDate;
    }
}
