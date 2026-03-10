import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AdminDialog extends JDialog {

    private final Admin loginuser;
    private final ArrayList<User> users;

    public AdminDialog(LoginDialog login, boolean modality){
        super(login,"Menu",modality);

        loginuser=(Admin) login.getLoginuser();
        users=login.getUsers();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setSize(700,800);
        setLocation(login.getX() , login.getY() );

        setResizable(false);
        JLabel fullname=new JLabel("FULLNAME:");
        JLabel name=new JLabel(loginuser.getFull_name());
        JLabel username =new JLabel("USERNAME:");
        JLabel user_name=new JLabel(loginuser.getUsername());
        JLabel password=new JLabel("PASSWORD:");
        JLabel pass_word=new JLabel(loginuser.getPassword());
        JLabel address =new JLabel("ADDRESS:");
        JLabel add_ress=new JLabel(loginuser.getAddress());

        JPanel panel1=new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder(" BASIC INFO");
        panel1.setBorder(border);
        GridLayout grid = new GridLayout(0, 2, 10, 20);
        panel1.setLayout(grid);

        panel1.add(fullname);
        panel1.add(name);
        panel1.add(username);
        panel1.add(user_name);
        panel1.add(password);
        panel1.add(pass_word);
        panel1.add(address);
        panel1.add(add_ress);
        add(panel1,BorderLayout.PAGE_START);


        JMenuItem showUsers = new JMenuItem("SHOW USERS");
        showUsers.addActionListener(e -> openShowUsersDialog());
        JMenuItem sendMessage = new JMenuItem("SEND MESSAGE");
        sendMessage.addActionListener(e -> {
            openSendMessageDialog();
            try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("myfile.bin"))){
                oos.writeObject(users);
            }catch (IOException t){
                t.printStackTrace();
            }
        });
        JMenuItem showReservations = new JMenuItem("SHOW RESERVATIONS");
        showReservations.addActionListener(e -> openShowReservationsDialog());
        JMenuItem signOut = new JMenuItem("SIGN OUT");
        signOut.addActionListener(e -> dispose());

        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        menu.add(showUsers);
        menu.add(sendMessage);
        menu.add(showReservations);
        menu.add(signOut);
        bar.add(menu);
        add(bar);
        setJMenuBar(bar);
        pack();



        setVisible(true);
    }

    public void openShowUsersDialog(){
        new ShowUsersDialog(this, true);
    }
    public void openShowReservationsDialog(){
         new ShowReservationsDialog(this, true);
    }
    public void openSendMessageDialog(){
         new SendMessageDialog(this, true);
    }

    public Admin getLoginUser() {
        return loginuser;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
