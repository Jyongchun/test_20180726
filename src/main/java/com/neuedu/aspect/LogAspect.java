package com.neuedu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.neuedu.service.impl.ProductServiceImplSql.addProduct(..))")
    public void text(){

    }

   /* @Before(value = "text(flower)")
   public void start(String flower){
        System.out.println("方法开始执行  flower:"+flower );
    }
    @AfterReturning(value = "text(flower)",returning = "product")
    public void after_returning(String flower, Product product){
        System.out.println("====after_returning====");
        System.out.println("product="+product);
    }

    @AfterThrowing(value = "text(flower)",throwing = "ex")
    public void throwing(String flower,Throwable ex){
        System.out.println("方法抛出异常  ex="+ex.getMessage());
    }
    @After("text(flower)")
    public void finish(String flower){
        System.out.println("方法执行完成");
    }
*/


   // 环绕通知
    @Around("text()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){

        try {
            //获取原对象
            System.out.println(proceedingJoinPoint.getTarget());
            //获取参数
            System.out.println( proceedingJoinPoint.getArgs()[0]);
           //获取原对象方法名
            System.out.println(proceedingJoinPoint.getSignature().getName());
            //

            System.out.println("方法开始执行");
            //执行原对象方法
            Object o = proceedingJoinPoint.proceed();
            System.out.println("返回值"+o);
            return o;
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
            throwable.printStackTrace();
        }

        System.out.println("方法执行完成");
       return null;
    }


}
