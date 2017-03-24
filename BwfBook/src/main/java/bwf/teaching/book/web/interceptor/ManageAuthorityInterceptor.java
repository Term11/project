package bwf.teaching.book.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class ManageAuthorityInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		if(invocation.getInvocationContext().getSession().get("currAdmin") == null) {
			invocation.getInvocationContext().put("msg", "请先登录再进行其他操作！");
			return "login";
		} else {
			return invocation.invoke();
		}
	}

}
