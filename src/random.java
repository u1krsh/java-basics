import java.util.Random;
public class random {
    public static void main(String[] args){
        Random rand = new Random();

        int number = rand.nextInt(1, 7);
        System.out.println(number);
        double dbl = rand.nextDouble(1, 2);
        System.out.println(dbl);
    }
}