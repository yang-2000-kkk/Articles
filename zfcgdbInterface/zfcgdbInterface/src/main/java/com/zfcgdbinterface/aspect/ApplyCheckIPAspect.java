package com.zfcgdbinterface.aspect;

import com.zfcgdbinterface.cache.LoadingLocalCache;
import com.zfcgdbinterface.constant.ApplySubmit;
import com.zfcgdbinterface.response.ApiResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 提交ip重复检查aop
 *
 * @author zht
 * @date 2019/7/27 10:25
 **/
@Component
@Aspect
public class ApplyCheckIPAspect {

    /**
     * 切点
     */
    @Pointcut("@annotation(com.zfcgdbinterface.annotation.ApplyCheckIP)")
    public void methodCachePointcut() {
    }

    /**
     * Before 只能处理 请求参数
     * Around 可以处理请求参数和返回值
     * 在请求时做 IP 检查操作
     */
    @Around("methodCachePointcut()")
    public Object checkIp(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
        // 获取HttpServletRequest 里面 IP
        String ip = getIp(request);
        // 不通过 那么返回错误信息
        if (!isIPPass(ip)) {
            // 这里返回值 ，相当于 response
            return ApiResponse.ofError(ApiResponse.Status.APPLY_IP_NOT_PASS);
        } else {// 通过 那么直接调用接口

            // 通过， 则添加到cache里
            LoadingLocalCache.put(ip, System.currentTimeMillis());

            // 调用请求接口 并 返回数据
            Object object = point.proceed();

            // 这里返回值 ，相当于 response
            return object;
        }
    }

    /**
     * ip 是否可以通过
     */
    private static boolean isIPPass(String ip) {

        // 从缓存获取 IP
        try {
            long time = (long) LoadingLocalCache.get(ip);
            //TODO 每二十秒只能提交一次
            System.out.println(System.currentTimeMillis() - time);
            if (System.currentTimeMillis() - time < ApplySubmit.USER_APPLY_TIME) {
                return false;
            }
        } catch (Exception e) {

            return true;
        }
        return true;
    }

    /**
     * 获取请求ip
     */
    private static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
