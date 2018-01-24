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
package org.witpool.common.util;

import java.util.List;

import org.witpool.common.enums.WitCode;
import org.witpool.common.model.bean.WitResult;

/**
 * @Class Name : WitUtil
 * @Description: WitPool utility
 * @Author     : Dom Wang
 * @Email      : witpool@outlook.com 
 * @Date       : 2017-11-15 PM 2:50:27 
 * @Version    : 1.0
 */
public class WitUtil
{
    /**
    * 
    * @Title: success 
    * @Description: Return success and instance
    * @param @param instance
    * @param @return 
    * @return WitResult<T>
    * @throws
     */
    public static <T> WitResult<T> success(T instance)
    {
        WitResult<T> rst = new WitResult<T>(instance);
        rst.setErrCode(WitCode.WIT_OK);
        return rst;
    }
    
    /**
    * 
    * @Title: success 
    * @Description: Return success and instances 
    * @param @param instances
    * @param @return 
    * @return WitResult<T>
    * @throws
     */
    public static <T> WitResult<T> success(List<T> instances)
    {
        WitResult<T> rst = new WitResult<T>(instances);
        rst.setErrCode(WitCode.WIT_OK);
        return rst;
    }
    
    /**
    * 
    * @Title: success 
    * @Description: Return success 
    * @param @return 
    * @return WitResult<T>
    * @throws
     */
    public static <T> WitResult<T> success()
    {
        WitResult<T> rst = new WitResult<T>();
        rst.setErrCode(WitCode.WIT_OK);
        return rst;
    }
    
    /**
    * 
    * @Title: failure 
    * @Description: Return failure 
    * @param @param code
    * @param @return 
    * @return WitResult<T>
    * @throws
     */
    public static <T> WitResult<T> failure(WitCode code)
    {
        WitResult<T> rst = new WitResult<T>();
        rst.setErrCode(code);
        return rst;
    }
}
