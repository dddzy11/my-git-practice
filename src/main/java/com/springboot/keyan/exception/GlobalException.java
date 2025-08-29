package com.springboot.keyan.exception;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.alibaba.fastjson.JSONObject;
import com.springboot.keyan.comm.ResultEnum;
import com.springboot.keyan.util.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalException {

    // 在当前类每个方法进入之前触发的操作
    @ModelAttribute
    public void get(HttpServletRequest request) throws IOException {

    }

    /**
     * 全局异常拦截（拦截项目中的所有异常）
     * @param e
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ExceptionHandler
    public ResultView handlerException(Exception e, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // 打印堆栈，以供调试
        log.error("---------------全局异常getMethod---------------"+request.getMethod());
        log.error("---------------全局异常getContextPath---------------"+ request.getRequestURL());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        e.printStackTrace(new PrintStream(baos));
        String exception = baos.toString();
        log.error("---------------printStackTrace---------------"+ exception);
        // 不同异常返回不同状态码
        if (e instanceof NotLoginException) {    // 如果是未登录异常
            NotLoginException ee = (NotLoginException) e;
            return ResultView.error(401, ee.getMessage());
        } else if (e instanceof NotRoleException) {        // 如果是角色异常
            NotRoleException ee = (NotRoleException) e;
            return ResultView.error(403, "无此角色：" + ee.getRole());
        } else if (e instanceof NotPermissionException) {    // 如果是权限异常
            NotPermissionException ee = (NotPermissionException) e;
            return ResultView.error(403, "无此权限：" + ee.getPermission());
        } else if (e instanceof MyException) {    // 如果是自定义异常
            MyException ee = (MyException) e;
            return errorResponse(ResultView.error(ee.getMessage()));
        } else if(e instanceof BindException){//参数校验异常
            FieldError fieldError = ((BindException) e).getFieldError();
            StringBuilder sb = new StringBuilder();
            assert fieldError != null;
            String errorMsg = fieldError.getDefaultMessage();
            sb.append(ResultEnum.CODE_2.getMsg()).append(errorMsg);
            return ResultView.error(ResultEnum.CODE_2.getCode(), sb.toString());
        } else if(e instanceof ConstraintViolationException){//参数校验异常
            String fieldError = ((ConstraintViolationException) e).getMessage();
            StringBuilder sb = new StringBuilder();
            assert fieldError != null;
            sb.append(ResultEnum.CODE_2.getMsg()).append(fieldError);
            return ResultView.error(ResultEnum.CODE_2.getCode(), sb.toString());
        }
        return ResultView.error(500, "系统异常，请联系开发人员处理");
    }



    /**
     * 集成结果打印
     *
     * @param resultView 统一返回对象
     * @return ResultView
     */
    private ResultView errorResponse(ResultView resultView) {
        String json = JSONObject.toJSONString(resultView);
        log.error("异常信息 {}", json);
        return resultView;
    }

}
