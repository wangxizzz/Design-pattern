观察者(Observer)相当于事件监听者（监听器），被观察者(Observable)相当于事件源和事件，执行逻辑时通知observer即可触发oberver的update,同时可传被观察者和参数。简化了事件-监听模式的实现。


# Spring中的事件驱动机制  
事件机制一般包括三个部分：EventObject，EventListener和Source。
- EventObject：事件状态对象的基类，它封装了事件源对象以及和事件相关的信息。所有java的事件类都需要继承该类
- EventListener：是一个标记接口，就是说该接口内是没有任何方法的。所有事件监听器都需要实现该接口。事件监听器注册在事件源上，当事件源的属性或状态改变的时候，调用相应监听器内的回调方法（自己写）。
- Source：一个普通的POJO。事件最初发生的地方，他里面必须含有监听它的监听器们

具体使用细节与坑：  
https://cloud.tencent.com/developer/article/1497779