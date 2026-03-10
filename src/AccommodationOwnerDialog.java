import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class AccommodationOwnerDialog extends JDialog{
    private final ArrayList<User> users;
    private final AccommodationOwner loginuser;

    public AccommodationOwnerDialog(LoginDialog login, boolean modality){
        super(login,"Menu",modality);
        users= login.getUsers();
        loginuser=(AccommodationOwner) login.getLoginuser();
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

        JMenuItem add=new JMenuItem("Add an accommodation");
        add.addActionListener((e)-> {

                openAddAccommodationDialog();
                try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("myfile.bin"))){
                    oos.writeObject(users);
                }catch (IOException t){
                    t.printStackTrace();
                }

        });
        JMenuItem remove=new JMenuItem("Remove an accommodation");
        remove.addActionListener((e)-> {
                openRemoveAccommodationDialog();
                try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("myfile.bin"))){
                    oos.writeObject(users);
                }catch (IOException t){
                    t.printStackTrace();
                }

        });
        JMenuItem signout=new JMenuItem("Sign out ");
        signout.addActionListener(e -> dispose());

        JMenuItem cancellations=new JMenuItem("CANCELLATIONS");
        cancellations.addActionListener(e -> openCancellationsDialog());

        JMenuItem reservations=new JMenuItem("RESERVATIONS");
        reservations.addActionListener(e -> openReservationsDialog());

       JMenuItem accommodations=new JMenuItem("SHOW ACCOMMODATIONS");
        accommodations.addActionListener(e -> openAccommodationsDialog());

        JMenuItem messages=new JMenuItem("MESSAGES");
        messages.addActionListener(e -> openMessagesDialog());





        JMenuBar bar=new JMenuBar();
        JMenu menu1=new JMenu("Options1");
        JMenu menu2=new JMenu("Options2");
        menu1.add(add);
        menu1.add(remove);
        menu1.add(signout);
        menu2.add(accommodations);
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

    public AccommodationOwner getLoginUser(){
        return loginuser;
    }
    public void openAccommodationsDialog(){
        new AccommodationsDialog(this,true);
    }
    public void openMessagesDialog(){
         new AMessagesDialog(this,true);
    }
    public void openCancellationsDialog(){
        new ACancellationsDialog(this,true);
    }
    public void openReservationsDialog(){
        new AReservationsDialog(this,true);
    }
    public void openAddAccommodationDialog(){
        new AddAccommodationDialog(this,true);
    }
    public void openRemoveAccommodationDialog(){
       new RemoveAccommodationDialog(this,true);
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
