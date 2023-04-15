package com.kingdeguo.toolslocal.toolslocal.time

import com.google.common.base.Preconditions
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters
/**
 * 日期工具类
 */
class DateTools extends Date {

    private static final long serialVersionUID = 7528567971034268905L

    /**
     * 是否为全零时间
     */
    private boolean zero = false

    /**
     * 全零时间的字符串形式
     */
    private static final String zeroTime = "0000-00-00 00:00:00"

    /**
     * 全零日期的字符串形式
     */
    private static final String zeroDate = "0000-00-00"

    /**
     * “年年年年-月月-日日”的时间格式
     */
    private static final String datePattern = "yyyy-MM-dd"

    /**
     * 线程安全的日期格式化器
     */
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(datePattern)

    /**
     * “年年年年-月月-日日 时时:分分:秒秒”的时间格式
     */
    private static final String timestampPattern = "yyyy-MM-dd HH:mm:ss"

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(timestampPattern)

    /**
     * 全零日期的HaoDate实例
     */
    public static final DateTools ZERO_INST = new DateTools(true)

    /**
     * jdk的LocalDateTime
     */
    private LocalDateTime localDateTime

    /**
     * jdk的LocalDate
     */
    private LocalDate localDate

    /**
     *  私有构造器，专门用于创建全零实例
     * @param zero  是否全零实例，此处只会传true，为了区别其它构造器而设置了这个参数
     */
    private DateTools(boolean zero) {
        this.zero = zero
    }

    /**
     *  私有构造器，根据LocalDate创建实例
     * @param localDate jdk的LocalDate
     */
    private DateTools(LocalDate localDate) {
        this(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime())
    }

    /**
     *  私有构造器，根据LocalDateTime创建实例
     * @param localDateTime jdk的LocalDateTime
     */
    private DateTools(LocalDateTime localDateTime) {
        this(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()).getTime())
    }

    /**
     *  无参构造器
     */
    DateTools() {
        super()
        this.localDateTime = this.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
        this.localDate = localDateTime.toLocalDate()
    }

    /**
     *  构造器，年月日使用当前的，时分秒根据参数指定
     * @param hour  小时
     * @param minute    分钟
     * @param second    秒
     */
    DateTools(int hour, int minute, int second) {
        this(LocalDateTime.of(LocalDate.now(), LocalTime.of(hour, minute, second)))
    }

    /**
     *  构造器
     * @param date  长整型时间戳
     */
    DateTools(long date) {
        super(date)
        this.localDateTime = this.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
        this.localDate = localDateTime.toLocalDate()
        if (0 == date) {
            this.zero = true
        }
    }

    /**
     *  构造器，年月日时分秒均由参数指定
     * @param year  年
     * @param month 月
     * @param day   日
     * @param hour  时
     * @param minute    分
     * @param second    秒
     */
    DateTools(int year, int month, int day, int hour, int minute, int second) {
        this(Date.from(LocalDateTime.of(year, month, day, hour, minute, second).atZone(ZoneId.systemDefault()).toInstant()).getTime())
    }

    /**
     *  构造器，根据字符串类型的时间初始化
     * @param source  字符串类型的时间，格式为“年年年年-月月-日日 时时:分分:秒秒”或“年年年年-月月-日日”
     */
    DateTools(String source) {
        this(fromString(source).getTime())
        if (isZeroTime(source)) {
            this.zero = true
        }
        //this(new SimpleDateFormat(timestampPattern).parse(datetime).getTime());
    }

    @Override
    long getTime() {
        if (isZeroTime()) {
            return 0
        }
        return super.getTime()
    }

    /**
     *  获得当前的年度
     * @return  当前年度
     */
    int year() {
        assertNotZeroTime()
        return localDateTime.getYear()
    }


    /**
     *  获得当前的月份
     * @return  当前月份
     */
    int month() {
        assertNotZeroTime()
        return localDateTime.getMonthValue()
    }

    /**
     *  获得当前的日期
     * @return  当前日期
     */
    int day() {
        assertNotZeroTime()
        return localDateTime.getDayOfMonth()
    }

    /**
     *  获得当前小时
     * @return  当前小时
     */
    int hour() {
        assertNotZeroTime()
        return localDateTime.getHour()
    }

    /**
     *  获得当前分钟
     * @return  当前分钟
     */
    int minute() {
        assertNotZeroTime()
        return localDateTime.getMinute()
    }

    /**
     *  获得当前秒
     * @return  当前秒
     */
    int second() {
        assertNotZeroTime()
        return localDateTime.getSecond()
    }

    /**
     *  改变当前实例的分钟的秒
     * @param minute    要更改的分钟
     * @param second    要更改的秒
     * @return  当前实例中把分钟和秒替换成给定值之后的新HaoDate实例
     */
    DateTools change(int minute, int second) {
        assertNotZeroTime()
        return new DateTools(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth(),
                localDateTime.getHour(), minute, second)
    }

    /**
     *  改变当前实例的时分钟的秒
     * @param hour    要更改的小时
     * @param minute    要更改的分钟
     * @param second    要更改的秒
     * @return  当前实例中把时分秒替换成给定值之后的新HaoDate实例
     */
    DateTools change(int hour, int minute, int second) {
        assertNotZeroTime()
        return new DateTools(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth(), hour, minute, second)
    }

    /**
     *  判断是否为全零时间
     * @return  是否全零时间
     */
    boolean isZeroTime() {
        return zero
    }

    /**
     *  判断给定的时间字符串是否为全零
     * @param time  要判断的时间字符串
     * @return  给定的时间字符串是否为全零
     */
    static boolean isZeroTime(String time) {
        return zeroTime.equals(time)
    }

    /**
     * 判断给定的时间对象是否为全零
     *
     * @param time 要判断的时间对象
     * @return 给定的时间对象是否为全零
     */
    static boolean isZeroTime(DateTools time) {
        return null != time && time.isZeroTime()
    }

    /**
     *  当前实例转换成“年年年年-月月-日日 时时:分分:秒秒”格式的字符串
     * @return  “年年年年-月月-日日 时时:分分:秒秒”格式的字符串
     */
    String datetimeString(){
        if (this.isZeroTime()) {
            return zeroTime
        }
        return this.localDateTime.format(dateTimeFormatter)
    }

    /**
     *  当前实例转换成“年年年年-月月-日日”格式的字符串
     * @return  “年年年年-月月-日日”格式的字符串
     */
    String dateString(){
        if (this.isZeroTime()) {
            return zeroDate
        }
        return this.localDateTime.format(dateFormatter)
    }

    /**
     *  转自php，用于判断本实例距离当前时间的差值并转换成字符串的类似“N分钟前”的样式
     * @return  60秒内显示“刚刚”；1小时内显示“X分钟前”；当天内显示“今天‘时时：分分’”；昨天显示“昨天‘时时：分分’”；
     * 年度内显示“月月-日日 时时:分分”；不同年度显示“年年年年-月月-日日 时时:分分”
     */
    String parseForRedesign() {
        DateTools now = new DateTools()
        long difference = (now.getTime() - this.getTime()) / 1000
        if (difference < 60) {
            return "刚刚"
        } else if (difference < 60 * 60) {
            return Math.floorDiv(difference, 60) + "分钟前"
        } else if (org.apache.commons.lang3.time.DateUtils.isSameDay(now, this)) {
            return "今天" + new SimpleDateFormat("HH:mm").format(this)
        } else if (org.apache.commons.lang3.time.DateUtils.isSameDay(
                now, org.apache.commons.lang3.time.DateUtils.addDays(this, 1))) {
            return "昨天" + new SimpleDateFormat("HH:mm").format(this)
        } else if (!isSameYear(now, this)) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(this)
        } else {
            return new SimpleDateFormat("MM-dd HH:mm").format(this)
        }
    }

    String parseForRedesignWithDate() {
        DateTools now = new DateTools()
        long difference = (now.getTime() - this.getTime()) / 1000
        if (difference < 60) {
            return "刚刚"
        } else if (difference < 60 * 60) {
            return Math.floorDiv(difference, 60) + "分钟前"
        } else if (org.apache.commons.lang3.time.DateUtils.isSameDay(now, this)) {
            return "今天" + new SimpleDateFormat("HH:mm").format(this)
        } else if (org.apache.commons.lang3.time.DateUtils.isSameDay(
                now, org.apache.commons.lang3.time.DateUtils.addDays(this, 1))) {
            return "昨天" + new SimpleDateFormat("HH:mm").format(this)
        } else if (!isSameYear(now, this)) {
            return new SimpleDateFormat("yyyy-MM-dd").format(this)
        } else {
            return new SimpleDateFormat("MM-dd").format(this)
        }
    }

    String time4UserDefine() {
        DateTools now = new DateTools()
        if (org.apache.commons.lang3.time.DateUtils.isSameDay(now, this)) {
            return "今天"
        } else if (org.apache.commons.lang3.time.DateUtils.isSameDay(
                now, org.apache.commons.lang3.time.DateUtils.addDays(this, 1))) {
            return "昨天"
        } else if (!isSameYear(now, this)) {
            return new SimpleDateFormat("yyyy-MM-dd").format(this)
        } else {
            return new SimpleDateFormat("MM-dd").format(this)
        }
    }

    /**
     * 得到本月的第一天
     * @return	HaoDate，可以调用HaoDate的方法获得想要格式的日期字符串格式
     */
    DateTools firstDayOfMonth() {
        assertNotZeroTime()
        return new DateTools(this.localDate.with(TemporalAdjusters.firstDayOfMonth()))
    }

    /**
     * 得到本月的最后一天
     * @return	HaoDate，可以调用HaoDate的方法获得想要格式的日期字符串格式
     */
    DateTools lastDayOfMonth() {
        assertNotZeroTime()
        return new DateTools(this.localDate.with(TemporalAdjusters.lastDayOfMonth()))
    }

    /**
     * 获得当前日期前（或后）的某一天
     * @param offset    偏移量，即当前日期之前（后）多少天，如果是之前，offset为负的整数
     * @return  返回当前日期前（或后）的某一天
     */
    DateTools offsetDay(int offset) {
        assertNotZeroTime()
        return new DateTools(this.localDateTime.plusDays(offset))
    }

    /**
     * 获得当前日期前（或后）的某一月
     * @param offset    偏移量，即当前日期之前（后）多少月，如果是之前，offset为负的整数
     * @return  返回当前日期前（或后）的某一月
     */
    DateTools offsetMonth(int offset) {
        assertNotZeroTime()
        return new DateTools(this.localDateTime.plusMonths(offset))
    }

    /**
     * 获得当前日期前（或后）的某一年
     * @param offset    偏移量，即当前日期之前（后）多少年，如果是之前，offset为负的整数
     * @return  返回当前日期前（或后）的某一年
     */
    DateTools offsetYear(int offset) {
        assertNotZeroTime()
        return new DateTools(this.localDateTime.plusYears(offset))
    }

    /**
     *  小时偏移，大于0则加，小于0则减
     * @param offset    偏移量
     * @return  增加或减去小时后的新HaoDate实例
     */
    DateTools offsetHours(int offset) {
        assertNotZeroTime()
        return new DateTools(this.localDateTime.plusHours(offset))
    }

    /**
     *  分钟偏移，大于0则加，小于0则减
     * @param offset    偏移量
     * @return  增加或减去分钟后的新HaoDate实例
     */
    DateTools offsetMinutes(int offset) {
        assertNotZeroTime()
        return new DateTools(this.localDateTime.plusMinutes(offset))
    }

    /**
     *  秒偏移，大于0则加，小于0则减
     * @param offset    偏移量
     * @return  增加或减去秒后的新HaoDate实例
     */
    DateTools offsetSeconds(int offset) {
        assertNotZeroTime()
        return new DateTools(this.localDateTime.plusSeconds(offset))
    }

    /**
     * 格式化成给定的格式
     * @param pattern 预期的格式
     * @return	预期格式的字符串
     */
    String format(String pattern) {
        if(this.isZeroTime()){
            return zeroTime
        }
        return new SimpleDateFormat(pattern).format(this)
    }

    /**
     * 获得现在时刻的详细信息，以数组方式顺序返回年、月、日、小时、分钟、秒
     * @return  指定日期的详细信息，以数组方式顺序返回年、月、日、小时、分钟、秒
     */
    int[] dateTimeDetail() {
        assertNotZeroTime()
        int[] detail = new int[6]
        detail[0] = localDateTime.getYear()
        detail[1] = localDateTime.getMonthValue()
        detail[2] = localDateTime.getDayOfMonth()
        detail[3] = localDateTime.getHour()
        detail[4] = localDateTime.getMinute()
        detail[5] = localDateTime.getSecond()
        return detail
    }

    /**
     * 从当前天的前一天算起获得最近dateSpan的结束时间
     * @param offset    偏移量
     * @param span  时间跨度
     * @param direction 方向，负数向历史推算，正数向未来推算
     * @return  从当前天的前一天算起获得最近dateSpan的结束时间
     */
    DateTools offsetDateSpan(int offset, int span, boolean direction) {
        assertNotZeroTime()
        if (offset < 0) {
            throw new RuntimeException("Param offset must be greater than or equal 0, not " + offset)
        }
        if (span <= 0) {
            throw new RuntimeException("Param span must be greater than 0, not " + span)
        }
        int total = direction ? offset + span : (-(offset + span))
        return new DateTools(localDateTime.plusDays(total))
    }

    /**
     *  获得精确到秒的当前时间戳
     * @return  精确到秒的当前时间戳
     */
    static long currentTimeSecond(){
        return System.currentTimeMillis() / 1000
    }

    /**
     *  获得当前实例的精确到秒的时间戳
     * @return  当前实例的精确到秒的时间戳
     */
    long getTimeSecond(){
        return this.getTime() / 1000
    }

    /**
     *  判断两个HaoDate实例是否是同一年
     * @param date1 第一个HaoDate实例
     * @param date2 第二个HaoDate实例
     * @return  在同一年则返回true，否则false
     */
    static boolean isSameYear(final DateTools date1, final DateTools date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null")
        }
        final Calendar cal1 = Calendar.getInstance()
        cal1.setTime(date1)
        final Calendar cal2 = Calendar.getInstance()
        cal2.setTime(date2)
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
    }

    /**
     * 获得当前日期（小时、分钟、秒均为0）
     * @return  当前日期（小时、分钟、秒均为0）
     */
    DateTools onlyDate() {
        assertNotZeroTime()
        return new DateTools(this.year(), this.month(), this.day(), 0, 0, 0)
    }

    /**
     *  根据给定字符串时间转换成HaoDate实例
     * @param source   字符串时间，格式可以是“年年年年-月月-日日 时时:分分:秒秒”或者“年年年年-月月-日日”，其余的格式不支持
     * @return  HaoDate实例
     */
    static DateTools fromString(String source) {
        source = source.trim()
        if (source == null || source.isEmpty()) {
            throw new IllegalArgumentException("HaoDate string type error, source:" + source)
        }

        if (isZeroTime(source)) {
            return DateTools.ZERO_INST
        }
        try {
            if (source.contains("-")) {
                if (source.contains(":")) {
                    return new DateTools(new SimpleDateFormat(timestampPattern).parse(source).getTime())
                } else {
                    String[] values = source.split("-")
                    return new DateTools(LocalDate.of(Integer.valueOf(values[0]), Integer.valueOf(values[1]), Integer.valueOf(values[2])))
                }
            } else if (source.matches("^\\d+\$")) {
                Long lDate = new Long(source)
                return new DateTools(lDate)
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to HaoDate fail", source))
        }
        throw new RuntimeException(String.format("parser %s to HaoDate fail", source))
    }

    /**
     * 判断当前实例时间戳是否非法的Mysql Timestamp范围，即是否在其范围内
     * @return  不在其范围内返回true，否则返回true
     */
    boolean illegalMysqlTimestamp() {
        long current = this.getTime()
        return  current <= -28800000 || current >= 2147483647000L
    }

    /**
     * 通过生日获取当前年龄
     * @param birthday 生日
     * @return 当前年龄
     */
    String birthday2Age(DateTools birthday) {
        assertNotZeroTime()
        Map<String, Integer> map = this.getDateDiff(birthday)
        int year = map.get("year")
        int month = map.get("month")
        int day = map.get("day")
        String age

        if (year >= 10) {
            age = year + "岁"
        } else {
            if (day >= 1) {
                month = month + 1
            }
            if (year >= 1) {
                if (12 == month) {
                    year = year + 1
                    month = 0
                }
                age = year + "岁" + (month > 0 ? month + "个月" : "")
            } else if (0 == year && (month > 1 || (1 == month && 0 == day))) {
                age = (month - 1 == 0 ? month + "个月" : month - 1 + "个月") + (0 == day ? "" : day + "天")
            } else if (0 == year && 1 == month && day >= 1) {
                age = day + "天"
            } else if (0 == year && 0 == month && 0 == day) {
                age = "1天"
            }else {
                age = ""
            }
        }
        return age
    }

    /**
     * 某历史时间与当前日期实例比较时间差
     * 注意：HaoDate1.getDateDiff(HaoDate2)，HaoDate1时间要大于HaoDate2，不然时间差取出来是负数
     * @param haoDate 需要比较的时间
     * @return map = {{"year", *}, {"month", *}, {"day", *}}
     */
    Map<String, Integer> getDateDiff(DateTools haoDate) {
        assertNotZeroTime()
        int year = this.year() - haoDate.year()
        int month = this.month() - haoDate.month()
        int day = this.day() - haoDate.day()

        if (year > 0 && this.month() == 2 && haoDate.month() == 2 && this.day() >= 28 && haoDate.day() >= 28) {
            int currentDays = getDaysOfMonth(haoDate.year(), haoDate.month())
            int nowDays = getDaysOfMonth(this.year(), this.month())
            if (currentDays != nowDays) {
                if (currentDays == 29) {
                    day = 0
                }
            }
        }

        if (day < 0) {
            month = month - 1
            int monthDays = getDaysOfMonth(haoDate.year(), haoDate.month())
            day = this.day() + (monthDays - haoDate.day())
        }

        if (month < 0) {
            year = year - 1
            month = 12 + month
        }
        Map<String, Integer> map = new HashMap<>()
        map.put("year", year)
        map.put("month", month)
        map.put("day", day)
        return map
    }

    /**
     * 获取某一年某一月有多少天
     * @param year 某年
     * @param month 某月
     * @return 多少天
     */
    static int getDaysOfMonth(int year, int month) {
        int[] monthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                return 29
            }
        }
        return monthDays[month - 1]
    }


    /**
     * 本类属于"不可变对象", 通过setTime修改时间会导致内部状态不一致, 因此不再支持原地修改, 请使用 offsetXxx 以及 change 方法生成新的实例.
     *
     * @param time 指定时间戳
     */
    @Deprecated
    @Override
    void setTime(long time) {
        super.setTime(time)
    }


    /**
     * 请使用 {@link #aheadOf(DateTools)} 方法代替此方法, {@link #aheadOf(DateTools)} 会在使用 {@link #ZERO_INST} 比较大小时抛出异常,
     * 而不是返回一个无法预期的结果. <br/>
     * 此方法在 {@link #ZERO_INST} 与其他时间比较时结果不固定, 使用前请先通过 {@link #isZeroTime(DateTools)} 判断参与比较的两个对象是否是zero.
     *
     * @param when Date
     * @return boolean
     */
    @Deprecated
    @Override
    boolean before(Date when) {
        return super.before(when)
    }

    /**
     * 判断当前时间是否领先于参数中的指定时间
     *
     * @param haoDate 指定时间
     * @return boolean
     * @throws IllegalStateException 如果参与比较的时间中有 "zero", 则抛出此异常
     */
    boolean aheadOf(DateTools haoDate) {
        assertNotZeroTime()
        assertNotZeroTime(haoDate)
        return super.before(haoDate)
    }

    /**
     * 请使用 {@link #behindOf(DateTools)} 方法代替此方法, {@link #behindOf(DateTools)} 会在使用 {@link #ZERO_INST} 比较大小时抛出异常,
     * 而不是返回一个无法预期的结果. <br/>
     * 此方法在 {@link #ZERO_INST} 与其他时间比较时结果不固定, 使用前请先通过 {@link #isZeroTime(DateTools)} 判断参与比较的两个对象是否是zero.
     *
     * @param when Date
     * @return boolean
     */
    @Deprecated
    @Override
    boolean after(Date when) {
        return super.after(when)
    }

    /**
     * 判断当前时间是否落后于参数中的指定时间
     *
     * @param haoDate 指定时间
     * @return boolean
     * @throws IllegalStateException 如果参与比较的时间中有 "zero", 则抛出此异常
     */
    boolean behindOf(DateTools haoDate) {
        assertNotZeroTime()
        assertNotZeroTime(haoDate)
        return super.after(haoDate)
    }

    /**
     * 请使用 {@link #compareWith(DateTools)} 方法代替此方法,
     * {@link #compareWith(DateTools)} 会在使用 {@link #ZERO_INST} 比较大小时抛出异常, 而不是返回一个不确定的值. <br/>
     * 此方法在 {@link #ZERO_INST} 与其他时间比较时结果不固定, 使用前请先通过 {@link #isZeroTime(DateTools)} 判断参与比较的两个对象是否是zero.
     *
     * @param anotherDate Date
     * @return boolean
     */
    @Deprecated
    @Override
    int compareTo(Date anotherDate) {
        return super.compareTo(anotherDate)
    }

    /**
     * 用于比较两个时间
     * <ul>
     * <li>如果当前时间领先于指定时间，返回负数</li>
     * <li>如果当前时间落后于指定时间，返回正数</li>
     * <li>如果当前时间等于指定时间，返回0</li>
     * </ul>
     * 参考: {@link java.lang.Comparable#compareTo(Object)} 方法文档.
     *
     * @param haoDate haoDate
     * @return -1 / 1 / 0
     * @throws IllegalStateException 如果参与比较的时间中有 "zero", 则抛出此异常
     */
    int compareWith(DateTools haoDate) {
        assertNotZeroTime()
        assertNotZeroTime(haoDate)
        return super.compareTo(haoDate)
    }

    private void assertNotZeroTime() {
        assertNotZeroTime(this)
    }

    private static void assertNotZeroTime(DateTools haoDate) {
        Preconditions.checkState(haoDate != DateTools.ZERO_INST, "unsupported zero time")
    }

    @Override
    String toString() {
        if (isZeroTime()) {
            return zeroTime
        }
        return super.toString()
    }
}
