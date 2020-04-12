package com.haotian.consumer.ActiveMQ;



import com.haotian.api.Entity.Account;
import com.haotian.api.MasterDatabase.Dao.AccountDao;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class RegisterC {
    @Reference
    private AccountDao accountDao;
    @JmsListener(destination="springboot.queue")
    public void ListenQueue(Account account) throws JMSException {

        System.out.println(account.getUserID());
        System.out.println(account.getUserPass());
        System.out.println(account.getUserRole());
        accountDao.save(account);
    }
}
