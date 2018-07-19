package com.carton.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static final DateTimeFormatter FORMATTER_DATE_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter FORMATTER_DATE_TIME_SHORT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter FORMATTER_DATE_TIME_SHORT_MILLIS = new DateTimeFormatterBuilder()
            .appendPattern("yyyyMMddHHmmss").appendValue(ChronoField.MILLI_OF_SECOND, 3).toFormatter();
    public static final DateTimeFormatter FORMATTER_DATE = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter FORMATTER_TIME = DateTimeFormatter.ofPattern("HHmmss");
    public static final DateTimeFormatter FORMATTER_DATE_LINE = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private DateUtils() {
    }

    /**
     * 获取当前日期
     *
     * @return 日期字符串
     */
    public static String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(FORMATTER_DATE_TIME);
    }

    public static String getCurrentDate(DateTimeFormatter formatter) {
        return LocalDateTime.now().format(formatter);
    }

    public static String getCurrentDateByFormatterDate() {
        return LocalDateTime.now().format(FORMATTER_DATE);
    }

    public static String getCurrentDateByFormatterTime() {
        return LocalDateTime.now().format(FORMATTER_TIME);
    }

    public static String dateToString(Date date, String formatStr) {
        try {
            return DateTimeFormatter.ofPattern(formatStr).withZone(ZoneId.systemDefault()).format(date.toInstant());
        } catch (Exception e) {
            logger.error("convert data error : {}", e.getMessage(), e);
            return null;
        }
    }

    public static String dateToString(Date date, DateTimeFormatter dateTimeFormatter) {
        return dateTimeFormatter.withZone(ZoneId.systemDefault()).format(date.toInstant());
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past 天数
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);

        return result;
    }

    /**
     * 获取指定毫秒数之前的日期
     *
     * @param timeDiff 毫秒数
     * @return 日期时间字符串
     */
    public static String getDesignatedDate(long timeDiff) {
        return DateTimeFormatter.ISO_LOCAL_DATE.format(Instant.ofEpochMilli(System.currentTimeMillis() - timeDiff));
    }

    /**
     * 获取前几天的日期
     */
    public static String getPrefixDate(String count) {
        return LocalDate.now().minus(Duration.ofDays(Integer.parseInt(count))).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 日期转换成字符串 yyyy-MM-dd
     *
     * @param date 指定date
     * @return 日期字符串
     */
    public static String dateToString(Date date) {
        return DateTimeFormatter.ISO_LOCAL_DATE.withZone(ZoneId.systemDefault()).format(date.toInstant());
    }

    /**
     * 日期时间转换成字符串 yyyy-MM-dd HH:mm:ss
     *
     * @param date 指定date
     * @return 日期字符串
     */
    public static String dateTimeToString(Date date) {
        return FORMATTER_DATE_TIME.withZone(ZoneId.systemDefault()).format(date.toInstant());
    }

    /**
     * 日期转换成字符串
     *
     * @param temporalAccessor, pattern
     * @return 指定日期
     */
    public static String dateToString(TemporalAccessor temporalAccessor, String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(temporalAccessor);
    }

    public static String dateToString(TemporalAccessor temporalAccessor, DateTimeFormatter formatter) {
        return formatter.format(temporalAccessor);
    }

    /**
     * 字符串转换日期
     *
     * @param str 字符串日期
     * @return LocalDate
     */
    public static LocalDate stringToDate(String str) {
        if (str == null || str.trim().length() == 0)
            return null;
        return LocalDate.parse(str);
    }

    /**
     * 字符串转换日期
     *
     * @param dateStr, pattern
     * @return LocalDate
     */
    public static LocalDate stringToLocalDate(String dateStr, String pattern) {
        if (dateStr == null || dateStr.trim().length() == 0)
            return null;
        return stringToLocalDate(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate stringToLocalDate(String dateStr, DateTimeFormatter formatter) {
        if (dateStr == null || dateStr.trim().length() == 0)
            return null;
        return LocalDate.parse(dateStr, formatter);
    }

    /**
     * 字符串转换原始日期时间
     *
     * @param dateStr   日期时间字符串
     * @param formatter 格式
     * @return LocalDateTime
     */
    public static Date stringToDate(String dateStr, DateTimeFormatter formatter) {
        final LocalDateTime dateTime = LocalDateTime.parse(dateStr, formatter);
        return new Date(dateTime.atZone(Clock.systemDefaultZone().getZone()).toInstant().toEpochMilli());
    }

    /**
     * 字符串转换日期时间
     *
     * @param dateStr   日期时间字符串
     * @param formatter 格式
     * @return LocalDateTime
     */
    public static LocalDateTime stringToDateTime(String dateStr, DateTimeFormatter formatter) {
        return LocalDateTime.parse(dateStr, formatter);
    }

    public static int getWeeks(TemporalAccessor temporalAccessor) {
        return temporalAccessor.get(ChronoField.DAY_OF_WEEK);
    }

    /**
     * 获取日期对应的星期
     *
     * @param dt
     * @return
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 检查日期格式为yyyy-MM-dd
     *
     * @param DateStr
     * @return
     */
    public static boolean checkDateStr(String DateStr) {
        String eL = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        Pattern p = Pattern.compile(eL);
        Matcher m = p.matcher(DateStr);
        return m.matches();
    }

    public static boolean checkDateStr(String DateStr, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(DateStr);
        return m.matches();
    }

    /**
     * 从Date转换成LocalDateTime
     *
     * @param date 转化前的Date
     * @return 转化后的LocalDateTime
     */
    public static LocalDateTime UDateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    //获取当前时间到当天23:59:59，剩余的秒数
    public static Long getSecondsToTomorrow() {
        LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        Long seconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), midnight);
        if (seconds != null) {
            return seconds;
        } else {
            return Long.valueOf(0);
        }
    }
}
