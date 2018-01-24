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
package org.witpool.common.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.witpool.common.enums.WitCode;
import org.witpool.common.except.WitException;
import org.witpool.common.model.bean.WitResult;

/** 
 * @class name: WitExceptHandle 
 * @description: WitPool Result 
 * @author Dom Wang 
 * @date 2017-11-15 PM 3:46:14 
 * @version 1.0 
 */
@ControllerAdvice
public class WitExceptHandle
{
    private final static Logger logger = LoggerFactory.getLogger(WitExceptHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public WitResult handle(Exception e)
    {
        if (e instanceof WitException)
        {
            WitException we = (WitException) e;
            return new WitResult(we.getCode(), we.getMessage());
        }
        else
        {
            logger.error(WitCode.WIT_ERR_INNER.getMsg() + "{}", e);
            return new WitResult(WitCode.WIT_ERR_INNER.getCode(), e.getMessage());
        }
    }
}
