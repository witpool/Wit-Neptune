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
package org.witpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
 * @ClassName: WitApp 
 * @Description: WitPool Application  
 * @author Dom Wang 
 * @date 2017-11-15 AM 11:21:55 
 * @version 1.0 
 */
@SpringBootApplication
public class WitApp
{

    public static void main(String[] args)
    {
        SpringApplication.run(WitApp.class, args);
    }
}
