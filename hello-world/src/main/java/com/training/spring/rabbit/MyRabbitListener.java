package com.training.spring.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {


    private static final Logger logger = LoggerFactory.getLogger(MyRabbitListener.class);


    @Value("${server.port}")
    private Integer port;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-queue", durable = "true", autoDelete = "false"),
                                             exchange = @Exchange(name = "message-exchenage",
                                                                  durable = "true",
                                                                  autoDelete = "false"),
                                             key = "sms-send"))
    public void handleSMSMessage(final String str) {
        System.out.println(this.port + " Received SMS : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "email-queue",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "message-exchenage",
                                                                  durable = "true",
                                                                  autoDelete = "false"),
                                             key = "email-send"))
    public void handleEmailMessage(final String str) {
        System.out.println(this.port + " Received EMAIL : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "all-message-queue",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "message-topic-exchange",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "send.sms.turkey.#"))
    public void handleAllMessages(final Message msg) {

        System.out.println(this.port + " Received ALL : " + msg);

        //        MyRabbitListener.logger.debug(this.port + " Received ALL : " + msg);
        //
        //        MyRabbitListener.logger.debug("{} Received ALL : {}",
        //                                      this.port,
        //                                      msg);
        //
        //        if (MyRabbitListener.logger.isDebugEnabled()) {
        //            MyRabbitListener.logger.debug("[MyRabbitListener][handleAllMessages]-> "
        //                                          + this.port
        //                                          + " Received ALL : "
        //                                          + msg);
        //        }


    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "istanbul-message-queue",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "message-topic-exchange",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "send.sms.turkey.istanbul.#"))
    public void handleIstanbulMessages(final Message msg) {
        System.out.println(this.port + " Received Istanbul : " + msg);

    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "ankara-message-queue",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "message-topic-exchange",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "send.sms.turkey.ankara.#"))
    public void handleAnkaraMessages(final Message msg) {
        System.out.println(this.port + " Received Ankara : " + msg);

    }

}
