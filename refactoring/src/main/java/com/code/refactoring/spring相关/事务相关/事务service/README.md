1、@Transactional 注解应该只被应用到 public 方法上，这是由 Spring AOP 的本质决定的。
如果你在 protected、private 或者默认可见性的方法上使用 @Transactional 注解，这将被忽略，也不会抛出任何异常。

2、禁止在事务中进行 rpc、http调用，这样会导致大事务的产生，因为rpc与http会因为各种原因耗时较长。
- 大事务带来的问题：
    - 占用数据库链接长时间不释放，系统吞吐量降低。
    
## 在Spring中，事务有两种实现方式，分别是编程式事务管理和声明式事务管理两种方式。
- 编程式事务管理：编程式事务管理使用TransactionTemplate或者直接使用底层的PlatformTransactionManager。对于编程式事务管理，
spring推荐使用TransactionTemplate。
- 声明式事务管理：建立在AOP之上的。其本质是对方法前后进行拦截，然后在目标方法开始之前创建或者加入一个事务，
在执行完目标方法之后根据执行情况提交或者回滚事务。声明式事务管理不需要入侵代码，通过@Transactional就可以进行事务操作，
更快捷而且简单，推荐使用。

## 事务提交方式
默认情况下，数据库处于自动提交模式。**每一条语句处于一个单独的事务中，在这条语句执行完毕时，如果执行成功则隐式的提交事务，如果执行失败则隐式的回滚事务。**
对于正常的事务管理，是一组相关的操作处于一个事务之中，因此必须关闭数据库的自动提交模式。
不过，这个我们不用担心，spring会将底层连接的自动提交特性设置为false。
也就是在使用spring进行事物管理的时候，spring会将是否自动提交设置为false，
等价于JDBC中的 connection.setAutoCommit(false);，在执行完之后在进行提交，connection.commit(); 。

### 更多详细参考：https://mp.weixin.qq.com/s/VzRv_c-XlirUEmP7Y7pO5Q

## 多重事务嵌套案例：
### 前言
最近在项目中发现了一则报错：
“org.springframework.transaction.UnexpectedRollbackException: Transaction rolled back because it has been marked as rollback-only”。根据报错信息来看是spring框架中的事务管理报错：事务回滚了，因为它被标记为回滚状态。

### 报错原因
多层嵌套事务中，如果使用了默认的事务传播方式，当内层事务抛出异常，外层事务捕捉并正常执行完毕时，就会报出rollback-only异常。
 spring框架是使用AOP的方式来管理事务，如果一个被事务管理的方法正常执行完毕，方法结束时spring会将方法中的sql进行提交。
 如果方法执行过程中出现异常，则回滚。spring框架的默认事务传播方式是PROPAGATION_REQUIRED：如果当前没有事务，就新建一个事务，
 如果已经存在一个事务中，加入到这个事务中。
 在项目中，一般我们都会使用默认的传播方式，这样无论外层事务和内层事务任何一个出现异常，
 那么所有的sql都不会执行。在嵌套事务场景中，内层事务的sql和外层事务的sql会在外层事务结束时进行提交或回滚。
 如果内层事务抛出异常e，在内层事务结束时，spring会把事务标记为“rollback-only”。这时如果外层事务捕捉了异常e，
 那么外层事务方法还会继续执行代码，直到外层事务也结束时，spring发现事务已经被标记为“rollback-only”，
 但方法却正常执行完毕了，这时spring就会抛出“org.springframework.transaction.UnexpectedRollbackException: Transaction rolled back because it has been marked as rollback-only”
 
 代码示例如下：
```java
Class ServiceA {
    @Resource(name = "serviceB")
    private ServiceB b;
    
    @Transactional
    public void a() {
        try {
            b.b()
        } catch (Exception ignore) {
        }
    }
}

Class ServiceB {
    @Transactional
    public void b() {
        throw new RuntimeException();
    }
}
``` 

当调用a()时，就会报出“rollback-only”异常。

### 解决方案
- 如果希望内层事务抛出异常时中断程序执行，直接在外层事务的catch代码块中抛出e.
- 如果希望程序正常执行完毕，并且希望外层事务结束时全部提交，需要在内层事务中做异常捕获处理。
- 如果希望内层事务回滚，但不影响外层事务提交，需要将内层事务的传播方式指定为PROPAGATION_NESTED。注：PROPAGATION_NESTED基于数据库savepoint实现的嵌套事务，外层事务的提交和回滚能够控制嵌内层事务，而内层事务报错时，可以返回原始savepoint，外层事务可以继续提交。

附：事务传播方式
 @see org.springframework.transaction.annotation.Propagation
 
事务传播方式

1、PROPAGATION_REQUIRED

如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是默认的传播方式

2、PROPAGATION_SUPPORTS

支持当前事务，如果当前没有事务，就以非事务方式执行

3、PROPAGATION_MANDATORY

使用当前的事务，如果当前没有事务，就抛出异常

4、PROPAGATION_REQUIRES_NEW

新建事务，如果当前存在事务，把当前事务挂起

5、PROPAGATION_NOT_SUPPORTED

以非事务方式执行操作，如果当前存在事务，就把当前事务挂起

6、PROPAGATION_NEVER

以非事务方式执行，如果当前存在事务，则抛出异常

7、PROPAGATION_SUPPORTS

支持当前事务，如果当前没有事务，就以非事务方式执行。

8、PROPAGATION_NESTED

如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。