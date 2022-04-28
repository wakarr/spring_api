package jp.com.feeps.lesson7;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdminIntercepter {

	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletResponse response;
	
//	@Before("execution(* jp.com.feeps.lesson5.ItemAdd.inputItem(..))")
//	public void loginCheck(JoinPoint joinPoint) throws IOException{
//		
//		System.out.println("AdminIntercepter");
//		
//		String admin = (String) session.getAttribute("admin");
//		
//		if(admin == null) {
//			response.sendRedirect("/spring_practice/inputAdmin");
//		}
//		
//	}
	
	@Around("execution(* jp.com.feeps.lesson5.ItemAdd.inputItem(..))")
	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("前処理");
		
		String admin = (String) session.getAttribute("admin");
		
		if(admin == null) {
			response.sendRedirect("/spring_practice/inputAdmin");
		}
		
		// 呼び出されたメイン処理の実行
		String html = (String)joinPoint.proceed();
		
		System.out.println("後処理");
		
		return html;
	}
	
}
