import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents the login procedure,where one user types his credentials and the system checks if he is registered in the system.
 */

public class Login {

    /**
     * This method checks if the user is registered in the system with the credentials that he typed, and it returns what type of user he is
     * It also checks if the user typed 10 times wrong credentials,in order to return him to the home page.
     * @param users an arraylist with all the users that are registered in the system
     * @return an int,depending on the type of user he is
     */

    public User exists(ArrayList<User> users){

        int efforts=0;
        String username,password;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Give your username:");
        username=scanner.nextLine();
        System.out.println("Give your password:");
        password=scanner.nextLine();


        while(efforts<10){
            efforts++;
            for(User user:users)
                if(user.getUsername().equals(username)&& user.getPassword().equals(password))
                    if(user instanceof HotelOwner){
                        return user;
                    }
                    else if(user instanceof AccommodationOwner){
                        return user;
                    }
                    else if(user instanceof Admin)
                        return user;
                    else if(user instanceof Customer)
                        return user;
            System.out.println("Wrong username or password!");
            System.out.println("Give your username:");
            username=scanner.nextLine();
            System.out.println("Give your password:");
            password=scanner.nextLine();
        }
        System.out.println("You've typed wrong inputs many times,sign up if you want");
        System.out.println();
        //user does not exist
        return new User("invalid","invalid","invalid");
    }
}
