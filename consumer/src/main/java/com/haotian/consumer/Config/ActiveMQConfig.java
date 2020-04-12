package com.haotian.consumer.Config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
@EnableJms
public class ActiveMQConfig {
    @Bean      //在此 写了一个bean
    public Queue queue() {
        return new ActiveMQQueue("springboot.queue") ;

    }
    @Bean
    public JmsListenerContainerFactory jmsTopicListenerContainerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //这里必须设置为true，false则表示是queue类型
        factory.setPubSubDomain(true);
        //factory.setErrorHandler((org.springframework.util.ErrorHandler) errorHandler);
//        factory.setErrorHandler((ErrorHandler) activeMQHandler);
        return factory;
    }
    @Bean
    public Topic topic() {
        return new ActiveMQTopic("springboot.topic") ;
    }
}
