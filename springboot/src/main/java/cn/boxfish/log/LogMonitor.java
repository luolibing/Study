package cn.boxfish.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by LuoLiBing on 15/8/24.
 */
@Component
@Aspect
public class LogMonitor {

    private final static String pakeage = "execution(* cn.boxfish..*.*(..))";

    private final String newLine = System.getProperty("line.separator");

    @Pointcut(pakeage)
    public void anyMethod() {}

    @Around(value = "anyMethod()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        Object object = joinPoint.proceed();
        long span = System.currentTimeMillis() - start;
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        if (logger.isDebugEnabled()) {
            logger.debug(newLine +
                            "-------" + newLine +
                            "调用模块:" + joinPoint.getTarget() + newLine +
                            "被调模块:" + joinPoint.getSignature().toString() + newLine +
                            "输入数据:" + ((null != args) ? Arrays.toString(args) : "null") + newLine +
                            "输出数据:" + ((null != object) ? object.toString() : "null") + newLine +
                            "执行耗时:" + span + " ms"
            );
        } else if (logger.isInfoEnabled()) {
            logger.info(newLine +
                            "-------" + newLine +
                            "调用模块:" + joinPoint.getTarget() + newLine +
                            "被调模块:" + joinPoint.getSignature().toString() + newLine +
                            "执行耗时:" + span + " ms"
            );
        }
        return joinPoint.proceed();
    }

    @AfterThrowing(value = "anyMethod()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {

    }
}
