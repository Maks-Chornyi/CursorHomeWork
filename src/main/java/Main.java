//import department.Administrator;
//import department.FireMan;
//
//import java.beans.IntrospectionException;
//
//public class Main{
//    public static void main(String[] args) {
//        new Administrator().callToDutyMan();
//
//        FireMan f1 = new FireMan();
//        FireMan f2 = new FireMan();
//        FireMan f3 = new FireMan();
//        try{a
//            f1.wait();
//            f2.wait();
//            f3.wait();
//            Thread.sleep(2000);
//            f1.notify();
//            f2.notify();
//            f3.notify();
//        } catch (InterruptedException e){
//            e.getStackTrace();
//        }
//        try{
//            f1.t.join();
//            f1.t.join();
//            f1.t.join();
//        } catch (InterruptedException e){
//            e.getStackTrace();
//        }
//        System.out.println("DONE");
//
//    }
//}












//public class Main{
//    public static void main(String[] args) {
//
//        Thread t = new Thread(new NewThread());
//        t.start();
//        System.out.println(Thread.currentThread().getName());
//        try {
//            t.wait();
//            Thread.sleep(1500);
//            t.notify();
//        } catch (InterruptedException e){
//            e.getStackTrace();
//        }
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName()+" ended");
//    }
//}
//
//class NewThread implements Runnable{
//
//    public void run(){
//        System.out.println("This is "+Thread.currentThread().getName());
//
//    }
//}

import sun.util.locale.provider.CurrencyNameProviderImpl;

class Q{
    int n;
    boolean valueSet = false;

    synchronized int get(){
        while(valueSet){
            try{
                wait();
            } catch (InterruptedException e){}
        }
        System.out.println("Get: "+n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put (int n){
        while(valueSet){
            try{
                wait();
            } catch (InterruptedException e){}
        }
        this.n = n;
        valueSet = true;
        System.out.println("Sent: "+n);
        notify();
    }
}

class Producer implements Runnable{
    Q q;

    Producer(Q q){
        this.q = q;
        new Thread(this,"Producer").start();
    }
    public void run(){

        int i = 0;
        while (true){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){}
            q.put(i++);
        }
    }
}

class Consumer implements Runnable{
    Q q;

    Consumer(Q q){
        this.q = q;
        new Thread(this,"Consumer").start();
    }

    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){}
            q.get();
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);

        System.out.println("To stop Press Ctrl+C");
    }
}