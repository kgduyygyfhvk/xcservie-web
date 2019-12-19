//package xyz.xcservice.www.config;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.ArrayUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.hibernate.validator.internal.engine.ValidatorImpl;
//import org.slf4j.MDC;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletWebRequest;
//import xyz.xcservice.www.dto.base.ResultRequest;
//import xyz.xcservice.www.exception.XcServiceException;
//import xyz.xcservice.www.utils.ResponseUtil;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Arrays;
//import java.util.UUID;
//
///**
// * logback的AOP日志id插入
// *
// * @author wuwenchao
// * @date 2019/10/26
// */
//@Aspect
//@Component
//@Slf4j
//public class LogBackTraceLogIdConfig {
//
//    public static final String traceLogId = "traceLogId";
//
//    public static final String dstTraceId = "dstTraceId";
//
//    @Resource
//    private ValidatorImpl validator;
//
//    /**
//     * 定义切点Pointcut
//     * 第一个*号：表示返回类型， *号表示所有的类型
//     * 第二个*号：表示类名，*号表示所有的类
//     * 第三个*号：表示方法名，*号表示所有的方法
//     * 后面括弧里面表示方法的参数，两个句点表示任何参数
//     */
//    @Pointcut("execution(*  xyz.xcservice.www.controller.*.*(..))")
//    public void executionService() {
//    }
//
//    /**
//     * 方法调用之前调用
//     *
//     * @param joinPoint 切面参数
//     */
//    @Before(value = "executionService()")
//    public void doBefore(JoinPoint joinPoint) {
//        //获取类名
//        String className = joinPoint.getTarget().getClass().getName();
//        //获取方法名
//        String methodName = joinPoint.getSignature().getName();
//        //获取参数数组
//        Object[] objects = joinPoint.getArgs();
//        MDC.put(LogBackTraceLogIdConfig.dstTraceId, UUID.randomUUID().toString());
//        if (!ArrayUtils.isEmpty(objects) && objects[0] instanceof ResultRequest) {
//            ResultRequest resultRequest = (ResultRequest) objects[0];
//            if (StringUtils.isNotBlank(resultRequest.getTraceLogId())) {
//                MDC.put(LogBackTraceLogIdConfig.traceLogId, resultRequest.getTraceLogId());
//            }
//        }
//        log.info("请求路径[{}][{}],请求参数：{}", className, methodName, Arrays.toString(joinPoint.getArgs()));
//    }
//
//    /**
//     * 方法之后调用
//     *
//     * @param returnValue 方法返回值
//     */
//    @AfterReturning(pointcut = "executionService()", returning = "returnValue")
//    public void doAfterReturning(JoinPoint joinPoint, Object returnValue) {
//        //获取类名
//        String className = joinPoint.getTarget().getClass().getName();
//        //获取方法名
//        String methodName = joinPoint.getSignature().getName();
//        //获取参数数组
//        log.info("请求路径[{}][{}],响应参数：{}", className, methodName, returnValue);
//        // 处理完请求，返回内容
//        MDC.clear();
//    }
//
//    @AfterThrowing(pointcut = "executionService()", throwing = "exception")
//    public void AfterThrowing(XcServiceException exception) {
//        HttpServletResponse response = ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
//        String jsonStr = JSONObject.toJSONString(exception.getResultResponse(), SerializerFeature.WriteMapNullValue);
//        ResponseUtil.writer(response, jsonStr);
//    }
//
////    @Around(value = "executionService()")
////    public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
////
////        Object obj = proceedingJoinPoint.proceed();
////        return obj;
////    }
//}
