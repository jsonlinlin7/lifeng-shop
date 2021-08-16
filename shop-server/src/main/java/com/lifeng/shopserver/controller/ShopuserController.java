package com.lifeng.shopserver.controller;




import com.lifeng.shopserver.common.CommonResult;
import com.lifeng.shopserver.dto.LoginDto;
import com.lifeng.shopserver.dto.RegisterDto;
import com.lifeng.shopserver.pojo.entry.Shopuser;
import com.lifeng.shopserver.service.ShopuserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author jsonlinlin7
 */
@RestController
@RequestMapping("/shopuser")
@Slf4j
public class ShopuserController {
    @Autowired
    ShopuserService shopuserService;

    /**
     * 用户注册
     */
    @PostMapping("/register")//@Validated
    public CommonResult register( @RequestBody RegisterDto registerDto){
        String obj = shopuserService.register(registerDto);
        if(obj.equals("注册成功")){
            return CommonResult.success(obj);
        }else{
            return CommonResult.failed(obj);
        }

    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public CommonResult login(@RequestBody LoginDto loginDto){
/*        log.info(loginDto.toString());*/
        String ans = shopuserService.login(loginDto);
        if(ans.equals("用户名密码正确")){
            return CommonResult.success(ans);
        }
        return CommonResult.failed(ans);
    }

}




