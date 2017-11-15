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
package org.witpool.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.witpool.common.enums.WitCode;
import org.witpool.common.model.bean.WitResult;
import org.witpool.common.model.po.WitUser;
import org.witpool.common.util.WitUtil;
import org.witpool.persist.WitRepository;
import org.witpool.service.WitService;

/**
 * @Class Name : WitUserRest
 * @Description: WitPool User Rest
 * @Author     : Dom Wang
 * @Email      : witpool@outlook.com 
 * @Date       : 2017-11-15 PM 2:50:27 
 * @Version    : 1.0
 */
@RestController
@RequestMapping("/users")
public class WitUserRest
{
    private final static Logger log = LoggerFactory.getLogger(WitUserRest.class);

    @Autowired
    private WitRepository reposit;

    @Autowired
    private WitService service;

    /**
    * 
    * @Title: addUser 
    * @Description: Add one user 
    * @param @param user
    * @param @return 
    * @return WitResult<WitUser>
    * @throws
     */
    @PostMapping
    public WitResult<WitUser> addUser(@RequestBody WitUser user)
    {
        return WitUtil.success(reposit.save(user));
    }

    /**
    * 
    * @Title: addUsers 
    * @Description: Add users by specified number
    * @param @param num
    * @param @return 
    * @return WitResult<WitUser>
    * @throws
     */
    @PostMapping(value = "/{number}")
    public WitResult<WitUser> addUsers(@PathVariable("number") Integer num)
    {
        if (num < 0 || num > 10)
        {
            log.error("The number should be [0, 10]");
            return WitUtil.failure(WitCode.WIT_ERR_INVALID_PARAM);
        }
        return WitUtil.success(service.addUsers(num));
    }

    /**
    * 
    * @Title: updateUser 
    * @Description: Update user 
    * @param @param user
    * @param @return 
    * @return WitResult<WitUser>
    * @throws
     */
    @PutMapping
    public WitResult<WitUser> updateUser(@RequestBody WitUser user)
    {
        return WitUtil.success(reposit.save(user));
    }

    /**
    * 
    * @Title: deleteUser 
    * @Description: delete user by ID 
    * @param @param userId
    * @param @return 
    * @return WitResult<WitUser>
    * @throws
     */
    @DeleteMapping(value = "/{userId}")
    public WitResult<WitUser> deleteUser(@PathVariable("userId") Integer userId)
    {
        reposit.delete(userId);
        return WitUtil.success();
    }

    /**
    * 
    * @Title: getUserByID 
    * @Description: Get user by ID 
    * @param @param userId
    * @param @return 
    * @return WitResult<WitUser>
    * @throws
     */
    @GetMapping(value = "/{userId}")
    public WitResult<WitUser> getUserByID(@PathVariable("userId") Integer userId)
    {
        return WitUtil.success(reposit.findOne(userId));
    }

    /**
    * 
    * @Title: getUserByName 
    * @Description: Get user by name 
    * @param @param userName
    * @param @return 
    * @return WitResult<WitUser>
    * @throws
     */
    @GetMapping(value = "/name/{userName}")
    public WitResult<WitUser> getUserByName(@PathVariable("userName") String userName)
    {
        return WitUtil.success(reposit.findByUserName(userName));
    }

    /**
    * 
    * @Title: getUsers 
    * @Description: Get all users 
    * @param @return 
    * @return WitResult<WitUser>
    * @throws
     */
    @GetMapping
    public WitResult<WitUser> getUsers()
    {
        return WitUtil.success(reposit.findAll());
    }

}
