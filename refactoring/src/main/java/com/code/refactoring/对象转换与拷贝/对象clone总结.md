1. 实现对象的深拷贝只有2种办法：  
- 实现clone()方法，并且依次clone对象属性中为Object的属性。
- 序列化与反序列化

2.工具实现clone:
- deep clone :
    - apache的SerializationUtils可以实现deep clone
- Spring和Apache的BeanUtils都是属于浅拷贝，BeanCopier也是浅拷贝，但是拷贝性能比前两者高。