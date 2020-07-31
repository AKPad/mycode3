package com.link.controller;

import com.link.exception.MyException;
import com.link.pojo.Account;
import com.link.service.AccountService;
import com.link.util.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 查询所有账户
     * @param modelAndView
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView modelAndView) {
        List<Account> accounts = accountService.findAll();
        modelAndView.addObject( "accounts",accounts );
        modelAndView.setViewName( "success" );
        return modelAndView;
    }

    /**
     * 参数绑定，与提交form表单中的name的值一样
     * @param desc
     * @param multipartFile
     * @return
     */
    @RequestMapping("/upload")
    public String upload(String desc, MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        System.out.println(desc);

        //获取文件的名字
        String originalFilename = multipartFile.getOriginalFilename();
        System.out.println(originalFilename);

        //保存到upload的目录中
        String realPath = request.getSession().getServletContext().getRealPath( "/upload" );

        //在指定目录中创建文件
        File file = new File( realPath );
        //随机的目录名、随机的名称减少冲突
        File uploadFile = new File(file, UploadUtils.getUUIDName( originalFilename ) );

        if(!uploadFile.exists()){
            //如果不存在则，创建目录
            uploadFile.mkdirs();
        }
        //转换保存
        multipartFile.transferTo(uploadFile);
        return "success";
    }


    @RequestMapping("/myException")
    public String myException(){
        try {
           // int i = 1/0;
            accountService.findAll();
        } catch (Exception e) {
            throw new MyException( "500","查询结果异常" );
        }
        return "success";
    }

    @RequestMapping("/world")
    public String world(){
        System.out.println("world");
        return "success";
    }

    @RequestMapping("/show")
    public String show(){
        System.out.println("show");
        return "success";
    }
}
