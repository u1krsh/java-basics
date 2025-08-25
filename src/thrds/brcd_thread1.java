package thrds;
import java.util.Scanner;
class thrdd implements Runnable{
    public void run(){
        for(int i = 1;i<=5;i++){
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("Thread was intruppted ");
            }
            if(i == 5){
                System.out.println("Time's Up");
                System.exit(0);
            }
        }
    }
}
public class brcd_thread1 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        thrdd runnable = new thrdd();
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);//will end program when main thread ends
        thread.start();
        System.out.println("You have 5 seconds to enter your name");
//        cant acces the code after loop bcz timer is running on the same thread
//        for(int i = 1;i<=5;i++){
//            try{
//                Thread.sleep(1000);
//            }
//            catch (InterruptedException e){
//                System.out.println("Thread was intruppted ");
//            }
//            if(i == 5){
//                System.out.println("Time's Up");
//            }
//        }

        System.out.print("Enter: ");
        String name = scn.next();
        System.out.println("Hello "+name);


        scn.close();
    }
}
