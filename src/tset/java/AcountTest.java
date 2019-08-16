import entity.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.AccountServiceImpl;

public class AcountTest {
    @Test
    public void add(){
   ApplicationContext context=new ClassPathXmlApplicationContext("springwork.xml");
       AccountServiceImpl accountService=(AccountServiceImpl)context.getBean("accountService");
       accountService.add(new Account(1,"zwd",10000));
    }
    @Test
    public void upd(){
        ApplicationContext context=new ClassPathXmlApplicationContext("springwork.xml");
        AccountServiceImpl accountService=(AccountServiceImpl)context.getBean("accountService");
        accountService.upd(new Account(1,"cjm",20000));
    }
    @Test
    public void sel(){
        ApplicationContext context=new ClassPathXmlApplicationContext("springwork.xml");
        AccountServiceImpl accountService=(AccountServiceImpl)context.getBean("accountService");
        Account account=accountService.selectById(1);
        System.out.println(account);
    }
    @Test
    public void count(){
        ApplicationContext context=new ClassPathXmlApplicationContext("springwork.xml");
        AccountServiceImpl accountService=(AccountServiceImpl)context.getBean("accountService");
        System.out.println(accountService.count());
    }
    @Test
    public void del(){
        ApplicationContext context=new ClassPathXmlApplicationContext("springwork.xml");
        AccountServiceImpl accountService=(AccountServiceImpl)context.getBean("accountService");
        System.out.println(accountService.del(5));
    }
    @Test
    public void selAll(){
        ApplicationContext context=new ClassPathXmlApplicationContext("springwork.xml");
        AccountServiceImpl accountService=(AccountServiceImpl)context.getBean("accountService");
        System.out.println(accountService.queryAll());
    }
    @Test
    public void accountBalance(){
        ApplicationContext context=new ClassPathXmlApplicationContext("springwork.xml");
        AccountServiceImpl accountService=(AccountServiceImpl)context.getBean("accountService");
        accountService.accountBalance(1,2,2000);
    }
}
