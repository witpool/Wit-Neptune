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
package org.witpool.persist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.witpool.common.model.po.WitUser;

/**
 * @Class Name : WitRepository
 * @Description: WitPool Repository
 * @Author     : Dom Wang
 * @Email      : witpool@outlook.com 
 * @Date       : 2017-11-15 PM 2:50:27 
 * @Version    : 1.0
 */
public interface WitRepository extends JpaRepository<WitUser, Integer>
{
    public List<WitUser> findByUserName(String userName);
}
