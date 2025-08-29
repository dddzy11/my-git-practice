package com.springboot.keyan.satoken;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.springboot.keyan.util.DateUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
@EnableWebMvc
public class SaTokenConfigure implements WebMvcConfigurer {


    // 注册Sa-Token的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册路由拦截器，自定义验证规则
        //第一种写法
        registry.addInterceptor(new SaInterceptor(handle -> {
            //拦截PC端用户未登录所有接口
            SaRouter.match("/api/admin/**").notMatch("/api/admin/userlogin/login",
                    "/api/admin/registration/applyRegister","/api/admin/login/getVerify",
                    "/api/admin/login/createToken","/api/admin/task-list/download").check(r -> StpUtil.checkLogin());
        })).addPathPatterns("/**");
    }



    /**
     * 多日期格式转换为Date类型
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, Date>() {
            @Nullable
            @Override
            public Date convert(String s) {
                if ("".equals(s) || s == null) {
                    return null;
                }
                if (s.matches("^\\d{4}-\\d{1,2}$")) {
                    return DateUtils.stringToDate(s, DateUtils.formarts.get(0));
                } else if (s.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
                    return DateUtils.stringToDate(s, DateUtils.formarts.get(1));
                } else if (s.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
                    return DateUtils.stringToDate(s, DateUtils.formarts.get(2));
                } else if (s.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
                    return DateUtils.stringToDate(s, DateUtils.formarts.get(3));
                } else if (s.matches("^\\d{4}/\\d{1,2}/\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
                    return DateUtils.stringToDate(s, DateUtils.formarts.get(4));
                } else if (s.matches("^\\d{4}年\\d{1,2}月\\d{1,2}日 {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
                    return DateUtils.stringToDate(s, DateUtils.formarts.get(5));
                } else if (s.matches("^{1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
                    return DateUtils.stringToDate(s, DateUtils.formarts.get(6));
                }else {
                    throw new IllegalArgumentException("Invalid boolean value '" + s + "'");
                }
            }
        });
    }

    /**
     * 设置HTTP请求报文字符串UTF-8编码格式 消息转换器替换为fastJson
     * 用于解决springboot默认返回时间格式为json
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 创建配置类
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                // 保留 Map 空的字段
                SerializerFeature.WriteMapNullValue,
                // 将 String 类型的 null 转成""
                SerializerFeature.WriteNullStringAsEmpty,
                // 将 Number 类型的 null 转成 0
                SerializerFeature.WriteNullNumberAsZero,
                // 将 List 类型的 null 转成 []
                SerializerFeature.WriteNullListAsEmpty,
                // 将 Boolean 类型的 null 转成 false
                SerializerFeature.WriteNullBooleanAsFalse,
                // 避免循环引用
                SerializerFeature.DisableCircularReferenceDetect);
        //解决Long转json精度丢失的问题
/*        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(Long.class, ToStringSerializer.instance);
        serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
        config.setSerializeConfig(serializeConfig);*/
        //此处是全局处理方式
        //config.setDateFormat(DateUtils.DATE_TIME_FORMAT);
        //JSON.DEFFAULT_DATE_FORMAT=DateUtils.DATE_TIME_FORMAT;

        fastConverter.setFastJsonConfig(config);
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);
        fastConverter.setSupportedMediaTypes(supportedMediaTypes);
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(fastConverter);
        converters.add(stringHttpMessageConverter);
    }

}
