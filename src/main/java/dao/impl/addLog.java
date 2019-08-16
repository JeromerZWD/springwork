package dao.impl;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class addLog {
   @After(value = "execution(* dao.impl.AccountDaoImpl.*(..))")
    public void log(){
        System.out.println("日志");
    }
    @Before(value = "execution(* dao.impl.AccountDaoImpl.*(..))")
    public void grant(){
        System.out.println("权限");
    }
}
