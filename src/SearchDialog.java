import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchDialog extends JDialog {
    private final JSlider price;
    private final JTextField loc;
    private final ArrayList<User> users;
    private final Customer loginuser;

    public SearchDialog(CustomerDialog dialog, boolean modality){
        super(dialog,"FirstMenu",modality);
        users= dialog.getUsers();
        loginuser= dialog.getLoginUser();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setSize(700,800);
        setLocation(dialog.getX() , dialog.getY() );

        setResizable(true);

        JRadioButton hotels=new JRadioButton("Hotels");
        JRadioButton accommodations=new JRadioButton("Accommodations");

        ButtonGroup group=new ButtonGroup();
        group.add(hotels);
        group.add(accommodations);

        JLabel accommhotel = new JLabel("Select to search between hotels or accommodations");
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(0,1));
        panel.add(accommhotel);
        panel.add(hotels);
        panel.add(accommodations);

        JLabel location = new JLabel("Location:");
        loc=new JTextField("");
        JLabel price1 = new JLabel("Price:");
        price=new JSlider(0,5000);
        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(0,2,5,10));
        panel1.add(location);
        panel1.add(loc);
        panel1.add(price1);
        panel1.add(price);

        price.setPaintTrack(true);
        price.setPaintTicks(true);
        price.setPaintLabels(true);
        price.setMajorTickSpacing(1000);
        price.setMinorTickSpacing(200);
        JLabel succ=new JLabel("");

        JButton proceed = new JButton("Proceed");
        proceed.addActionListener(e -> {
            String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}1234567890";

            for (int i=0; i < loc.getText().length() ; i++)
            {
                char ch = loc.getText().charAt(i);
                if(specialCharactersString.contains(Character.toString(ch))) {
                    succ.setText("Not right location");
                    return;
                }

            }
            if(!hotels.isSelected() && !accommodations.isSelected()){
                succ.setText("Choose accommodations or hotels");
                return;
            }
            if(loc.getText().equals("")){
                succ.setText("Choose a location");
                return;
            }

            if(hotels.isSelected()){
                openSearchHotels();
            }
            else
                openSearchAccommodations();
            dispose();
        });
        JPanel panel2=new JPanel();
        panel2.setLayout(new GridLayout(0,1));
        panel2.add(proceed);
        panel2.add(succ);
        add(panel,BorderLayout.PAGE_START);
        add(panel1,BorderLayout.CENTER);
        add(panel2,BorderLayout.PAGE_END);

        pack();
        setVisible(true);

    }

    public Customer getLoginuser(){
        return loginuser;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public String getLoc(){
        return loc.getText();
    }

    public int getPrice(){
        return price.getValue();
    }
    public void openSearchHotels(){
         new SearchHotelsDialog(this, true);
    }

    public void openSearchAccommodations(){
         new SearchAccommodationsDialog(this, true);
    }
}
