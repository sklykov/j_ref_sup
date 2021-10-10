package threads.simpleProducerConsumer;

public class Producer implements Runnable{
    private int numberOfMessages = 5;
    private Thread associatedThread;
    private Messages messages;

    Producer(int numberOfMessages){
        this.numberOfMessages = numberOfMessages;
        // create the communication class - for sharing messages
        Messages messages = new Messages(this.numberOfMessages);
        this.messages = messages;
        // create associated thread
        associatedThread = new Thread(this, "Producer");
        associatedThread.start(); // starting of the thread instantaneously upon the creation
    }

    Producer(){
        // create the communication class - for sharing messages
        Messages messages = new Messages(this.numberOfMessages);
        this.messages = messages;
        // create associated thread
        associatedThread = new Thread(this, "Producer");
        associatedThread.start(); // starting of the thread instantaneously upon the creation
    }

    public Thread getAssociatedThread() {
        return associatedThread;
    }

    public Messages getMessages() {
        return messages;
    }

    @Override
    public void run() {
        String producerMessage = "Producer sent: ";
        System.out.println(Thread.currentThread().getName() + " - thread started");
        for(int i = 0; i < this.numberOfMessages; i++){
            if (i < (this.numberOfMessages - 1)){
                messages.enqueue(false, producerMessage);
            } else messages.enqueue(true, producerMessage);
        }
    }
}
