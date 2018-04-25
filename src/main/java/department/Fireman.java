package department;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Fireman implements Runnable{

    private final Message message;

    public void run () {
        synchronized (message) {
            try {
                System.out.println(Thread.currentThread().getName()+" is waiting for signal");
                message.wait();
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
            System.out.println("This amazing guy with '"+Thread.currentThread().getName()+
                    "' name went to save someone.\nWish him good luck");
        }
    }
}
