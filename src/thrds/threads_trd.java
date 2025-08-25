package thrds;

class MyThread extends Thread{
    public void run(){
        System.out.println("Thread is running");
    }
}
public class threads_trd {
    public static void main(String[] args){
        MyThread trdd = new MyThread();
        trdd.start();
    }
}
