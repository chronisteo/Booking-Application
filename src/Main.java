import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 * this class represents the user interface
 */

public class Main {

    /**
     * this method initializes 3 users(1 Provider(1 HotelOwner,1 AccommodationOwner),1 Customer and 1 Admin)
     * and implements all the features we 've made for every kind of user.
     * @param args arguments
     */

    public static void main(String[] args) {

        //here creating Provider-HotelOwner
        HotelOwner hotelOwner = new HotelOwner("tony_loudis", "vrakas1926", "Antonis Apostoloudis", "Aigaiou 25");

        Hotel hotel1 = new Hotel("Thessaloniki", "Electra Palace", true, true, true, true, true);
        HotelRoom singleRoom = new SingleRoom("Antonis Apostoloudis", "Electra Palace", 36, 134, true, true, true);
        HotelRoom doubleRoom = new DoubleRoom("Antonis Apostoloudis", "Electra Palace", 56, 167, false, true, true);
        singleRoom.setNumber(hotel1.getHotelRooms().size());
        hotel1.addHotelRoom(singleRoom);
        doubleRoom.setNumber(hotel1.getHotelRooms().size());
        hotel1.addHotelRoom(doubleRoom);

        Hotel hotel2 = new Hotel("Thessaloniki", "Queen Olga", false, false, true, false, true);
        HotelRoom singleRoom1 = new SingleRoom("Antonis Apostoloudis", "Queen Olga", 22, 15, true, true, true);
        HotelRoom familyRoom = new FamilyRoom("Antonis Apostoloudis", "Queen Olga", 80, 90, false, true, true);
        singleRoom1.setNumber(hotel2.getHotelRooms().size());
        hotel2.addHotelRoom(singleRoom1);
        familyRoom.setNumber(hotel2.getHotelRooms().size());
        hotel2.addHotelRoom(familyRoom);

        hotelOwner.addHotel(hotel1);
        hotelOwner.addHotel(hotel2);

        //here creating Provider-AccommodationOwner
        AccommodationOwner accommodationOwner = new AccommodationOwner("thodoris_chronis", "tsoumakas1926", "Thodoris Chronis", "Aigaiou 26");

        Apartment apartment = new Apartment("Lagyna", "Thodoris Chronis", "Chronis Apartment", 230, 1000, true, true, true, 7);
        Villa villa = new Villa("Panorama", "Thodoris Chronis", "Chronis Villa", 450, 2000, true, true, true, true, false);
        Villa villa2 =new Villa("Panorama", "Thodoris Chronis", "Chronis Villa2", 500, 2100, true, true, true, true, false);

        accommodationOwner.addAccommodation(apartment);
        accommodationOwner.addAccommodation(villa);
        accommodationOwner.addAccommodation(villa2);

        //here creating admin
        Admin admin = new Admin("vassilis_kal", "papapa19", "Vasileios Kalemtzis","Lagynvn 45");

        //here creating Customer
        Customer customer = new Customer("vaggelis", "skotos13", "Vaggelis Dimos", "Agiou Dimitriou 2");

        ArrayList<User> users = new ArrayList<>();

        users.add(hotelOwner);
        users.add(accommodationOwner);
        users.add(customer);
        users.add(admin);

        /*try(ObjectInputStream ios=new ObjectInputStream(new FileInputStream("myfile.bin"))){
            users=(ArrayList<User>) ios.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }*/

        //----------------------------------

        /*boolean toStart = false;

        while (!toStart) {
            System.out.println("You already have an account?? Press 0 to Sign In");
            System.out.println("You ain't?? Press 1 to Sign Up");
            System.out.println("You want to exit?? Press 3 to exit");

            Scanner scanner = new Scanner(System.in);
            int k=-1;
            do {
                try{
                    k=scanner.nextInt();
                    if(k!=0 && k!=1 && k!=3)
                        System.out.println("You have not entered a valid number");
                }catch (InputMismatchException e){
                    System.out.println("You have not entered an integer");
                    scanner.next();
                }
            }while(k!=0 && k!=1 && k!=3);

            if (k == 0) {

                User m;
                Login login;

                login = new Login();
                m = login.exists(users);

                if (m instanceof HotelOwner) {

                    System.out.println("You are HotelOwner!");
                    while (k != 3) {
                        k=-1;
                        System.out.println("ADD A HOTEL(0),REMOVE A HOTEL(1),SHOW INFO(2),SIGN OUT(3)");
                        do {
                            try{
                                k=scanner.nextInt();
                                if(k!=0 && k!=1 && k!=2 && k!=3)
                                    System.out.println("You have not entered a valid number");
                            }catch (InputMismatchException e){
                                System.out.println("You have not entered an integer");
                                scanner.next();
                            }
                        }while(k!=0 && k!=1 && k!=2 && k!=3);

                        if (k == 0) {
                            String location;
                            String hotelName;
                            boolean breakfast, pool, wifi, airConditioning, parking;

                            System.out.println("Breakfast, true or false? : ");
                            breakfast = scanner.nextBoolean();
                            System.out.println("Pool, true or false? : ");
                            pool = scanner.nextBoolean();
                            System.out.println("Wifi, true or false? : ");
                            wifi = scanner.nextBoolean();
                            System.out.println("Parking, true  or false? : ");
                            parking = scanner.nextBoolean();
                            System.out.println("AirConditioning, true or false? :");
                            airConditioning = scanner.nextBoolean();
                            System.out.println("Location: ");
                            scanner.nextLine();
                            location = scanner.nextLine();
                            System.out.println("Name: ");
                            hotelName = scanner.nextLine();

                            Hotel newHotel = new Hotel(location, hotelName, breakfast, pool, wifi, parking, airConditioning);
                            ((HotelOwner) m).addHotel(newHotel);

                            System.out.println("Time to add hotelRooms at your new hotel!");
                            boolean room=false;
                            Scanner t=new Scanner(System.in);
                            int CHOICE=-1;
                            System.out.println("SINGLE ROOM(0),DOUBLE ROOM(1),FAMILY ROOM(2),STOP ADDING HOTEL ROOMS(3) :");

                            do{
                                try{
                                    CHOICE=t.nextInt();
                                    if(CHOICE!=0 && CHOICE!=1 && CHOICE!=2 && CHOICE!=3)
                                        System.out.println("You have not entered a valid number");
                                }catch (InputMismatchException e){
                                    System.out.println("You have not entered an integer");
                                    t.next();
                                }
                            }while(CHOICE!=0 && CHOICE!=1 && CHOICE!=2 && CHOICE!=3);

                            if(CHOICE==3){
                                System.out.println("You did not add any hotelRooms!");
                                room=true;
                            }

                            while(!room) {

                                int m2=-1;
                                int price=1;
                                boolean nonSmoking,balcony,tv;

                                System.out.println("Price: ");

                                do{
                                    try {
                                        price=t.nextInt();
                                        if(price<0)
                                            System.out.println("You have not entered a valid number");
                                    }catch (InputMismatchException e){
                                        System.out.println("You have not entered an integer");
                                        t.next();
                                    }
                                }while(price<0);

                                System.out.println("M2: ");

                                do{
                                    try {
                                        m2=t.nextInt();
                                        if(m2<0)
                                            System.out.println("You have not entered a valid number");
                                    }catch (InputMismatchException e){
                                        System.out.println("You have not entered an integer");
                                        t.next();
                                    }
                                }while(m2<0);

                                System.out.println("Non smoking,true or false: ");
                                nonSmoking=t.nextBoolean();
                                System.out.println("Balcony,true or false: ");
                                balcony=t.nextBoolean();
                                System.out.println("TV,true or false: ");
                                tv=scanner.nextBoolean();
                                if(CHOICE==0){
                                    SingleRoom singleRoom2=new SingleRoom(m.getFull_name(),hotelName,m2,price,nonSmoking,balcony,tv);
                                    newHotel.addHotelRoom(singleRoom2);
                                }
                                else if(CHOICE==1){
                                    DoubleRoom doubleRoom2=new DoubleRoom(m.getFull_name(),hotelName,m2,price,nonSmoking,balcony,tv);
                                    newHotel.addHotelRoom(doubleRoom2);
                                }
                                else if(CHOICE==2){
                                    FamilyRoom familyRoom2=new FamilyRoom(m.getFull_name(),hotelName,m2,price,nonSmoking,balcony,tv);
                                    newHotel.addHotelRoom(familyRoom2);
                                }
                                else if(CHOICE==3){
                                    room=true;
                                }

                                System.out.println("SINGLE ROOM(0),DOUBLE ROOM(1),FAMILY ROOM(2),STOP ADDING HOTEL ROOMS(3) :");
                                CHOICE=-1;
                                do{
                                    try{
                                        CHOICE=t.nextInt();
                                        if(CHOICE!=0 && CHOICE!=1 && CHOICE!=2 && CHOICE!=3)
                                            System.out.println("You have not entered a valid number");
                                    }catch (InputMismatchException e){
                                        System.out.println("You have not entered an integer");
                                        t.next();
                                    }
                                }while(CHOICE!=0 && CHOICE!=1 && CHOICE!=2 && CHOICE!=3);

                                if(CHOICE==3){
                                    room=true;
                                }

                            }


                        } else if (k == 1) {
                            int counter=0;
                            int choice=-1;

                            for (Hotel hotel : ((HotelOwner) m).getHotels()) {
                                System.out.println(counter+")");
                                counter++;
                                hotel.show();
                                System.out.println();
                                System.out.println();
                            }
                            if(counter==0){
                                System.out.println("There are no hotels to remove!!");
                            }
                            else{
                                System.out.println("Choose the hotel you want to remove,by pressing the number this hotel represents at the list");

                                do {
                                    try{
                                        choice=scanner.nextInt();
                                        if(choice<0 || choice>=((HotelOwner) m).getHotels().size())
                                            System.out.println("You have not entered a valid number");

                                    }catch(InputMismatchException e){
                                        System.out.println("You have not entered an integer");
                                        scanner.next();
                                    }
                                }while(choice<0 || choice>=((HotelOwner) m).getHotels().size());
                                ((HotelOwner) m).removeHotel(((HotelOwner) m).getHotels().get(choice),users);
                            }

                        } else if (k == 2) {
                            m.show();
                        }
                        else if(k==3) {
                            toStart = false;
                        }
                    }
                }
                else if (m instanceof AccommodationOwner) {

                    System.out.println("You are an AccommodationOwner!");
                    while (k != 3) {

                        System.out.println("ADD AN ACCOMMODATION(0),REMOVE AN ACCOMMODATION(1),SHOW INFO(2),SIGN OUT(3)");
                        k=-1;
                        do {
                            try {
                                k = scanner.nextInt();
                                if(k!=0 && k!=1 && k!=2 && k!=3)
                                    System.out.println("You have not entered valid number");
                            }catch (InputMismatchException e){
                                System.out.println("You have not entered an integer");
                                scanner.next();
                            }
                        }while (k!=0 && k!=1 && k!=2 && k!=3);
                        if (k == 0) {
                            int choice=-1;
                            System.out.println("ADD APARTMENT(0),ADD DETACHEDHOUSE(1),ADD MAISONETTE(2),ADD VILLA(3)");

                            do {
                                try {
                                    choice=scanner.nextInt();
                                    if(choice!=0 && choice!=1 && choice!=2 && choice!=3)
                                        System.out.println("You have not entered valid number");
                                }catch (InputMismatchException e){
                                    System.out.println("You have not entered an integer");
                                    scanner.next();
                                }
                            }while (choice!=0 && choice!=1 && choice!=2 && choice!=3);

                            if(choice==0){
                                String location;
                                String  apartmentName;
                                boolean wifi, airConditioning, parking;
                                int m2=-1;
                                int price=-1;
                                int floor=-1;
                                System.out.println("Number of floor: ");

                                do{
                                    try{
                                        floor=scanner.nextInt();
                                        if(floor<0)
                                            System.out.println("You have not entered a valid number");
                                    }catch (InputMismatchException e){
                                        System.out.println("You have not entered an integer");
                                        scanner.next();
                                    }
                                }while(floor<0);

                                System.out.println("Price: ");

                                do{
                                    try{
                                        price=scanner.nextInt();
                                        if(price<0)
                                            System.out.println("You have not entered a valid number");
                                    }catch (InputMismatchException e){
                                        System.out.println("You have not entered an integer");
                                        scanner.next();
                                    }
                                }while(price<0);

                                System.out.println("M2: ");

                                do{
                                    try{
                                        m2=scanner.nextInt();
                                        if(m2<0)
                                            System.out.println("You have not entered a valid number");
                                    }catch (InputMismatchException e){
                                        System.out.println("You have not entered an integer");
                                        scanner.next();
                                    }
                                }while(m2<0);
                                System.out.println("Wifi, true or false? : ");
                                wifi = scanner.nextBoolean();
                                System.out.println("Parking, true  or false? : ");
                                parking = scanner.nextBoolean();
                                System.out.println("AirConditioning, true or false? :");
                                airConditioning = scanner.nextBoolean();
                                System.out.println("Location: ");
                                scanner.nextLine();
                                location = scanner.nextLine();
                                System.out.println("Name: ");
                                apartmentName = scanner.nextLine();
                                Apartment newApartment=new Apartment(location,m.getFull_name(),apartmentName,m2,price,wifi,parking,airConditioning,floor);
                                ((AccommodationOwner) m).addAccommodation(newApartment);
                            }
                            else if(choice==1){

                                String location;
                                String  DetachedHouseName;
                                boolean wifi, airConditioning, parking,garden;
                                int m2=-1;
                                int price=-1;

                                System.out.println("Price: ");

                                do{
                                    try{
                                        price=scanner.nextInt();
                                        if(price<0)
                                            System.out.println("You have not entered a valid number");
                                    }catch (InputMismatchException e){
                                        System.out.println("You have not entered an integer");
                                        scanner.next();
                                    }
                                }while(price<0);
                                System.out.println("M2: ");
                                do{
                                    try{
                                        m2=scanner.nextInt();
                                        if(m2<0)
                                            System.out.println("You have not entered a valid number");
                                    }catch (InputMismatchException e){
                                        System.out.println("You have not entered an integer");
                                        scanner.next();
                                    }
                                }while(m2<0);

                                System.out.println("Garden, true or false? : ");
                                garden = scanner.nextBoolean();
                                System.out.println("Wifi, true or false? : ");
                                wifi = scanner.nextBoolean();
                                System.out.println("Parking, true  or false? : ");
                                parking = scanner.nextBoolean();
                                System.out.println("AirConditioning, true or false? :");
                                airConditioning = scanner.nextBoolean();
                                System.out.println("Location: ");
                                scanner.nextLine();
                                location = scanner.nextLine();
                                System.out.println("Name: ");
                                DetachedHouseName = scanner.nextLine();

                                DetachedHouse newDetachedHouse=new DetachedHouse(location,m.getFull_name(),DetachedHouseName,m2,price,wifi,parking,airConditioning,garden);
                                ((AccommodationOwner) m).addAccommodation(newDetachedHouse);
                            }
                            else if(choice==2){
                                String location;
                                String  MaisonetteName;
                                boolean wifi, airConditioning, parking,garden;
                                int m2=-1;
                                int price=-1;

                                System.out.println("Price: ");
                                do{
                                    try{
                                        price=scanner.nextInt();
                                        if(price<0)
                                            System.out.println("You have not entered a valid number");
                                    }catch (InputMismatchException e){
                                        System.out.println("You have not entered an integer");
                                        scanner.next();
                                    }
                                }while(price<0);
                                System.out.println("M2: ");
                                do{
                                    try{
                                        m2=scanner.nextInt();
                                        if(m2<0)
                                            System.out.println("You have not entered a valid number");
                                    }catch (InputMismatchException e){
                                        System.out.println("You have not entered an integer");
                                        scanner.next();
                                    }
                                }while(m2<0);
                                System.out.println("Garden, true or false? : ");
                                garden = scanner.nextBoolean();
                                System.out.println("Wifi, true or false? : ");
                                wifi = scanner.nextBoolean();
                                System.out.println("Parking, true  or false? : ");
                                parking = scanner.nextBoolean();
                                System.out.println("AirConditioning, true or false? :");
                                airConditioning = scanner.nextBoolean();
                                System.out.println("Location: ");
                                scanner.nextLine();
                                location = scanner.nextLine();
                                System.out.println("Name: ");
                                MaisonetteName = scanner.nextLine();

                                Maisonette newMaisonette=new Maisonette(location,m.getFull_name(),MaisonetteName,m2,price,wifi,parking,airConditioning,garden);
                                ((AccommodationOwner) m).addAccommodation(newMaisonette);
                            }
                            else if(choice==3){
                                String location;
                                String  VillaName;
                                boolean pool, wifi, airConditioning, parking,garden;
                                int m2=-1;
                                int price=-1;

                                System.out.println("Price: ");
                                do{
                                    try{
                                        price=scanner.nextInt();
                                        if(price<0)
                                            System.out.println("You have not entered a valid number");
                                    }catch (InputMismatchException e){
                                        System.out.println("You have not entered an integer");
                                        scanner.next();
                                    }
                                }while(price<0);
                                System.out.println("M2: ");
                                do{
                                    try{
                                        m2=scanner.nextInt();
                                        if(m2<0)
                                            System.out.println("You have not entered a valid number");
                                    }catch (InputMismatchException e){
                                        System.out.println("You have not entered an integer");
                                        scanner.next();
                                    }
                                }while(m2<0);

                                System.out.println("Garden, true or false? : ");
                                garden = scanner.nextBoolean();
                                System.out.println("Wifi, true or false? : ");
                                wifi = scanner.nextBoolean();
                                System.out.println("Pool, true or false? : ");
                                pool = scanner.nextBoolean();
                                System.out.println("Parking, true  or false? : ");
                                parking = scanner.nextBoolean();
                                System.out.println("AirConditioning, true or false? :");
                                airConditioning = scanner.nextBoolean();
                                System.out.println("Location: ");
                                scanner.nextLine();
                                location = scanner.nextLine();
                                System.out.println("Name: ");
                                VillaName = scanner.nextLine();

                                Villa newVilla=new Villa(location,m.getFull_name(),VillaName,m2,price,wifi,parking,airConditioning,garden,pool);
                                ((AccommodationOwner) m).addAccommodation(newVilla);
                            }


                        } else if (k == 1) {
                            int counter=0;
                            int choice;

                            for (Accommodation accommodation :  ((AccommodationOwner) m).getAccommodations()) {
                                System.out.println(counter+")");
                                counter++;
                                accommodation.show();
                                System.out.println();
                                System.out.println();
                            }
                            if(counter==0){
                                System.out.println("There are no accommodations to remove!!");
                            }
                            else{
                                System.out.println("Choose the accommodation you want to remove,by pressing the number this accommodation represents at the list");
                                choice=-1;
                                do {
                                    try {
                                        choice=scanner.nextInt();
                                        if(choice<0 || choice>=((AccommodationOwner) m).getAccommodations().size())
                                            System.out.println("You have not entered valid number");
                                    }catch (InputMismatchException e){
                                        System.out.println("You have not entered an integer");
                                        scanner.next();
                                    }
                                }while(choice<0 || choice>=((AccommodationOwner) m).getAccommodations().size());
                                ((AccommodationOwner) m).removeAccommodation(((AccommodationOwner) m).getAccommodations().get(choice),users);
                            }

                        } else if (k == 2) {
                            m.show();
                        }
                        else if(k==3) {
                            toStart = false;
                        }
                    }


                } else if (m instanceof Admin) {
                    System.out.println("You are an Admin!");

                    while (k != 3) {
                        System.out.println("SEND A MESSAGE(0),SHOW USERS(1),SHOW RESERVATIONS(2),SIGN OUT(3)");
                        k=-1;
                        do {
                            try {
                                k=scanner.nextInt();
                                if(k!=0 && k!=1 && k!=2 && k!=3)
                                    System.out.println("You have not entered valid number");
                            }catch (InputMismatchException e){
                                System.out.println("You have not entered an integer");
                                scanner.next();
                            }
                        }while (k!=0 && k!=1 && k!=2 && k!=3);
                        if(k==0)
                            ((Admin) m).sendMessage(users);
                        else if(k==1)
                            ((Admin) m).showUsers(users);
                        else if(k==2)
                            ((Admin) m).showReservations(users);
                        else if(k==3)
                            toStart=false;
                    }

                } else if (m instanceof Customer) {
                    System.out.println("You are a Customer!");

                    while (k != 3) {
                        System.out.println("SEARCH(0),SHOW INFO(1),MAKE A CANCELLATION(2),SIGN OUT(3)");
                        k=-1;
                        do {
                            try {
                                k=scanner.nextInt();
                                if(k!=0 && k!=1 && k!=2 && k!=3)
                                    System.out.println("You have not entered valid number");
                            }catch (InputMismatchException e){
                                System.out.println("You have not entered an integer");
                                scanner.next();
                            }
                        }while (k!=0 && k!=1 && k!=2 && k!=3);

                        if(k==0)
                            ((Customer) m).search(users);
                        else if(k==1)
                            m.show();
                        else if(k==2){
                            ((Customer) m).makeCancellation(users);
                        }
                        else if(k==3)
                            toStart=false;
                    }

                } else if (m.getUsername().equals("invalid")) {
                    System.out.println("You are returning to the main menu!");
                    System.out.println();
                    toStart = false;
                }
            } else if (k == 1) {
                Registration registration = new Registration();
                admin.acceptUser(users, registration);       //only this admin is able to accept users
                System.out.println("You have been registered successfully.Returning to the main menu.");
            }
            else if (k==3)
                toStart=true;
        }*/

        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("myfile.bin"))){
            oos.writeObject(users);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}





