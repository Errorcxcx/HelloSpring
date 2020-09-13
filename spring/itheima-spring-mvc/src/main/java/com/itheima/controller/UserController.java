package com.itheima.controller;

import com.alibaba.druid.stat.TableStat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/quick")
    public String save() {
        return "success";
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2() {
//        model：模型 封装数据  View：视图 展示数据
        ModelAndView modelAndView = new ModelAndView();
//        设置模型数据
        modelAndView.addObject("username", "itcast");
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        modelAndView.addObject("username", "asdfg");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick4")
    public String save4(Model model) {
        model.addAttribute("username", "啥也不是");
        return "success";
    }

    @RequestMapping(value = "/quick5")
    public void save5(HttpServletResponse response) throws IOException {
        response.getWriter().println("helllllll");
    }

    @RequestMapping(value = "/quick6")
    public String save6(HttpServletRequest request) {
        request.setAttribute("username", "三国演义 ");
        return "success";
    }

    @RequestMapping(value = "/quick7")
    //告知SpringMVC框架不要进行页面跳转 直接回写
    @ResponseBody
    public String save7() {
        return "itheima  sssss";
    }

    @RequestMapping(value = "/quick8")
    //告知SpringMVC框架不要进行页面跳转 直接回写
    @ResponseBody
    public String save8() {
        return "{\"username\":\"zhangsan\",\"age\":18}";
    }

    @RequestMapping(value = "/quick9")
    //告知SpringMVC框架不要进行页面跳转 直接回写
    @ResponseBody
    public String save9() throws JsonProcessingException {
        User user = new User();
        //使用json转换工具 将对象转换成Json格式字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        return json;
    }

    @RequestMapping(value = "/quick10")
    //告知SpringMVC框架不要进行页面跳转 直接回写
    @ResponseBody
    public User save10() throws JsonProcessingException {
        User user = new User();
        //使用json转换工具 将对象转换成Json格式字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        //自动将user转换成json格式字符串
        return user;
    }

    @RequestMapping(value = "/quick11")
    //告知SpringMVC框架不要进行页面跳转 直接回写
    @ResponseBody
    public void save11(String username, int age) throws JsonProcessingException {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value = "/quick12")
    //告知SpringMVC框架不要进行页面跳转 直接回写
    @ResponseBody
    public void save12(User user) throws JsonProcessingException {
        System.out.println(user.username);
        System.out.println(user.age);
    }

    @RequestMapping(value = "/quick13")
    //告知SpringMVC框架不要进行页面跳转 直接回写
    @ResponseBody
    public void save13(String[] strs) throws JsonProcessingException {
        System.out.println(strs[0]);
        System.out.println(strs[1]);
        System.out.println(strs[2]);

    }

    @RequestMapping(value = "/quick14")
    //告知SpringMVC框架不要进行页面跳转 直接回写
    @ResponseBody
    public void save14(VO vo) throws JsonProcessingException {
        System.out.println(vo);
        System.out.println(vo);

    }

    @RequestMapping(value = "/quick15")
    //告知SpringMVC框架不要进行页面跳转 直接回写
    @ResponseBody
    public void save15(@RequestBody List<User> userList) throws JsonProcessingException {
        System.out.println(userList);

    }

    @RequestMapping(value = "/quick16")
    //告知SpringMVC框架不要进行页面跳转 直接回写
    @ResponseBody
    public void save16(@RequestParam(value = "name") String username) throws JsonProcessingException {
    }

    @RequestMapping(value = "/quick17/{username}")
    //告知SpringMVC框架不要进行页面跳转 直接回写
    @ResponseBody
    public void save17(@PathVariable(value = "username") String username) throws JsonProcessingException {
        System.out.println(username);
    }


    @RequestMapping(value = "/quick18")
    //告知SpringMVC框架不要进行页面跳转 直接回写
    @ResponseBody
    public void save18(Date date) throws JsonProcessingException {
        System.out.println(date);
    }
    @RequestMapping(value = "/quick20")
    //告知SpringMVC框架不要进行页面跳转 直接回写
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent") String user_agent) throws JsonProcessingException {
        System.out.println(user_agent);
    }

    @RequestMapping(value = "/quick21")
    //告知SpringMVC框架不要进行页面跳转 直接回写
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionId) throws JsonProcessingException {
        System.out.println(jsessionId);
    }

    @RequestMapping(value = "/quick22")
    //告知SpringMVC框架不要进行页面跳转 直接回写
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        System.out.println(uploadFile);
        String fileName = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("H:\\sss\\"+fileName));

    }


}
