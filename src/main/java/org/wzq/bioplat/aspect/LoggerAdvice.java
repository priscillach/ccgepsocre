package org.wzq.bioplat.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class LoggerAdvice {

    @Pointcut("execution(public * org.wzq.bioplat.controller..*.*(..))")
    public void logAspect() {
    }

    @Before("logAspect()")
    public void addBeforeLogger(JoinPoint joinPoint) {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String url = request.getRequestURL().toString();
            String requestMethod = request.getMethod();
            String uri = request.getRequestURI();
            String userAgent = request.getHeader("User-Agent");
            Map<String,String[]> params=request.getParameterMap();
            Cookie[] cookies = request.getCookies();
//            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
//            Class targetClass = Class.forName(targetName);

//            log.info("url: {},uri: {}, Request Method: {}, Request Params: {},Cookies: {}," +
//                            "UserAgent: {}, Controller Class: {}, Controller Method: {}, args: {}",
//                    url, uri, requestMethod, params, Arrays.asList(cookies),userAgent, targetClass.getName(), methodName,
//                    Arrays.asList(arguments));
            log.info("url: {} ,uri: {} , Request Method: {} , Request Params: {} ," +
                            "UserAgent: {} , Controller Method: {} , args: {}",
                    url, uri, requestMethod, params, userAgent, methodName,
                    Arrays.asList(arguments));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @AfterReturning(value = "aspect()", returning = "returnObj")
//    public void addAfterReturningLogger(JoinPoint joinPoint, Object returnObj) {
//        System.out.println("结束");
//    }

    @AfterThrowing(pointcut = "logAspect()", throwing = "exception")
    public void addAfterThrowingLogger(JoinPoint joinPoint, Exception exception) {
        log.error(exception.getMessage());
    }

    @Around(value = "logAspect()")
    public Object doAround(ProceedingJoinPoint proceeding) throws Throwable {
        long beforeTime=System.currentTimeMillis();
        Object result = proceeding.proceed();
        if (log.isDebugEnabled()) {
            long afterTime=System.currentTimeMillis();
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String url = request.getRequestURL().toString();
            log.debug("url：{} , time cost：{}ms",url,afterTime-beforeTime);
        }
        long afterTime=System.currentTimeMillis();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String url = request.getRequestURL().toString();
        log.info("url：{} , time cost：{}ms",url,afterTime-beforeTime);
        return result;
    }
}
