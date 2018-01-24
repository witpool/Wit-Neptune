/* 
 * Copyright 2016-2017 WitPool.org All Rights Reserved.
 * 
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
   
 *  http://www.witpool.org/licenses
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.witpool.common.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/** 
 * @ClassName: WitAspect 
 * @Description: WitPool Http Aspect 
 * @author Dom Wang 
 * @date 2017-11-15 PM 3:36:38 
 * @version 1.0 
 */
@Aspect
@Component
public class WitAspect 
{
    private final static Logger log = LoggerFactory.getLogger(WitAspect.class);

    @Pointcut("execution(public * org.witpool.rest.WitUserRest.*(..))")
    public void log()
    {
    }

    @Before("log()")
    public void doBefore(JoinPoint jp)
    {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attr.getRequest();

        // URL
        log.info("WIT: URL={}", req.getRequestURL());

        // Method
        log.info("WIT: HTTP Method={}", req.getMethod());

        // IP
        log.info("WIT: IP={}", req.getRemoteAddr());

        // 类方法
        log.info("WIT: REST CLASS={}", jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName());

        // 参数
        log.info("WIT: ARGS={}", jp.getArgs());
    }

    @After("log()")
    public void doAfter()
    {
        log.info("WIT: do after");
    }

    @AfterReturning(returning = "obj", pointcut = "log()")
    public void doAfterReturning(Object obj)
    {
        log.info("WIT: RESPONSE={}", obj.toString());
    }
}
