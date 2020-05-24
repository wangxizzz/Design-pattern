## 配置相关解释:

注意，spring.task.execution.shutdown 配置项，是为了实现 Spring Task 异步任务的优雅关闭。我们想象一下，如果异步任务在执行的过程中，如果应用开始关闭，把异步任务需要使用到的 Spring Bean 进行销毁，例如说数据库连接池，那么此时异步任务还在执行中，一旦需要访问数据库，可能会导致报错。

所以，通过配置 await-termination = true ，实现应用关闭时，等待异步任务执行完成。这样，应用在关闭的时，Spring 会优先等待 ThreadPoolTaskScheduler 执行完任务之后，再开始 Spring Bean 的销毁。

同时，又考虑到我们不可能无限等待异步任务全部执行结束，因此可以配置 await-termination-period = 60 ，等待任务完成的最大时长，单位为秒。具体设置多少的等待时长，可以根据自己应用的需要。

## 配置多线程池及异步处理器：
https://mp.weixin.qq.com/s/y_gbXHzmN4mJm6UJHhAHjw