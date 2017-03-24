package bwf.teaching.book.web.action.manage;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bwf.teaching.book.entity.Admin;
import bwf.teaching.book.service.AdminService;

@SuppressWarnings("serial")
@Controller("adAction")
@Scope("prototype")
public class AdminAction extends ActionSupport {
	
	@Resource(name="adService")
	private AdminService adminService;
	
	private String loginId;
	private String loginPsw;

	public String loginForm() {		
		return SUCCESS;
	}
	
	public String loginCheck() {
	
		Admin admin = adminService.loginCheck(loginId, loginPsw);
		if(admin == null) {
			ActionContext.getContext().put("msg", "登录失败：账号或者密码错误！");
			return INPUT;
		} else {
			ActionContext.getContext().getSession().put("currAdmin", admin);
			return SUCCESS;
		}
	}
	
	/* 去管理员首页的请求 */
	public String home() {
		return SUCCESS;
	}
	
	
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPsw() {
		return loginPsw;
	}

	public void setLoginPsw(String loginPsw) {
		this.loginPsw = loginPsw;
	}
}
