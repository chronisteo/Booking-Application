import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;


public class HotelsDialog extends JDialog {

    public HotelsDialog(HotelOwnerDialog dialog, boolean modality){
        super(dialog,"Hotels",modality);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,800);
        setLocation(dialog.getX(),dialog.getY() );

        setResizable(false);

        HotelOwner login_user = dialog.getLoginUser();

        DefaultMutableTreeNode hotels=new DefaultMutableTreeNode("Hotels");
        DefaultMutableTreeNode k1;
        DefaultMutableTreeNode k2;
        DefaultMutableTreeNode k3;
        DefaultMutableTreeNode k4;
        for(Hotel hotel: login_user.getHotels()){
            k1=new DefaultMutableTreeNode(hotel.getName());
            hotels.add(k1);
            k2=new DefaultMutableTreeNode("Hotel Services");
            k1.add(k2);
            k3=new DefaultMutableTreeNode("Hotel Rooms");
            k1.add(k3);

            if(hotel.getBreakfast())
                k2.add(new DefaultMutableTreeNode("Breakfast"));
            if(hotel.getParking())
                k2.add(new DefaultMutableTreeNode("Parking"));
            if(hotel.getAirConditioning())
                k2.add(new DefaultMutableTreeNode("Air Conditioning"));
            if(hotel.getPool())
                k2.add(new DefaultMutableTreeNode("Pool"));
            if(hotel.getWifi())
                k2.add(new DefaultMutableTreeNode("Wifi"));


            for(HotelRoom room: hotel.getHotelRooms()){

                if(room instanceof SingleRoom){
                    k4=new DefaultMutableTreeNode("Single Room");
                    k3.add(k4);
                    if(room.getBalcony())
                        k4.add(new DefaultMutableTreeNode("Balcony"));
                    if(room.getNonSmoking())
                        k4.add(new DefaultMutableTreeNode("Non-Smoking"));
                    if(room.getTv())
                        k4.add(new DefaultMutableTreeNode("TV"));

                }
                else if(room instanceof DoubleRoom){

                    k4=new DefaultMutableTreeNode("Double Room");
                    k3.add(k4);
                    if(room.getBalcony())
                        k4.add(new DefaultMutableTreeNode("Balcony"));
                    if(room.getNonSmoking())
                        k4.add(new DefaultMutableTreeNode("Non-Smoking"));
                    if(room.getTv())
                        k4.add(new DefaultMutableTreeNode("TV"));
                }
                else{
                    k4=new DefaultMutableTreeNode("Family Room");
                    k3.add(k4);
                    if(room.getBalcony())
                        k4.add(new DefaultMutableTreeNode("Balcony"));
                    if(room.getNonSmoking())
                        k4.add(new DefaultMutableTreeNode("Non-Smoking"));
                    if(room.getTv())
                        k4.add(new DefaultMutableTreeNode("TV"));
                }


            }


        }
        JTree hoteltree = new JTree(hotels);
        add(hoteltree, BorderLayout.CENTER);
        //pack();
        setVisible(true);

    }
}
