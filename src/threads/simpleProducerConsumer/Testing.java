package threads.simpleProducerConsumer;

public class Testing {

    public static void main(String[] args) {
        Producer producer = new Producer();
        Messages messagesQueue = producer.getMessages(); // returns created class for communication
        Consumer consumer = new Consumer(messagesQueue);
        // to prevent main thread, associated with this main method to end before the Producer ends generation of messages
        try {
            producer.getAssociatedThread().join();
            consumer.getAssociatedThread().join();
        } catch (InterruptedException e) {e.printStackTrace();}
    }
}
