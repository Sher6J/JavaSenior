package cn.sher6j.java;

/**
 * 使用enum定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 *
 * @author sher6j
 * @create 2020-03-31-下午4:37
 */

interface Info{
    void show();
}

//使用enum关键字枚举类
enum  Season1 implements Info{
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天来了");
        }
    },
    SUMMER("夏天","夏日炎炎") {
        @Override
        public void show() {
            System.out.println("夏天来了");
        }
    },
    AUTUMN("秋天","秋风飒飒") {
        @Override
        public void show() {
            System.out.println("秋天来了");
        }
    },
    WINTER("冬天","冰天雪地") {
        @Override
        public void show() {
            System.out.println("冬天来了");
        }
    };

    //2.声明Season对象的属性:private final
    private final String seasonName;
    private final String seasonDesc;

    //3.提供当前枚举类的多个对象：默认public static final修饰
    Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求1：获取枚举类的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }

//    //4.其他诉求2：
//
//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;

        System.out.println(summer); //toString()
        System.out.println(summer.toString());
        System.out.println(Season1.class.getSuperclass());

        System.out.println("-----------");

        //values():返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
        Season1[] values = Season1.values();
        for (Season1 s : values) {
            System.out.println(s);
        }
        System.out.println("------------");
        Thread.State[] values1 = Thread.State.values();
        for (Thread.State state : values1) {
            System.out.println(state);
        }

        System.out.println("-------------");

        //valueOf(String objName):可以把一个字符串转为对应的枚举类对象。
        //          要求字符串必须是枚举类对象的“名字”。
        //          如不是,会有运行时异常:IllegalArgumentException。
        Season1 winter = Season1.valueOf("WINTER");
//        Season1 winter1 = Season1.valueOf("WINTER1");//IllegalArgumentException
        System.out.println(winter);
    }
}
