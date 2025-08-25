class User{
    String username;
    String email;
    int age;

    User(String username){
        this.username=username;
        this.email="Not Provided";
        this.age = 0;
    }
    User(String username,String email){
        this.username=username;
        this.email="Not Provided";
        this.age = 0;
    }

}

public class overload_cons {
    public static void main(String[] args){
        User user1 = new User("u1krsh");
        User user2 = new User("saumya","ksaumya053@gmail.com");

        System.out.println(user1.username);
    }
}
