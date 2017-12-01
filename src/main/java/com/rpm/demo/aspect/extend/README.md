AOP
扩展学习。学习java 的动态代理机制


动态代理的两个关键类和接口：

代理类要实现InvocationHandler 接口；
InvocationHandler handler = new DynamicProxy("被代理接口的实现");
 /*
 * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
 * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
 * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
 * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
 */
 FindJob findJob = (FindJob) Proxy.newProxyInstance(
 handler.getClass().getClassLoader(),
 itFindJob.getClass().getInterfaces()，
 handler);


 CGLIB 创建动态代理

 关键在代理类要实现MethodInterceptor。
 调用处要使用如下方法进行创建
  Enhancer enhancer =new Enhancer();
  enhancer.setSuperclass(CGLIBFindJob.class);
  enhancer.setCallback(new CGLIBInterceptor());
  CGLIBFindJob findJob=(CGLIBFindJob)enhancer.create();


  我们来看spring中的事物添加。就是采用aop的方式进行的。此处使用cglib的方式创建了动态代理
      <aop:config proxy-target-class="true">
          <aop:pointcut id="serviceMethod"
                        expression="execution(* com.rpm.demo.spring.service..*(..))or(execution (* com.rpm.demo.spring.service..*(..)))"/>
          <aop:advisor pointcut-ref="serviceMethod" advice-ref="txAdvice"/>
      </aop:config>
      <tx:advice id="txAdvice" transaction-manager="transactionManager">
          <tx:attributes>
              <tx:method name="add*" propagation="REQUIRED" rollback-for="java.lang.Exception"/>
              <tx:method name="remove*" propagation="REQUIRED" rollback-for="java.lang.Exception"/>
              <tx:method name="delete*" propagation="REQUIRED" rollback-for="java.lang.Exception"/>
              <tx:method name="modify*" propagation="REQUIRED" rollback-for="java.lang.Exception"/>
              <tx:method name="*" propagation="SUPPORTS" read-only="true"/>
          </tx:attributes>
      </tx:advice>