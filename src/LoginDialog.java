import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class LoginDialog extends JDialog {
    private final JPasswordField password;
    private final JTextField username;
    private final JLabel success;
    private final ArrayList<User> users;
    private User loginuser;
    public LoginDialog(InitialFrame frame1, boolean modality){
        super(frame1,"Login",modality);
        users=frame1.getUsers();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setSize(1000, 800);
        setLocation(frame1.getX() + 200, frame1.getY() + 100);
        setResizable(false);

        JLabel name = new JLabel("Username:");
        JLabel pass = new JLabel("Password:");
        password=new JPasswordField("");
        username=new JTextField("");
        success=new JLabel("");

        JButton login = new JButton("Login");
        login.addActionListener(e -> {

            for(User user:users){
                if (user.getUsername().equals(username.getText()) && user.getPassword().equals(password.getText())) {
                    if (user instanceof HotelOwner) {
                        loginuser=user;
                        success.setText("VALID");
                        openHotelOwnerDialog();
                        break;
                    } else if (user instanceof AccommodationOwner) {
                        loginuser=user;
                        success.setText("VALID");
                        openAccommodationOwnerDialog();
                        break;
                    } else if (user instanceof Admin) {
                        loginuser=user;
                        success.setText("VALID");
                        openAdminDialog();
                        break;
                    } else if (user instanceof Customer) {
                        loginuser=user;
                        success.setText("VALID");
                        openCustomerDialog();
                        break;
                    }
                }
                else
                    success.setText("INVALID");

            }



        });

        JPanel panel1=new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder(" CREDENTIALS ");
        panel1.setBorder(border);
        GridLayout grid = new GridLayout(0, 2, 10, 20);
        panel1.setLayout(grid);

        panel1.add(name);
        panel1.add(username);
        panel1.add(pass);
        panel1.add(password);
        add(panel1,BorderLayout.CENTER);

        JPanel panel2=new JPanel();
        panel2.add(login);
        panel2.add(success);

        add(panel2,BorderLayout.PAGE_END);
        pack();
        setVisible(true);
    }

    public void openHotelOwnerDialog(){
        new HotelOwnerDialog(this, true);
    }
    public void openAdminDialog(){
         new AdminDialog(this, true);
    }
    public void openAccommodationOwnerDialog(){
         new AccommodationOwnerDialog(this, true);
    }
    public void openCustomerDialog(){
         new CustomerDialog(this, true);
    }

    public User getLoginuser(){
        return loginuser;
    }
    public ArrayList<User> getUsers(){
        return users;
    }
}
