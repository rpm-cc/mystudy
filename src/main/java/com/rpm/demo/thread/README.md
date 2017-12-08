扩展学习：java原生线程池


有四种线程池
newCachedThreadPool
newFixedThreadPool
newSingleThreadExecutor
newScheduledThreadPool

在不同的线程对统一个对象进行处理时，如果是需要进行对象的修改工作就一定要注意不能
破坏对象。就需要加入同步锁的机制来处理。但一定要注意死锁的发生。
需要理解的概念
1程序次序规则：一个线程内，按照代码顺序，书写在前面的操作先行发生于书写在后面的操作
2锁定规则：一个unLock操作先行发生于后面对同一个锁额lock操作
3volatile变量规则：对一个变量的写操作先行发生于后面对这个变量的读操作
4传递规则：如果操作A先行发生于操作B，而操作B又先行发生于操作C，则可以得出操作A先行发生于操作C
5线程启动规则：Thread对象的start()方法先行发生于此线程的每个一个动作
6线程中断规则：对线程interrupt()方法的调用先行发生于被中断线程的代码检测到中断事件的发生
7线程终结规则：线程中所有的操作都先行发生于线程的终止检测，我们可以通过Thread.join()方法结束、Thread.isAlive()的返回值手段检测到线程已经终止执行
8对象终结规则：一个对象的初始化完成先行发生于他的finalize()方法的开始
这8条原则摘自《深入理解Java虚拟机》。


多线程学习 锁机制深入学习：



名词：CAS   compareAndSwap  比较和交换
     volatile  对变量进行修饰，是保证变量的可见性，但是不能保证原子性
     atomic    原子行，java.util.concurrent.atomic  对Object，Boolean ，Integer 提供了包装类.
     Callable  可以用来定义带有返回值的线程
     Future    接收带有返回值线程的返回值
     CyclicBarrier  循环阻塞，将线程阻塞在线程中的某一个位置，当指定数量的线程都达到这个位置后所有线程继续执行
     CountDownLatch  倒计数锁存器  可以复用 所有线程执行到某一个位置时，继续执行指定数量的线程，阻塞其他线程.       
                     当指定数量的线程执行完毕后，才继续执行其他线程。
     semaphore  信号量 主要处理的是最大线程数量的问题。当一个处理使用多线程方式进行处理各自的任务时。
                 在同一时间段内允许的最大并发值   
     condition  类似锁，也是一种生产者消费中模型的选择。condition 和lock 可以替代 synchronized 和 Object 的组合
     ReentrantLock  可重入锁
     ReadWriteLock   读锁和写锁；实现读与写，写与写互斥，读与读共享的方式。       
     synchronized 同步，是多线程机制中的基本锁机制。 
     死锁：  A,B两个线程。当运行处在一个相互等待对方释放自己需要的锁的时候就会进入死锁状态。    
     线程安全和线程不安全：线程安全和不安全只存在多线程情景下。
              
              
                   
                   
                   