
搜索关键字：springboot整合caffine

参数	解释	例子  
value：缓存的名称，在 spring 配置文件中定义，必须指定至少一个。例如:@Cacheable(value=”mycache”)

key：缓存的key，可以为空，如果指定要按照SpEL表达式编写，如不指定，则按照方法所有参数组合。例如：@Cacheable(value=”testcache”,key=”#userName”)

condition：缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存。例如：@Cacheable(value=”testcache”,condition=”#userName.length()>2”)


用法参考：
- https://www.javazhiyin.com/59610.html
- https://blog.csdn.net/qq_35981283/article/details/82429603
