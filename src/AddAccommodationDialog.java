import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class AddAccommodationDialog extends JDialog {
    private final AccommodationOwner login_user;
    private final JTextField name;
    private int choice;

    public AddAccommodationDialog(AccommodationOwnerDialog dialog, boolean modality){
        super(dialog,"AddAccommodation",modality);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,800);
        setLocation(dialog.getX(),dialog.getY());

        setResizable(true);
        login_user=dialog.getLoginUser();

        JLabel hotelName=new JLabel("ACCOMMODATION NAME:");
        JLabel location=new JLabel("LOCATION:");
        JLabel M2=new JLabel("SQUARE METRES:");
        JLabel Price=new JLabel("PRICE:");
        JTextField m2=new JTextField("");
        JTextField price=new JTextField("");
        name=new JTextField("");
        JTextField loc=new JTextField("");

        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(0,2));
        panel1.add(hotelName);
        panel1.add(name);
        panel1.add(location);
        panel1.add(loc);
        panel1.add(M2);
        panel1.add(m2);
        panel1.add(Price);
        panel1.add(price);

        TitledBorder border1 = BorderFactory.createTitledBorder("BASIC INFO");
        panel1.setBorder(border1);
        add(panel1,BorderLayout.PAGE_START);

        JRadioButton apartment=new JRadioButton("Apartment");
        apartment.addActionListener(e -> choice=1);
        JRadioButton maisonette=new JRadioButton("Maisonette");
        maisonette.addActionListener(e -> choice=2);
        JRadioButton villa=new JRadioButton("Villa");
        villa.addActionListener(e -> choice=3);
        ButtonGroup group=new ButtonGroup();
        group.add(apartment);
        group.add(maisonette);
        group.add(villa);

        JPanel radiopanel=new JPanel(new GridLayout(0,1));
        radiopanel.add(apartment);
        radiopanel.add(maisonette);
        radiopanel.add(villa);

        TitledBorder border = BorderFactory.createTitledBorder("CHOOSE TYPE OF ACCOMMODATION");
        radiopanel.setBorder(border);
        add(radiopanel,BorderLayout.CENTER);



        JLabel addsucc=new JLabel("");
        JButton addaccomm=new JButton("Press to proceed to services");
        addaccomm.addActionListener(e -> {
            String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}1234567890";

            for (int i=0; i < loc.getText().length() ; i++)
            {
                char ch = loc.getText().charAt(i);
                if(specialCharactersString.contains(Character.toString(ch))) {
                    addsucc.setText("Not right location");
                    return;
                }

            }
            try {
                Integer.parseInt(m2.getText());
                Integer.parseInt(price.getText());

            }
            catch (NumberFormatException t) {
                addsucc.setText("M2 or Price should be Integers");
                return;
            }

            if(m2.getText().equals("")|| price.getText().equals("")|| loc.getText().equals("")|| name.getText().equals("")){
                addsucc.setText("Blank fields!");
                return;
            }
            if(!apartment.isSelected() && !maisonette.isSelected() && !villa.isSelected()){
                addsucc.setText("Choose a type first");
                return;
            }
            for(Accommodation accommodation:login_user.getAccommodations()){
                if(name.getText().equals(accommodation.getName())){
                    addsucc.setText("Accommodation with same name already exists");
                    return;
                }
            }
            if(apartment.isSelected()){
                Apartment apartment1=new Apartment(loc.getText(),login_user.getFull_name(),name.getText(),Integer.parseInt(m2.getText()),Integer.parseInt(price.getText()),false,false,false,0);
                login_user.getAccommodations().add(apartment1);
            }else if(maisonette.isSelected()){
                Maisonette maisonette1=new Maisonette(loc.getText(),login_user.getFull_name(),name.getText(),Integer.parseInt(m2.getText()),Integer.parseInt(price.getText()),false,false,false,false);
                login_user.getAccommodations().add(maisonette1);
            }else{
                Villa villa1=new Villa(loc.getText(),login_user.getFull_name(),name.getText(),Integer.parseInt(m2.getText()),Integer.parseInt(price.getText()),false,false,false,false,false );
                login_user.getAccommodations().add(villa1);
            }
            addsucc.setText("Accommodation added");
            openAccomServicesDialog();
            dispose();
            addsucc.setText("");
        });


        JPanel panel3=new JPanel();
        panel3.setLayout(new GridLayout(0,1));
        panel3.add(addaccomm);
        panel3.add(addsucc);
        add(panel3,BorderLayout.PAGE_END);

        pack();
        setVisible(true);
    }

    public void openAccomServicesDialog(){
        new AccomServicesDialog(this,true);
    }

    public int getChoice(){
        return choice;
    }

    public AccommodationOwner getLogin_user(){
        return login_user;
    }
    public String getName(){
        return name.getText();
    }
}
