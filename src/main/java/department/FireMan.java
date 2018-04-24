package department;

public class FireMan implements Runnable{
    public Thread t;

    public FireMan(){
        t = new Thread(this);
        t.start();
    }
    public void run(){
//        try{
//            wait();
//        } catch (InterruptedException e){
//            System.err.println(e.getMessage());
//        }
        System.out.println(t.getName()+" went to fire place");
    }
}
