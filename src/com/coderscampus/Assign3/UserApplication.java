import java.io.IOException;

public class UserApplication {
    public static void main(String [] args){
        UserService userService = new UserService();
        try{
            UserPojo[] userPojos = userService.readUserFromFile("src/data.txt");

            for (UserPojo userPojo: userPojos){
                System.out.println("Username: " + userPojo.getUsername());
                System.out.println("Password " + userPojo.getPassword());
                System.out.println("Name "+ userPojo.getName());
                System.out.println("___________________");

            }
        }catch (IOException e){
            System.out.println("Error reading user data " + e.getMessage());
        }
    }
}
