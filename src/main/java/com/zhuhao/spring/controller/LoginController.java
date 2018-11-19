package com.zhuhao.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

/**
 * 这刚开始是一个helloworldcontroller ~~~
 */
@Controller
public class LoginController {


    @RequestMapping(value = "/tologin")
    public String login(@RequestParam(value = "username",required = false)String username,
                        @RequestParam(value = "password",required = false) String password,
                        Map<String,Object> map,HttpSession session

    ){

        if("".equals(username) || "".equals(password)){
            map.put("err","账号密码不为空");

            return "/index.html";
        }else{
            if("tom".equals(username) && "123".equals(password)){
                session.setAttribute("loginuser",username);
                return "redirect:/dashboard.html";
            }else{
                map.put("err","账号或密码不正确");
                return "/index.html";
            }
        }


    }

   @RequestMapping(value="dashboard")
   public String todashboard(){
       return "dashboard";
   }




    @ResponseBody
    @RequestMapping("/hello")
    public String toHello(Map<String,String> errmsg){
        System.out.println(errmsg);
        return errmsg.get("err");
    }

    @RequestMapping("/success")
    public String tosuccess(Map<String,Object> map, HttpServletRequest request, HttpSession session){
        session.setAttribute("hello2","<h1>success2</h1>");
        request.setAttribute("hello1","success1");
        map.put("hello","success");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));


        //classpath:/templates/success,html
        return "testthemeleaf";
    }

}
