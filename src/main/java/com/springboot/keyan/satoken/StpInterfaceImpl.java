package com.springboot.keyan.satoken;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 */
@Component
public class StpInterfaceImpl implements StpInterface {


    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginKey) {
        List<String> list = new ArrayList<String>();
        /*List<String> menuList=iHjRoleMenuService.getMenuList(loginId);
        for (String menuPerm : menuList) {
            if(!StringUtils.isEmpty(menuPerm)){
                list.add(menuPerm);
            }
        }*/
        return list;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginKey) {
        List<String> list = new ArrayList<String>();
        /*List<String> roleList=iHjManagerRoleService.getRoleList(loginId);
        for (String rolePerm : roleList) {
            if(!StringUtils.isEmpty(rolePerm)){
                list.add(rolePerm);
            }
        }*/
        return list;
    }

}
