package com.haotian.consumer.Error;

import org.springframework.stereotype.Service;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


@Service
public class ActiveMQHandler implements ErrorHandler {
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        System.out.println("发生warning"+exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        System.out.println("发生error"+exception);

    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.out.println("发生fatalError"+exception);

    }
}
