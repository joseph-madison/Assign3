import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserService {
    private UserPojo[][] UserPojo;

    public UserPojo[] readUserFromFile(String fileName) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"));
        int userCount = 0;
        while (bufferedReader.readLine()!= null){
            userCount++;
        }
        bufferedReader.close();

        UserPojo[] userPojos = UserPojo[userCount];
        bufferedReader = new BufferedReader(new FileReader("src/data.txt"));

        String line;
        int index = 0;
        while ((line = bufferedReader.readLine())!=null){
            String[] parts = line.split(",");
            if (parts.length==4) {
                userPojos[index++] = new UserPojo(parts[0], parts[1], parts[2]);
            }
        }
        bufferedReader.close();
        return userPojos;

    }

}
