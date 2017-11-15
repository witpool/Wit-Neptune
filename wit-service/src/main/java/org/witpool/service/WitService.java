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
package org.witpool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.witpool.common.model.po.WitUser;
import org.witpool.persist.WitRepository;

/**
 * @Class Name : WitService
 * @Description: WitPool service
 * @Author     : Dom Wang
 * @Email      : witpool@outlook.com 
 * @Date       : 2017-11-15 PM 2:50:27 
 * @Version    : 1.0
 */
@Service
public class WitService
{
    @Autowired
    private WitRepository reposit;
    
    @Transactional
    public List<WitUser> addUsers(int num)
    {
        List<WitUser> users = new ArrayList<WitUser>();
        for (int i = 0; i < num; i++)
        {
            WitUser usr = new WitUser();
            usr.setUserName("wituser" + i);
            usr.setPassword("user@12" + i);
            usr.setEmail("wituser" + i + "@witpool.org");
            usr.setCellPhone("123456789" + i);
            users.add(reposit.save(usr));
        }
        return users;
    }
}
