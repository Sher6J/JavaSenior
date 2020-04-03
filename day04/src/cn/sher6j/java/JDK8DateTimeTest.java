package cn.sher6j.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * jdk 8 中日期时间API的测试
 * @author sher6j
 * @create 2020-03-30-下午9:07
 */
public class JDK8DateTimeTest {

    /*
    LocalDate、LocalTime、LocalDateTime的使用
    说明：
        1.LocalDateTime使用频率高
     */
    @Test
    public void test1() {
        //now()：获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of()：设置指定的年、月、日、时、分、秒
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 11, 26, 14, 35, 44);
        System.out.println(localDateTime1);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        System.out.println("---------------------");

        //体现不可变性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);
    }

    /*
    Instant的使用->针对机器：

     */
    @Test
    public void test2() {
        //now()：获取本初子午线对应的标准实现
        Instant instant = Instant.now();
        System.out.println(instant); //本初子午线时间，比咱们晚8个小时

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(instant); //不可变性
        System.out.println(offsetDateTime);

        //获取对应的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

    }

    /*
    DateTimeFormatter：格式化或解析日期、时间
    类似与SimpleDateFormat
     */
    @Test
    public void test3() {
//        方式一：预定义的标准格式。如:ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String s = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(s);
        //解析：字符串->日期
        TemporalAccessor parse = formatter.parse("2020-03-31T10:15:35.916426");
        System.out.println(parse);

        System.out.println("----------");

//        方式二：本地化相关的格式。如:ofLocalizedDateTime(FormatStyle.LONG)

//        重点：方式三：自定义的格式。如:ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String s1 = formatter1.format(LocalDateTime.now());
        System.out.println(s1);
        //解析
        TemporalAccessor parse1 = formatter1.parse("2020-02-14 10:20:35");
        System.out.println(parse1);


    }
}
