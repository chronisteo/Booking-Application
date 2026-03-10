import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CustomerDialog extends JDialog {

    private final ArrayList<User> users;

    private final Customer loginuser;

    public CustomerDialog(LoginDialog login, boolean modality){
        super(login,"Menu",modality);
        users= login.getUsers();
        loginuser= (Customer) login.getLoginuser();
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

        JMenuItem search = new JMenuItem("Search");
        search.addActionListener(e -> {
            openSearchDialog();
            try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("myfile.bin"))){
                oos.writeObject(users);
            }catch (IOException t){
                t.printStackTrace();
            }
        });
        JMenuItem makecancellation = new JMenuItem("Make a cancellation");
        makecancellation.addActionListener(e -> {
            openMakeCancellationDialog();
            try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("myfile.bin"))){
                oos.writeObject(users);
            }catch (IOException t){
                t.printStackTrace();
            }
        });
        JMenuItem signout = new JMenuItem("Sign Out ");
        signout.addActionListener(e -> dispose());

        JMenuItem cancellations = new JMenuItem("CANCELLATIONS");
        cancellations.addActionListener(e -> openCCancellationsDialog());

        JMenuItem reservations = new JMenuItem("RESERVATIONS");
        reservations.addActionListener(e -> openCReservationsDialog());


        JMenuItem messages = new JMenuItem("MESSAGES");
        messages.addActionListener(e -> openCMessagesDialog());


        JMenuBar bar = new JMenuBar();
        JMenu menu1 = new JMenu("Options1");
        JMenu menu2 = new JMenu("Options2");
        menu1.add(search);
        menu1.add(makecancellation);
        menu1.add(signout);

        menu2.add(cancellations);
        menu2.add(reservations);
        menu2.add(messages);
        bar.add(menu1);
        bar.add(menu2);
        add(bar);
        setJMenuBar(bar);
        pack();
        setVisible(true);
    }

    public Customer getLoginUser(){
        return loginuser;
    }
    public ArrayList<User> getUsers(){return users;}
    public void openCMessagesDialog(){
        new CMessagesDialog(this, true);
    }
    public void openSearchDialog(){
         new SearchDialog(this, true);
    }
    public void openMakeCancellationDialog(){
         new MakeCancellationDialog(this, true);
    }
    public void openCCancellationsDialog(){
         new CCancellationsDialog(this, true);
    }
    public void openCReservationsDialog(){
         new CReservationsDialog(this, true);
    }

}