package department;

import lombok.AllArgsConstructor;
import java.util.Random;

@AllArgsConstructor
public class Admin implements Runnable {
    private final Message message;

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " is waiting");

        try {
            Thread.sleep(new Random().nextInt(10000));
            synchronized (message) {
                message.notify();
                System.out.println("yep");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
