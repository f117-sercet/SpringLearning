package Demo01;

public class StanderOutMessageRender implements MessageRender {
    private MessageProvider messageProvider;

    public void render() {
        if(messageProvider==null){
            throw new RuntimeException(StanderOutMessageRender.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    public void setMessageProvider(MessageProvider provider) {
           this.messageProvider=provider;
    }

    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
