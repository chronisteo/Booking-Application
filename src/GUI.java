import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class GUI {


    public static void main(String[] args){

        ArrayList<User> users = new ArrayList<>();

        try(ObjectInputStream ios=new ObjectInputStream(new FileInputStream("myfile.bin"))){
            users=(ArrayList<User>) ios.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

       new InitialFrame(users);


    }
}
