package com.ascent.interceptor;

import com.ascent.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class CheckLoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		  System.out.println("begin check login interceptor!");
//		  Object action = actionInvocation.getAction();
//		  // 对LoginAction不做该项拦截
//		  if (action instanceof LoginAction) {
//		   System.out.println("exit check login, because this is login action.");
//		   return actionInvocation.invoke();
//		  }
		  // 确认Session中是否存在LOGIN
//		  Map session = actionInvocation.getInvocationContext().getSession();
//		  String login = (String) session.get(LOGIN_KEY);
//		  User user = (User)ActionContext.getContext().getSession().get("user");
		  String username = (String) actionInvocation.getInvocationContext().getSession().get("username");
		  //System.out.println("Session Username: " +login);
		  if (username != null && username.length() > 0) {
		   // 存在的情况下进行后续操作。
		   System.out.println("already login!");
		   return actionInvocation.invoke();
		  } else {
		   // 否则终止后续操作，返回LOGIN
		   System.out.println("no login, forward login page!");
		   return "noLogin";
		  }
	}

}
