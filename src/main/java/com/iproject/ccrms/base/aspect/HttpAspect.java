package com.iproject.ccrms.base.aspect;

import com.iproject.ccrms.base.constant.BaseConstant;
import com.iproject.ccrms.base.enums.ResultEnum;
import com.iproject.ccrms.base.utils.ResultUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * AOP 用于记录请求信息，登录信息验证
 * Created by ligaoyu
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut("execution(public * com.iproject.ccrms.*.controller.*.*(..))")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        String method = proceedingJoinPoint.getSignature().getName();

        //类方法
        logger.info("class_method={}", proceedingJoinPoint.getSignature().getDeclaringTypeName() + "." + method);

        //参数
        logger.info("args={}", proceedingJoinPoint.getArgs());

        if("login".equals(method)){
            return proceed(proceedingJoinPoint);
        }

        String user_account = (String) request.getSession().getAttribute(BaseConstant.USER_ACCOUNT);

        if(user_account == null || "".equals(user_account.trim())){
            return ResultUtil.error(ResultEnum.Unauthorized);
        }else{
            return proceed(proceedingJoinPoint);
        }
    }

    private Object proceed(ProceedingJoinPoint proceedingJoinPoint){
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            return ResultUtil.error(ResultEnum.InternalServerError);
        }
    }

    @After("pointCut()")
    public void doAfter() {

    }

    @AfterReturning(returning = "object", pointcut = "pointCut()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }

}
