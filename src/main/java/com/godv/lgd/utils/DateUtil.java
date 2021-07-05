package com.godv.lgd.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.StringUtils;

public class DateUtil {
    public static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static DateTimeFormatter df4 = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static DateTimeFormatter df6 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static DateFormat df5 = new SimpleDateFormat("yyyy-MM-dd");
    public static DateTimeFormatter df7 = DateTimeFormatter.ofPattern("yyyy-MM");
    public static DateTimeFormatter df8 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static String startTime = " 00:00:00";
    public static String endTime = " 23:59:59";
    public static String DATE_PATTERN = "yyyy-MM-dd";
    public static String DATE_PATTERN_YM = "yyyy-MM";

    public DateUtil() {
    }

    public static Long getUnixTimestamp() {
        return getLongByTime(LocalDateTime.now()) / 1000L;
    }

    public static long getLongByTime(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli();
    }

    public static long getSecondLongByTime(LocalDateTime localDateTime) {
        return getLongByTime(localDateTime) / 1000L;
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getDaysAgo(Date time, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.add(5, amount);
        return c.getTime();
    }

    public static LocalDateTime getTimestampOfDateTime(Long time) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
    }

    public static LocalDateTime timeTolocalTime(Long time) {
        return time > 16033721190L ? getTimestampOfDateTime(time) : LocalDateTime.ofEpochSecond(time, 0, ZoneOffset.ofHours(8));
    }

    public static LocalDateTime getTimeByString(String time) {
        return LocalDateTime.parse(time, df);
    }

    public static LocalDateTime getTimeByStringDf6(String time) {
        return LocalDateTime.parse(time, df6);
    }

    public static String getStringByTime(LocalDateTime time) {
        return df.format(time);
    }

    public static String getTimeStringNow() {
        return df.format(LocalDateTime.now());
    }

    public static boolean isValidDate(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                format.setLenient(false);
                format.parse(str);
                return true;
            } catch (ParseException var3) {
                return false;
            }
        }
    }

    public static boolean isValidDate(String str, String reg) {
        if (!StringUtils.isEmpty(str) && !StringUtils.isEmpty(reg)) {
            SimpleDateFormat format = new SimpleDateFormat(reg);

            try {
                format.setLenient(false);
                format.parse(str);
                return true;
            } catch (ParseException var4) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static String dateNow() {
        LocalDateTime time = LocalDateTime.now();
        return df4.format(time);
    }

    public static String dateFormatNow() {
        LocalDateTime time = LocalDateTime.now();
        return df2.format(time);
    }

    public static String getDayStart(LocalDateTime dateTime) {
        return getStringByTime(dateTime.with(LocalTime.MIN));
    }

    public static Date getDayStart(Date date) {
        Calendar dateStart = Calendar.getInstance();
        dateStart.setTime(date);
        dateStart.set(11, 0);
        dateStart.set(12, 0);
        dateStart.set(13, 0);
        dateStart.set(14, 0);
        return dateStart.getTime();
    }

    public static String getYesterdayStart() {
        return getDayStart(LocalDateTime.now().plusDays(-1L));
    }

    public static String getLastMonthStart() {
        return getDayStart(LocalDateTime.now().minusMonths(1L).with(TemporalAdjusters.firstDayOfMonth()));
    }

    public static String getLastMonthEnd() {
        return getDayEnd(LocalDateTime.now().minusMonths(1L).with(TemporalAdjusters.lastDayOfMonth()));
    }

    public static String getYesterdayEnd() {
        return getDayEnd(LocalDateTime.now().plusDays(-1L));
    }

    public static String getDayEnd(LocalDateTime dateTime) {
        return getStringByTime(dateTime.with(LocalTime.MAX));
    }

    public static String getFirstDayOfMonth(LocalDateTime dateTime) {
        return getStringByTime(dateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN));
    }

    public static LocalDateTime getFirstDayOfMonth2(LocalDateTime dateTime) {
        return dateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
    }

    public static String getLastDayOfMonth(LocalDateTime dateTime) {
        return getStringByTime(dateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX));
    }

    public static LocalDateTime getLastDayOfMonth2(LocalDateTime dateTime) {
        return dateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
    }

    public static LocalDateTime getFirstDayOfMonthOnLocalDate(LocalDateTime dateTime) {
        return dateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
    }

    public static LocalDateTime getLastDayOfMonthOnLocalDate(LocalDateTime dateTime) {
        return dateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
    }

    public static Long getDay(LocalDateTime startTime, LocalDateTime endTime) {
        return endTime.toLocalDate().toEpochDay() - startTime.toLocalDate().toEpochDay();
    }

    public static List<String> findDates(String dBegin, String dEnd) throws ParseException {
        List<String> lDate = new ArrayList();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        lDate.add(sd.format(sd.parse(dBegin)));
        Calendar calBegin = Calendar.getInstance();
        Date end = sd.parse(dEnd);
        calBegin.setTime(sd.parse(dBegin));
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(end);

        while(end.after(calBegin.getTime())) {
            calBegin.add(5, 1);
            lDate.add(sd.format(calBegin.getTime()));
        }

        return lDate;
    }

    public static List<Integer> getMonths(String startTime, String endTime) {
        List<Integer> months = new CopyOnWriteArrayList();
        int end = Integer.parseInt(endTime);
        int start = Integer.parseInt(startTime);
        if (start == end) {
            months.add(start);
        } else {
            for(int i = start; i <= end; ++i) {
                months.add(i);
            }
        }

        return months;
    }

    public static String[] getBetweenMonth(String date) {
        Integer year = Integer.parseInt(date.split("-")[0]);
        Integer month = Integer.parseInt(date.split("-")[1]);
        LocalDate localDate = LocalDate.of(year, month, 1);
        int maxDay = localDate.lengthOfMonth();
        date = date.split("-")[0] + "-" + String.format("%02d", month);
        return new String[]{date + "-01 00:00:00", date + "-" + String.format("%02d", maxDay) + " 23:59:59"};
    }

    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(6, calendar.get(6) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    public static String getPastDateByFormat(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(6, calendar.get(6) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("MM/d");
        String result = format.format(today);
        return result;
    }

    public static String getStringByTimeOfDate(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    public static String getStringByTimeOfDate2(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static Long getUnixTimestampPlusDaysOnToken(long days) {
        return LocalDateTime.now().plusDays(days).toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static LocalDateTime getLocalDateTimePlusDays(long now, long days) {
        return timeTolocalTime(now + 86400000L * days - 1000L);
    }

    public static Long getMisBetweenTime(LocalDateTime timestr, LocalDateTime timeEnd) {
        Duration duration = Duration.between(timestr, timeEnd);
        return duration.toMillis();
    }

    public static Long getMinutesBetweenTime(LocalDateTime timestr, LocalDateTime timeEnd) {
        Duration duration = Duration.between(timestr, timeEnd);
        return duration.toMinutes();
    }

    public static String getStringByLocalDate(LocalDate date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DATE_PATTERN);
        return date.format(fmt);
    }

    public static String getStringYMByLocalDate(LocalDate date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DATE_PATTERN_YM);
        return date.format(fmt);
    }

    public static void main(String[] args) {
        LocalDateTime localDateTimePlusDays = getLocalDateTimePlusDays(1614477600000L, 2L);
        String stringByTime = getStringByTime(localDateTimePlusDays);
        System.out.println(stringByTime);
    }

    public static String[] getLastMonth(String yearAndMonth, int reduce) {
        String[] timeStr = null;

        try {
            Date currentDate = (new SimpleDateFormat("yyyy-M")).parse(yearAndMonth);
            String currentStr = (new SimpleDateFormat("yyyy-MM-dd")).format(currentDate) + " 00:00:00";
            LocalDateTime billTime = getTimeByString(currentStr);
            int todayMonthValue = billTime.getMonthValue();
            int monthAgo = todayMonthValue - reduce;
            int todayYearValue = billTime.getYear();
            if (monthAgo <= 0) {
                --todayYearValue;
                monthAgo += 12;
            }

            String customDate = todayYearValue + "-" + monthAgo;
            Date newDate = (new SimpleDateFormat("yyyy-M")).parse(customDate);
            String newDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(newDate) + " 00:00:00";
            timeStr = getBetweenMonth(newDateStr);
        } catch (ParseException var12) {
            var12.printStackTrace();
        }

        return timeStr;
    }

    public static String getDistanceTimes(Long startTime, Long endTime) {
        long day = 0L;
        long hour = 0L;
        long minute = 0L;
        long second = 0L;

        try {
            long time1 = startTime;
            long time2 = endTime;
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }

            day = diff / 86400000L;
            hour = diff / 3600000L - day * 24L;
            minute = diff / 60000L - day * 24L * 60L - hour * 60L;
            second = diff / 1000L - day * 24L * 60L * 60L - hour * 60L * 60L - minute * 60L;
        } catch (Exception var16) {
            var16.printStackTrace();
        }

        String dayStr = "";
        if (String.valueOf(day).length() < 2) {
            dayStr = "0" + day;
        } else {
            dayStr = "" + day;
        }

        String hourStr = "";
        if (String.valueOf(hour).length() < 2) {
            hourStr = "0" + hour;
        } else {
            hourStr = "" + hour;
        }

        String minuteStr = "";
        if (String.valueOf(minute).length() < 2) {
            minuteStr = "0" + minute;
        } else {
            minuteStr = "" + minute;
        }

        String secondStr = "";
        if (String.valueOf(second).length() < 2) {
            secondStr = "0" + second;
        } else {
            secondStr = "" + second;
        }

        String time = dayStr + ":" + hourStr + ":" + minuteStr + ":" + secondStr;
        long[] var10000 = new long[]{day, hour, minute, second};
        return time;
    }

    public static List<String> getBetweenDateList(String startDate, String endDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        LinkedList dateList = new LinkedList();

        Date startTime;
        Date endTime;
        try {
            startTime = df.parse(startDate);
            endTime = df.parse(endDate);
        } catch (ParseException var7) {
            var7.printStackTrace();
            return dateList;
        }

        while(true) {
            int compareTo = startTime.compareTo(endTime);
            if (compareTo > 0) {
                return dateList;
            }

            dateList.add(d2s(startTime, "yyyy-MM-dd"));
            startTime.setTime(startTime.getTime() + 86400000L);
        }
    }

    public static String d2s(Date d, String mask) {
        SimpleDateFormat sdf = new SimpleDateFormat(mask);
        return sdf.format(d);
    }

    public static Date getTimesWeekmorning() {
        Calendar cal = Calendar.getInstance();
        if (cal.get(7) == 1) {
            System.out.println("今天是周日");
            cal.add(5, -1);
        }

        cal.set(cal.get(1), cal.get(2), cal.get(5), 0, 0, 0);
        cal.set(7, 2);
        return cal.getTime();
    }

    public static String getMonthAndDayTime(LocalDateTime localDateTime) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(localDateTime.getMonthValue()).append("月").append(localDateTime.getDayOfMonth()).append("日");
        return stringBuilder.toString();
    }

    public static String getMonthDay(Date date, int n) {
        date = date == null ? new Date() : date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, n);
        return df5.format(calendar.getTime());
    }

    public static String getYearDay(Date date, int n) {
        date = date == null ? new Date() : date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(1, n);
        return df5.format(calendar.getTime());
    }

    public static Date string2Date(String date) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.parse(date);
    }
}
