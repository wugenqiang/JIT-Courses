/**
 * 
 */
package com.clps.oas.log.service;

import org.springframework.transaction.annotation.Transactional;

import com.clps.oas.log.pojo.Log;

/**
 * @author LHBSY 
 *
 * 下午3:43:24
 */
public interface LogService {  
    
    /** 
     * 日志记录 
     * @param log 
     */  
    @Transactional  
    public void log(Log log);  
      
    /** 
     * 获取登录管理员ID 
     */  
    public Long loginUserId();  
}  