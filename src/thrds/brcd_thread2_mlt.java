package thrds;
class runna implements Runnable{
    private final String text;

    runna(String text){
        this.text = text;
    }
    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            try {
                Thread.sleep(1000);
//                System.out.println(Thread.currentThread().getName() + " "+ i);

                System.out.println(text);

            }
            catch (InterruptedException e){
                System.out.println("Interrupted");
            }
        }
    }
}
public class brcd_thread2_mlt {
    public static void main(String[] args){
//        runna runa = new runna();
        Thread thread1 = new Thread(new runna("Ping"));
        Thread thread2 = new Thread(new runna("Pong"));
        System.out.println("Start");
        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println("Stop");


    }
}
