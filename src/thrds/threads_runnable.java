package thrds;

class MyThread2 implements Runnable {
    public void run(){
        System.out.println("Thread is runnable");
    }
}
public class threads_runnable {
    public static void main(String[] args){
        MyThread2 trd = new MyThread2();
        trd.run();
    }
}
