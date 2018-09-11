package com.firstmeetschool.school.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.firstmeetschool.school.entity.Result;
import com.firstmeetschool.school.mapper.OpenIdMapper;
import com.firstmeetschool.school.shiro.MyRealm;
import com.firstmeetschool.school.utils.ResultUtils;
import com.github.kevinsawicki.http.HttpRequest;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;


@Service
public class LoginService {


    @Autowired(required = false)
    private OpenIdMapper openIdMapper;


    @Autowired(required = false)
    private SelectService selectService;

    public Result logincode(String code ){

        Map<String,Object> hashMap = new HashMap<String, Object>();

        String url ="https://api.weixin.qq.com/sns/jscode2session";
        String appid = "wx8a48e7acde322db1";
        String secret = "d1e571bb902ce5552ef9d499f01a94dd";
        String js_code = code;
        String grant_type = "authorization_code";

        HttpRequest request = HttpRequest.get(url, true, "appid",appid, "secret",secret,"js_code",js_code, "grant_type", grant_type);
        request.trustAllCerts();
        request.trustAllHosts();
        System.out.println(request.toString());

        Map map = JSON.parseObject(request.body());//  json转map
       /* for(Object ma:map.keySet()){
            System.out.println(ma);
        }*/


        if(map.get("openid")==null) {

            return ResultUtils.error(201, map);

        }
        String openid = (String)map.get("openid");

        /*System.out.println(map);*/

        System.out.println("openid:"+openid);

        /**
         * openid-数据库
         * 1.查询数据库有没有此openid
         * 2.有的话,就做token认证
         * 3.没有的话，状态码为1，表示用户授权，将openid存入数据库，并做token认证，
         *   状态码为0，表示用户未授权，不做token认证。
         */
        /*
           提交git测试
         */
      /*  System.out.println(openIdMapper.find(openid));
        System.out.println(state==0);*/
        if(openIdMapper.find(openid)==null){
            int result = openIdMapper.insert(openid,0);



            hashMap.put("object","unregister");
            hashMap.put("openid",openid);
            hashMap.put("usrId"," ");
            return ResultUtils.success(200,hashMap);

        }else if(openIdMapper.find(openid).getCheckReg()==0){


            hashMap.put("object","unregister");
            hashMap.put("openid",openid);
            hashMap.put("usrId"," ");
            return ResultUtils.success(200,hashMap);
        }

        //自定义realm
        MyRealm myRealm= new MyRealm();

        //1.构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(myRealm);

        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        System.out.println("sessionId:"+session.getId());


        UsernamePasswordToken token = new UsernamePasswordToken(openid,"123456");//用户名密码都为openid
        try {
            subject.login(token);
        }catch (AuthenticationException e){
            return ResultUtils.error(202,e.getMessage());
        }

        System.out.println("是否认证:"+subject.isAuthenticated());

        String id = selectService.getUserByopenid(openid).getUsrId();
        hashMap.put("object","register");
        hashMap.put("openid",openid);
        hashMap.put("usrId",id);


        /*if(subject.hasRole("user")){
            return "有admin权限";
        }*/
        return ResultUtils.success(200,hashMap);



    }
}
