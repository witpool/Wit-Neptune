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
package org.witpool.common.model.bean;

import java.io.Serializable;
import java.util.List;

import org.witpool.common.enums.WitCode;

/** 
 * @ClassName: WitResult 
 * @Description: WitPool Result 
 * @author Dom Wang 
 * @date 2017-11-15 PM 3:46:14 
 * @version 1.0 
 */
public class WitResult<T> implements Serializable
{
    private static final long serialVersionUID = -6313651335351889170L;

    /** Instance */
    private T instance;

    /** Instances */
    private List<T> instances;

    /** Error code */
    private Integer code;

    /** Error message */
    private String msg;

    public WitResult()
    {
        this.setErrCode(WitCode.WIT_OK);
    }

    public WitResult(WitCode code)
    {
        this.setErrCode(code);
    }

    public WitResult(Integer code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public WitResult(T instance)
    {
        this.instance = instance;
    }

    public WitResult(List<T> instances)
    {
        this.instances = instances;
    }

    public T getInstance()
    {
        return instance;
    }

    public void setInstance(T instance)
    {
        this.instance = instance;
    }

    public List<T> getInstances()
    {
        return instances;
    }

    public void setInstances(List<T> instances)
    {
        this.instances = instances;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMessage(String msg)
    {
        this.msg = msg;
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public void setErrCode(WitCode code)
    {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("WitResult [instance=");
        builder.append(instance);
        builder.append(", instances=");
        builder.append(instances);
        builder.append(", code=");
        builder.append(code);
        builder.append(", msg=");
        builder.append(msg);
        builder.append("]");
        return builder.toString();
    }

}
