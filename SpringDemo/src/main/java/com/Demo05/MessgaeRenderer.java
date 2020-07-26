package com.Demo05;

public interface MessgaeRenderer {
    void render();
    void setMessageProvider(MessgaeRenderer provider);
    MessageProvider getMessageProvider();
}
