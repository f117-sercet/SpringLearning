package com.Demo05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * lei
 * @author 12
 */
@Service("render")
public class StandardOutMessageRender implements MessgaeRenderer{
    private  MessageProvider messageProvider;
    @Override
    public void render() {
        if (messageProvider==null){
            throw new RuntimeException("你玩完了");
        }

    }

    @Override
    @Autowired
    public void setMessageProvider(MessgaeRenderer provider) {
      this.messageProvider=messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
