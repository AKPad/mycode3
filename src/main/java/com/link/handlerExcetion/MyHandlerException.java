package com.link.handlerExcetion;

import com.link.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义MyHandlerException实现HandlerExceptionResolver
 */
public class MyHandlerException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object o,
            Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        //向下转型，父类使用子类特有的方法
        //用来判断e是否是MyException的实例对象或者MyException子类的实例对象。
        System.out.println(e.getMessage());
        if (e instanceof MyException) {
            MyException me = (MyException) e;
            modelAndView.addObject( "code", me.getCode() );
            modelAndView.addObject( "msg", me.getMsg() );
        } else {
            modelAndView.addObject( "code", MyException.SYS_CODE );
            modelAndView.addObject( "msg", MyException.SYS_MSG );
        }

        modelAndView.setViewName( "msg" );
        return modelAndView;
    }
}
