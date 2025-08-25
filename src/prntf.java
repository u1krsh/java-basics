public class prntf {
    public static void main(String[] args){
        String name = "Saumya";
        char firstLetter = 'S';
        int age = 19;
        double height =  164.6;
        boolean isStudent = true;

        System.out.printf("Hello %s\n",name);
        System.out.printf("First Letter %c\n",firstLetter);
        System.out.printf("%s's age is %d\n",name,age);
        System.out.printf("%s's height is %f\n",name,height);
        System.out.printf("is %s a student: %b\n",name,isStudent);

    }
}
