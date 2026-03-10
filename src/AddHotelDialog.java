import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddHotelDialog extends JDialog {
    private final HotelOwner login_user;
    private final JTextField name;
    private final JTextField loc;
    private final JCheckBox breakfast;
    private final JCheckBox pool;
    private final JCheckBox wifi;
    private final JCheckBox parking;
    private final JCheckBox airConditioning;
    private final JLabel hotelsucc;
    private final JLabel roomsucc;
    private int count;

    public AddHotelDialog(HotelOwnerDialog dialog, boolean modality){
        super(dialog,"AddHotel",modality);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,800);
        setLocation(dialog.getX(),dialog.getY());
        count=0;
        setResizable(true);
        login_user=dialog.getLoginUser();

        JLabel hotelName = new JLabel("HOTEL NAME");
        JLabel location = new JLabel("LOCATION");

        name=new JTextField("");
        loc=new JTextField("");

        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(0,2));
        panel1.add(hotelName);
        panel1.add(name);
        panel1.add(location);
        panel1.add(loc);
        TitledBorder border = BorderFactory.createTitledBorder("BASIC INFO");
        panel1.setBorder(border);
        add(panel1,BorderLayout.PAGE_START);

        breakfast=new JCheckBox("Breakfast");
        pool=new JCheckBox("Pool");
        wifi=new JCheckBox("Wifi");
        parking=new JCheckBox("Parking");
        airConditioning=new JCheckBox("Air Conditioning");

        JPanel checkPanel=new JPanel();
        checkPanel.setLayout(new GridLayout(0,1));
        checkPanel.add(breakfast);
        checkPanel.add(pool);
        checkPanel.add(wifi);
        checkPanel.add(parking);
        checkPanel.add(airConditioning);
        TitledBorder border1 = BorderFactory.createTitledBorder("SERVICES");
        checkPanel.setBorder(border1);
        add(checkPanel,BorderLayout.CENTER);

        JButton addhotel = new JButton("Add Hotel");
        addhotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}1234567890";

                for (int i=0; i < loc.getText().length() ; i++)
                {
                    char ch = loc.getText().charAt(i);
                    if(specialCharactersString.contains(Character.toString(ch))) {
                        hotelsucc.setText("Not right location");
                        return;
                    }

                }
                if(loc.getText().equals("") || name.getText().equals("")){
                    hotelsucc.setText("Blank fields!");
                    return;
                }
                if(hotelsucc.getText().equals("Hotel added,add rooms")){
                    hotelsucc.setText("");
                    return;
                }
                for (int i=0;i<login_user.getHotels().size();i++){
                    if(name.getText().equals(login_user.getHotels().get(i).getName())){
                        hotelsucc.setText("Name already exists");
                        return;
                    }
                }
                count=0;
                login_user.getHotels().add(new Hotel(loc.getText(),name.getText(),breakfast.isSelected(),pool.isSelected(),wifi.isSelected(),parking.isSelected(),airConditioning.isSelected()));
                hotelsucc.setText("Hotel added,add rooms");
            }
        });
        JButton addroom = new JButton("Add Room");
        addroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hotelsucc.getText().equals("Hotel added,add rooms")){
                    openRoomDialog();
                }
                else{
                    roomsucc.setText("Add a proper hotel first");
                }

            }
        });
        roomsucc=new JLabel("");
        hotelsucc=new JLabel("");

        JPanel panel2=new JPanel();
        panel2.setLayout(new GridLayout(0,2,15,10));

        panel2.add(addhotel);
        panel2.add(addroom);
        panel2.add(hotelsucc);
        panel2.add(roomsucc);

        add(panel2,BorderLayout.PAGE_END);
        pack();
        setVisible(true);


    }

    public void addCount(){
        count++;
    }
    public void setlabeRoomSucc(String s){
        roomsucc.setText(s);
    }
    public int getCount() {
        return count;
    }

    public String getName(){
        return name.getText();
    }

    public void openRoomDialog(){
         new AddRoomDialog(this, true);
    }

    public HotelOwner getLogin_user(){
        return login_user;
    }

}
