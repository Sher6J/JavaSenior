package cn.sher6j.java1;

/**
 * 注解的使用
 *
 * 1.理解Annotation：
 * ①JDK 5.0 新增
 * ②特殊标记
 * ③JavaEE
 *
 * 2.使用实例：
 * ①文档注释
 * ②在编译时进行格式检查（JDK内置的三个基本注解）
 *     @Override
 *     @Deprecated
 *     @SuppressWarnings
 * ③跟踪代码依赖性，替代配置文件
 *
 * 3.如何自定义注解：参照@SuppressWarnings定义即可
 *     ①注解声明为：@interface
 *     ②内部定义成员，通常使用value表示
 *     ③可以指定成员的默认值，使用default定义
 *     ④如果自定义注解没有成员，表明是一个标识作用
 *
 *     如果注解有成员，使用注解时要指定成员的值
 * 4.四种元注解：对现有注解进行解释说明的注解
 * Retention
 * Target
 * Documented
 * Inherited
 *
 * @author sher6j
 * @create 2020-03-31-下午5:32
 */
public class AnnotationTest {
}
