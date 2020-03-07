PropertyPlaceholderConfigurer 内部实现原理，它允许我们在 XML 配置文件中使用占位符并将这些占位符所代表的资源单独配置到简单的 properties 文件中来加载。这个特性非常重要，因为它我们对 Bean 实例属性的配置变得非常容易控制了，主要使用场景有：

1. 动态加载配置文件，多环境切换
2. 属性加解密

## 多环境切换：
我们项目开发过程中，都会存在多个环境，如 dev 、test 、prod 等等，各个环境的配置都会不一样，在传统的开发过程中我们都是在进行打包的时候进行人工干预，或者将配置文件放在系统外部，加载的时候指定加载目录，这种方式容易出错，那么有没有一种比较好的方式来解决这种情况呢？有，利用 PropertyPlaceholderConfigurer 的特性来动态加载配置文件，实现多环境切换。

首先我们定义3个 Properties 文件，如下：  
config/application-dev.properties
config/application-prod.properties
config/application-test.properties

xml配置bean如下：
```xml
<bean id="PropertyPlaceholderConfigurer" class="org.springframework.core.custom.CustomPropertyConfig">
    <property name="locations">
        <list>
            <value>classpath:config/application-dev.properties</value>
            <value>classpath:config/application-test.properties</value>
            <value>classpath:config/application-prod.properties</value>
        </list>
    </property>
</bean>

<bean id="studentService" class="org.springframework.core.service.StudentService">
    <property name="name" value="${student.name}"/>
</bean>
```

在 idea 的 VM options 里面增加 -Dspring.profiles.active=dev，标志当前环境为 dev 环境。测试代码见：
com.code.refactoring.spring相关.propertyPlaceholderConfigurer.PlaceholderMainTest


