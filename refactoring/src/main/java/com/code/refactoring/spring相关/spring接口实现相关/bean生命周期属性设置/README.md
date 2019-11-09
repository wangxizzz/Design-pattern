

**Spring Bean生命周期初始化顺序：https://www.cnblogs.com/piepie/p/9061076.html**

步骤如下：
步骤1、 豆子工厂（BeanFactory）从xml文件、java配置或注解配置中读取“各种豆子的生产方法说明（BeanDefinition）”。

步骤2、 这些豆子分为“特殊豆子（实现spring指定的某些接口BeanFactoryPostProcessor）”和“普通豆子”，  豆子工厂先生产出这些特殊豆子。

步骤3和4、 特殊豆子调用特定接口（例如BeanFactoryPostProcessor接口），可以对豆子工厂（BeanFactory）进行修改，或添加一些新豆子生产方法（即注册新的BeanDefinition到BeanFactory中）。

步骤5、豆子工厂（BeanFactory）执行getBean方法生产其他的普通裸豆子。（调用类的构造方法，或FactoryBean的getObject方法，以及@Bean注解的方法）

步骤6、设置豆子的依赖关系以及属性值。

步骤7、调用豆子的@PostConstruct指定的方法

步骤8、调用豆子的InitializingBean接口方法

步骤9、调用豆子的initMethod指定的方法。

**总结上述过程， 我们可以得到以下执行顺序 ：  BeanFactoryPostProcessor ---> 普通Bean构造方法 ---> 设置依赖或属性 ---> @PostConstruct ---> InitializingBean ---> initMethod 。**


## 简单比较init-method，afterPropertiesSet和BeanPostProcessor

一、简单介绍

1、init-method方法，初始化bean的时候执行，可以针对某个具体的bean进行配置。init-method需要在applicationContext.xml配置文档中bean的定义里头写明。例如：<bean id="TestBean" class="nju.software.xkxt.util.TestBean" init-method="init"></bean>

这样，当TestBean在初始化的时候会执行TestBean中定义的init方法。

2、afterPropertiesSet方法，初始化bean的时候执行，可以针对某个具体的bean进行配置。afterPropertiesSet 必须实现 InitializingBean接口。实现 InitializingBean接口必须实现afterPropertiesSet方法。

3、BeanPostProcessor，针对所有Spring上下文中所有的bean，可以在配置文档applicationContext.xml中配置一个BeanPostProcessor，然后对所有的bean进行一个初始化之前和之后的代理。BeanPostProcessor接口中有两个方法： postProcessBeforeInitialization和postProcessAfterInitialization。 postProcessBeforeInitialization方法在bean初始化之前执行， postProcessAfterInitialization方法在bean初始化之后执行。

**总之，afterPropertiesSet 和init-method之间的执行顺序是afterPropertiesSet 先执行，init-method 后执行。从BeanPostProcessor的作用，可以看出最先执行的是postProcessBeforeInitialization，然后是afterPropertiesSet，然后是init-method，然后是postProcessAfterInitialization。**
