package threads.simpleProducerConsumer;

import java.util.Random;

public class Consumer implements Runnable{
    private Thread associatedThread;
    private Messages messages;

    Consumer(Messages messages){
        this.messages = messages;
        associatedThread = new Thread(this, "Consumer");
        associatedThread.start(); // automatically should start the run() method
    }

    public Thread getAssociatedThread() {
        return associatedThread;
    }

    @Override
    public void run() {
        boolean flag = true;
        System.out.println(Thread.currentThread().getName() + " - thread started");
        while (flag){
            String receivedMessage = messages.dequeue();
            System.out.println("Consumer processed: " + receivedMessage);
            // generate the random delay for processing the received message
            Random rn = new Random(); int multiplier = rn.nextInt(5);
            multiplier+= 1; int delay = 100*multiplier; // produces number from 100, 200, 300, 400
            // checking for ending infinite loop above (while)
            if (receivedMessage == "END OF Co-Running"){
                flag = false;
            }
            // simulation of working
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}
