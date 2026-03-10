import javax.swing.*;
import java.awt.*;

public class AccomServicesDialog extends JDialog {
    private final AccommodationOwner login_user;
    private final JCheckBox wifi;
    private final JCheckBox parking;
    private final JCheckBox airConditioning;
    private JCheckBox garden;
    private JCheckBox pool;
    private JTextField floor=new JTextField("");
    JButton services;
    private final JLabel succ;
    public AccomServicesDialog(AddAccommodationDialog dialog, boolean modality){
        super(dialog,"AddServices",modality);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,800);
        setLocation(dialog.getX(),dialog.getY());
        setResizable(true);

        login_user=dialog.getLogin_user();
        if(dialog.getChoice()==1){
            wifi=new JCheckBox("WIFI");
            parking=new JCheckBox("Parking");
            airConditioning=new JCheckBox("Air Conditioning");
            JLabel floor1 = new JLabel("Floor: ");
            //floor=new JTextField("");

            JPanel panel=new JPanel();
            JPanel panel2=new JPanel();
            panel2.setLayout(new GridLayout(0,2));
            panel2.add(floor1);
            panel2.add(floor);
            add(panel2,BorderLayout.PAGE_START);
            panel.setLayout(new GridLayout(0,1));
            panel.add(wifi);
            panel.add(parking);
            panel.add(airConditioning);
            add(panel,BorderLayout.CENTER);
        }else if(dialog.getChoice()==2){
            wifi=new JCheckBox("WIFI");
            parking=new JCheckBox("Parking");
            airConditioning=new JCheckBox("Air Conditioning");
            garden=new JCheckBox("Garden");

            JPanel panel=new JPanel();


            panel.setLayout(new GridLayout(0,1));
            panel.add(wifi);
            panel.add(parking);
            panel.add(airConditioning);
            panel.add(garden);
            add(panel,BorderLayout.CENTER);
        }
        else{
            wifi=new JCheckBox("WIFI");
            parking=new JCheckBox("Parking");
            airConditioning=new JCheckBox("Air Conditioning");
            garden=new JCheckBox("Garden");
            pool=new JCheckBox("Pool");
            JPanel panel=new JPanel();


            panel.setLayout(new GridLayout(0,1));
            panel.add(wifi);
            panel.add(parking);
            panel.add(airConditioning);
            panel.add(garden);
            panel.add(pool);
            add(panel,BorderLayout.CENTER);
        }
        succ=new JLabel("");
        services=new JButton("Add services");
        services.addActionListener((e)-> {

            if(dialog.getChoice()==1){
                try {
                    Integer.parseInt(floor.getText());

                }
                catch (NumberFormatException t) {
                    succ.setText("Floor should be Integer");
                    return;
                }
                for(Accommodation accommodation:login_user.getAccommodations()){
                    if(accommodation.getName().equals(dialog.getName())){
                        accommodation.setAirConditioning(airConditioning.isSelected());
                        accommodation.setParking(parking.isSelected());
                        accommodation.setWifi(wifi.isSelected());
                        ((Apartment) accommodation).setFloor(Integer.parseInt(floor.getText()));

                    }
                }
            }else if(dialog.getChoice()==2){
                for(Accommodation accommodation:login_user.getAccommodations()){
                    if(accommodation.getName().equals(dialog.getName())){
                        accommodation.setAirConditioning(airConditioning.isSelected());
                        accommodation.setParking(parking.isSelected());
                        accommodation.setWifi(wifi.isSelected());
                        if(accommodation instanceof DetachedHouse)
                            ((DetachedHouse) accommodation).setGarden(garden.isSelected());
                    }
                }
            }else{
                for(Accommodation accommodation:login_user.getAccommodations()){
                    if(accommodation.getName().equals(dialog.getName())){
                        accommodation.setAirConditioning(airConditioning.isSelected());
                        accommodation.setParking(parking.isSelected());
                        accommodation.setWifi(wifi.isSelected());
                        if(accommodation instanceof DetachedHouse)
                            ((DetachedHouse) accommodation).setGarden(garden.isSelected());
                        if(accommodation instanceof Villa)
                            ((Villa) accommodation).setPool(pool.isSelected());
                    }
                }
            }
            dispose();

        });
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(0,1));
        panel.add(services);
        panel.add(succ);
        add(panel,BorderLayout.PAGE_END);
        pack();
        setVisible(true);
    }
}
