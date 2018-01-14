java 常用对象的学习：
Integer.MAX_VALUE=0x7fffffff;    2147483647
IntegerMIN_VALUE = 0x80000000;  -2147483648
集合类：
1List
ArrayList  默认容量：DEFAULT_CAPACITY = 10；
           数组最大值：MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
           最大容量：Integer.MAX_VALUE :
           扩容机制：oldCapacity + (oldCapacity >> 1)，即原集合长度的1.5倍。
LinkedList 批量数组单元：BATCH_UNIT = 1 << 10; 1024
           最大数组单元：MAX_BATCH = 1 << 25;   33554432   
HasHMap    默认容量：DEFAULT_INITIAL_CAPACITY = 1 << 4； 16
           最大容量：MAXIMUM_CAPACITY = 1 << 30;
           扩容因子：DEFAULT_LOAD_FACTOR = 0.75f;
           特例：当原始table容量达到临街点时会扩容两倍 临界点：12 24 45 97  
HashSet    与HashMap一致。
           
LinkedBlockingQueue 默认Integer.MAX_VALE

StringBuilder StringBuffer  
默认容量16：
扩容：value 现在的字符串长度：str.length:要添加的字符串长度：
 如果 vaule+str.length<value*2+2；value=value*2+2;
     value+str.length>value*2+2 value=value+str.length;
      
 抽象类使用new 的时候会成为一个(匿名)内部类的方式进行对象的创建
 
 serialVersionUID 版本控制 ；
      

           