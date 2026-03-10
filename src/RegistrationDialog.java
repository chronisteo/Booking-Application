import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RegistrationDialog extends JDialog {

    private final JTextField username1;
    private final JTextField fullname1;
    private final JPasswordField password1;
    private final JTextField address1;
    private final ArrayList<User> users;
    private final JLabel success;

    public RegistrationDialog(InitialFrame frame1, boolean modality){

        super(frame1,"Registration",modality);
        users=frame1.getUsers();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setSize(1000, 800);
        setLocation(frame1.getX() + 200, frame1.getY() + 100);
        setResizable(true);
        JLabel username = new JLabel("Username:");
        JLabel password = new JLabel("Password:");
        JLabel fullname = new JLabel("Fullname:");
        JLabel address = new JLabel("Address:");

        username1=new JTextField("");
        password1=new JPasswordField("");
        fullname1=new JTextField("");
        address1=new JTextField("");
        success=new JLabel("");
        JRadioButton accommodationOwner=new JRadioButton("Accommodation Owner");
        JRadioButton hotelOwner=new JRadioButton("Hotel Owner");
        JRadioButton customer=new JRadioButton("Customer");
        JRadioButton admin=new JRadioButton("Admin");
        ButtonGroup group=new ButtonGroup();
        group.add(accommodationOwner);
        group.add(hotelOwner);
        group.add(customer);
        group.add(admin);

        JPanel radiopanel=new JPanel(new GridLayout(0,1));
        radiopanel.add(hotelOwner);
        radiopanel.add(accommodationOwner);
        radiopanel.add(customer);
        radiopanel.add(admin);
        TitledBorder border = BorderFactory.createTitledBorder("CHOOSE YOUR TYPE");
        radiopanel.setBorder(border);

        JPanel panel1=new JPanel();
        TitledBorder border1 = BorderFactory.createTitledBorder("FILL THE FORM ");
        panel1.setBorder(border1);
        GridLayout grid = new GridLayout(0, 2, 10, 20);
        panel1.setLayout(grid);

        panel1.add(fullname);
        panel1.add(fullname1);
        panel1.add(username);
        panel1.add(username1);
        panel1.add(password);
        panel1.add(password1);
        panel1.add(address);
        panel1.add(address1);


        JButton submit = new JButton("SUBMIT");
        submit.addActionListener(e -> {
            boolean isValid=true;
            String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}1234567890";

            for (int i=0; i < fullname1.getText().length() ; i++)
            {
                char ch = fullname1.getText().charAt(i);
                if(specialCharactersString.contains(Character.toString(ch))) {
                    isValid=false;
                    success.setText("Not right full name");
                    return;
                }

            }
            String specialCharactersString1 = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
            for (int i=0; i < address1.getText().length() ; i++)
            {
                char ch = address1.getText().charAt(i);
                if(specialCharactersString1.contains(Character.toString(ch))) {
                    isValid=false;
                    success.setText("Not right address");
                    return;
                }

            }
            for(User user :users){
                if(user.getUsername().equals(username1.getText())){
                    isValid=false;
                }
            }
            if(username1.getText().equals("") || fullname1.getText().equals("") || password1.getText().equals("") || address1.getText().equals(""))
                isValid=false;
            if(isValid){
                if(accommodationOwner.isSelected()){
                    AccommodationOwner owner1=new AccommodationOwner(username1.getText(), password1.getText(), fullname1.getText(), address1.getText());
                    users.add(owner1);
                }else if(hotelOwner.isSelected()){
                    HotelOwner owner1=new HotelOwner(username1.getText(), password1.getText(), fullname1.getText(), address1.getText());
                    users.add(owner1);
                }else if(customer.isSelected()){
                    Customer customer1 =new Customer(username1.getText(), password1.getText(), fullname1.getText(), address1.getText());
                    users.add(customer1);
                }else{
                    Admin admin1 =new Admin(username1.getText(), password1.getText(), fullname1.getText(),address1.getText());
                    users.add(admin1);
                }
                dispose();
                success.setText("You have registered successfully.");

                try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("myfile.bin"))){
                    oos.writeObject(users);
                }catch (IOException t){
                    t.printStackTrace();
                }

            }
            else{
                if(username1.getText().equals("") || fullname1.getText().equals("") || password1.getText().equals("") || address1.getText().equals(""))
                    success.setText("You left blank fields.");
                else
                    success.setText("Username is already taken.Choose other.");
            }

        });

        JPanel panel2=new JPanel(new GridLayout(0,1));
        panel2.add(success);
        panel2.add(submit);

        add(panel1,BorderLayout.PAGE_START);
        add(radiopanel,BorderLayout.CENTER);
        add(panel2,BorderLayout.PAGE_END);

        pack();
        setVisible(true);
    }
}
