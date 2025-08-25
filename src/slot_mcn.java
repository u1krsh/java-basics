import java.util.Random;
public class slot_mcn {
    public static void main(String[] args){
        String a,b,c;
        Random rand = new Random();
        while(true){
            String[] slot = {"🔔", "🍒", "🏈"};
            int rnd1 = rand.nextInt(slot.length);
            int rnd2 = rand.nextInt(slot.length);
            int rnd3 = rand.nextInt(slot.length);
            a = slot[rnd1];
            b = slot[rnd2];
            c = slot[rnd3];
            System.out.println(a+b+c);


        }

    }
}
