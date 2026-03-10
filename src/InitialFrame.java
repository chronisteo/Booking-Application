import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class InitialFrame extends JFrame implements Serializable {

    private final ArrayList<User> users;


    public InitialFrame(ArrayList<User> users){
        this.users=users;
        setTitle("MyBooking");
        setSize(300,400 );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JButton signin = new JButton("SIGN IN");
        JButton signup = new JButton("SIGN UP");
        JButton exit = new JButton("EXIT");

        JPanel panel1=new JPanel();
        signin.addActionListener(e -> openLogin());

        signup.addActionListener(e -> openRegistration());

        exit.addActionListener(e -> System.exit(0));



        panel1.add(signin);
        panel1.add(signup);
        panel1.add(exit);

        add(panel1, BorderLayout.CENTER);

        setVisible(true);
    }

    public ArrayList <User> getUsers(){
        return users;
    }

    public void openLogin(){
         new LoginDialog(this, true);
    }

    public void openRegistration(){
         new RegistrationDialog(this, true);
    }

}
