package com.blog.sys.menu.model;

import java.io.Serializable;

/**
 * 角色和菜单关联表
 */
public class SysRoleMenu implements Serializable {
    /**
     * 菜单ID
     */
    private String menuId;

    /**
     * 角色id
     */
    private String roleId;

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 菜单ID
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    /**
     * 角色id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", menuId=").append(menuId);
        sb.append(", roleId=").append(roleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}