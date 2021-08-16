package com.lifeng.shopserver.service.impl;

import com.lifeng.shopserver.dto.LoginDto;
import com.lifeng.shopserver.dto.RegisterDto;
import com.lifeng.shopserver.pojo.entry.Shopuser;
import com.lifeng.shopserver.mapper.ShopuserMapper;
import com.lifeng.shopserver.service.ShopuserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lifeng.shopserver.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jsonlinlin7
 */
@Service
public class ShopuserServiceImpl extends ServiceImpl<ShopuserMapper, Shopuser> implements ShopuserService {
    @Autowired
    ShopuserMapper shopuserMapper;

    @Override
    public String register(RegisterDto ro) {
        String ans = istrue(ro);
        if(ans.equals("OK")){
            Shopuser shopuser = new Shopuser();
            shopuser.setUsername(ro.getUsername());shopuser.setPhone(ro.getPhone());shopuser.setPassword(MD5Utils.code(ro.getPassword()));
            shopuserMapper.insert(shopuser);
            return "注册成功";
        }
        return ans;
    }

    @Override
    public String login(LoginDto loginDto) {

        String pd = shopuserMapper.selectPdByUsername(loginDto.getUsername());
        if(pd==null){
            return "用户名错误";
        }else if(pd.equals(MD5Utils.code(loginDto.getPassword()))){
            return "用户名密码正确";
        }
        return "密码错误";
    }

    public String istrue(RegisterDto ro){
        if(ro.getPhone()==null||ro.getPhone()==""){
            return "手机号码不能为空";
        }
        if(ro.getUsername()==null||ro.getUsername()==""){
            return "账号不能为空";
        }
        if(shopuserMapper.selectByUsername(ro.getUsername())!=null){
            return "该账号已经存在";
        }
        if(ro.getPassword()==null||ro.getPassword()==""){
            return "密码不能为空";
        }
        if(ro.getPassword().length()>16||ro.getPassword().length()<4){
            return "密码长度只能在4~16位";
        }
        return "OK";
    }
}
