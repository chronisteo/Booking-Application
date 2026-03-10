import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class AddRoomDialog extends JDialog {
    private final HotelOwner login_user;
    private final JCheckBox tv;
    private final JCheckBox balcony;
    private final JCheckBox nonSmoking;
    private final JTextField M2;
    private final JTextField Price;
    private final JLabel succ;
    public AddRoomDialog(AddHotelDialog dialog, boolean modality){
        super(dialog,"AddRoom",modality);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,800);
        setLocation(dialog.getX(),dialog.getY());

        setResizable(true);
        login_user= dialog.getLogin_user();

        tv=new JCheckBox("TV");
        balcony=new JCheckBox("Balcony");
        nonSmoking=new JCheckBox("Non-Smoking");

        JLabel m2 = new JLabel("Square Metres:");
        M2=new JTextField("");
        JLabel price = new JLabel("Price:");
        Price=new JTextField("");

        JPanel panel2=new JPanel();
        panel2.setLayout(new GridLayout(0,2));
        panel2.add(m2);
        panel2.add(M2);
        panel2.add(price);
        panel2.add(Price);

        add(panel2,BorderLayout.LINE_END);

        JPanel checkPanel=new JPanel();
        checkPanel.setLayout(new GridLayout(0,1));
        checkPanel.add(tv);
        checkPanel.add(balcony);
        checkPanel.add(nonSmoking);

        TitledBorder border1 = BorderFactory.createTitledBorder("SERVICES");
        checkPanel.setBorder(border1);
        add(checkPanel,BorderLayout.CENTER);

        JRadioButton singleRoom=new JRadioButton("Single Room");
        JRadioButton doubleRoom=new JRadioButton("Double Room");
        JRadioButton familyRoom=new JRadioButton("Family Room");

        ButtonGroup group=new ButtonGroup();
        group.add(singleRoom);
        group.add(doubleRoom);
        group.add(familyRoom);


        JPanel radiopanel=new JPanel(new GridLayout(0,1));
        radiopanel.add(singleRoom);
        radiopanel.add(doubleRoom);
        radiopanel.add(familyRoom);

        TitledBorder border = BorderFactory.createTitledBorder("CHOOSE TYPE OF ROOM");
        radiopanel.setBorder(border);
        add(radiopanel,BorderLayout.PAGE_START);
        succ=new JLabel("");

        JButton button=new JButton("Add Room");
        button.addActionListener(e -> {
            try {
                Integer.parseInt(M2.getText());
                Integer.parseInt(Price.getText());

            }
            catch (NumberFormatException t) {
                succ.setText("M2 or Price should be Integers");
                return;
            }

            if(!singleRoom.isSelected() && !doubleRoom.isSelected() && !familyRoom.isSelected()){
                succ.setText("You haven't choose a type");
                return;
            }
            else if(M2.getText().equals("")|| Price.getText().equals("")){
                succ.setText("You left blank spaces");
                return;
            }
            if(singleRoom.isSelected()){
                for(int i=0;i<login_user.getHotels().size();i++){
                    if(login_user.getHotels().get(i).getName().equals(dialog.getName())){
                        SingleRoom room=new SingleRoom(login_user.getFull_name(),dialog.getName(),Integer.parseInt(M2.getText()),Integer.parseInt(Price.getText()),nonSmoking.isSelected(),balcony.isSelected(),tv.isSelected());
                        room.setNumber(login_user.getHotels().get(i).getHotelRooms().size());
                        login_user.getHotels().get(i).addHotelRoom(room);

                    }
                }
            }
            else if(doubleRoom.isSelected()){
                for(int i=0;i<login_user.getHotels().size();i++){
                    if(login_user.getHotels().get(i).getName().equals(dialog.getName())){
                        DoubleRoom room=new DoubleRoom(login_user.getFull_name(),dialog.getName(),Integer.parseInt(M2.getText()),Integer.parseInt(Price.getText()),nonSmoking.isSelected(),balcony.isSelected(),tv.isSelected());
                        room.setNumber(login_user.getHotels().get(i).getHotelRooms().size());
                        login_user.getHotels().get(i).addHotelRoom(room);

                    }
                }
            }
            else {
                for (int i = 0; i < login_user.getHotels().size(); i++) {
                    if (login_user.getHotels().get(i).getName().equals(dialog.getName())) {
                        FamilyRoom room = new FamilyRoom(login_user.getFull_name(), dialog.getName(), Integer.parseInt(M2.getText()), Integer.parseInt(Price.getText()), nonSmoking.isSelected(), balcony.isSelected(), tv.isSelected());
                        room.setNumber(login_user.getHotels().get(i).getHotelRooms().size());
                        login_user.getHotels().get(i).addHotelRoom(room);

                    }
                }
            }

            dialog.addCount();
            dialog.setlabeRoomSucc("You've added "+dialog.getCount()+" rooms");
            dispose();
        });

        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(0,1));
        panel1.add(button);
        panel1.add(succ);
        add(panel1,BorderLayout.PAGE_END);

        pack();
        setVisible(true);
    }
}


