package assng1;

public class q8 {

    public static void main(String[] args){
        int cntv = 0,cntc = 0;
        String s = "Saumya";
        char[] c = s.toCharArray();
        char[] vov = {'a','e','i','o','u','A','E','I','O','U'};
        for (char i : c) {
            for(char j:vov){
                if(i==j){
                    cntv++;
                }
                else {
                    cntc++;
                }
            }
        }
        System.out.println("Number of vowels: "+cntv);
        System.out.println("Number of constants: "+cntc);
    }
}
