import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents the registration procedure,where a user types his personal data(full name,address) and its credentials(username,password) in order to be registered in the system.
 */

public class Registration {
    /**
     * In this method the system asks the user to type his personal data,credentials and the type of user he wants to be and adds him to the list with the already registered users
     * It also checks the credentials he types(username),just so not to be the same with another user and to prevent any authentication errors
     * @param users an arraylist with all the already registered users.
     */

    public void addUser(ArrayList<User> users){
        String fullname,username,password;
        String address;
        Scanner scanner=new Scanner(System.in);

        System.out.println("Give your full name:");
        fullname=scanner.nextLine();

        System.out.println("Give your username:");
        username=scanner.nextLine();

        boolean k=false;
        boolean valid=true;

        while(!k) {
            for (User user : users)
                if (username.equals(user.getUsername())) {
                    valid = false;
                    break;
                }
            if(!valid){
                valid=true;
                System.out.println("Give another username:");
                username=scanner.nextLine();
            }
            else {
                k=true;
            }

        }

        System.out.println("Give your password:");
        password = scanner.nextLine();

        System.out.println("Give your address");
        address=scanner.nextLine();
        int type=-1;
        int type1=-1;
        do {
            System.out.println("Press 0 if you want to be a provider,1 for customer or 2 for admin");
            try{
                type= scanner.nextInt();
                if(type!=0 && type!=1 && type!=2){
                    System.out.println("You have not entered a valid number");
                }
            }catch (InputMismatchException e){
                System.out.println("You have not entered an integer");
                scanner.next();
            }

        }while (type!=0 && type!=1 && type!=2);

        if(type==0){
            do {
                System.out.println("Press 0 for accommodation owner or 1 for hotel owner");
                try{
                    type1= scanner.nextInt();
                    if(type1!=0 && type1!=1 ){
                        System.out.println("You have not entered a valid number");
                    }
                }catch (InputMismatchException e){
                    System.out.println("You have not entered an integer");
                    scanner.next();
                }

            }while (type1!=0 && type1!=1);
            if(type1==0){
                AccommodationOwner owner1=new AccommodationOwner(username,password,fullname,address);
                users.add(owner1);
            }else{
                HotelOwner owner1=new HotelOwner(username,password,fullname,address);
                users.add(owner1);
            }
        }else if(type==1){
            Customer customer=new Customer(username,password,fullname,address);
            users.add(customer);
        }else{
            Admin admin=new Admin(username,password,fullname,address);
            users.add(admin);
        }

    }

}
