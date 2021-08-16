package com.lifeng.shopserver.service;

import com.lifeng.shopserver.dto.LoginDto;
import com.lifeng.shopserver.dto.RegisterDto;
import com.lifeng.shopserver.pojo.entry.Shopuser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author jsonlinlin7
 */
public interface ShopuserService extends IService<Shopuser> {
    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);

}
