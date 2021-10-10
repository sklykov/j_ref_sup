package threads.simpleProducerConsumer;

import java.util.ArrayDeque;
import java.util.Random;

public class Messages {

    private ArrayDeque<String> messages;
    private boolean messagingStarted = false;
    private int countGenerated = 1;

    Messages(int maxNumberMessages){
        this.messages = new ArrayDeque<>(maxNumberMessages);
    }

    // Constructor overloading instead of using default input parameters values (as in Python)
    Messages(){
        this.messages = new ArrayDeque<>(10);
    }

    // not synchronized for allowing to independently adding new messages to queue
    public void enqueue(boolean endOfMessaging, String producerMessage){
        // associated enqueue
        try{
            Thread.sleep(250); // introduce some deterministic time delay
            String notification = "Notification # " + this.countGenerated;  // build the message (notification)
            this.countGenerated++;
            if (endOfMessaging) notification = "END OF Co-Running";  // for stopping
            if (this.messages.add(notification)){
                System.out.println(producerMessage + notification);
                if (!this.messagingStarted) {
                    this.messagingStarted = true; // changing the flag that messaging started
                    // notify();  // DOESN'T WORK in not synchronized block
                }
            }
        } catch (InterruptedException e) {e.printStackTrace();}
    }

    public synchronized String dequeue(){
        String message = "Empty message - WARNING!";
        if (!this.messagingStarted){
            while(!this.messagingStarted){
                try {
                    // wait();  // DOESN'T WORK in not synchronized method, waits for notification of messaging started from Producer
                    Thread.sleep(10);
                } catch (InterruptedException e) {e.printStackTrace();}
            }
            message = this.messages.poll();
        } else {
            // if the messages array is already not empty just takes and returns the message
            if (this.messages.isEmpty()) {
                while (this.messages.isEmpty()) {
                    try {
                        Thread.sleep(10);  // introducing some update time for checking if any message was put into the array
                    } catch (InterruptedException e) {e.printStackTrace();}
                }
            }
            message = this.messages.poll();
        }
        return message;
    }
}
