package department;

public class FireMan implements Runnable{
    public static Thread t;

    public FireMan(){
        t = new Thread(this);
        t.start();
    }
    public void run(){
        System.out.println(t.getName());
    }
}
