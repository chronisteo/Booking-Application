import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class AccommodationsDialog extends JDialog {

    public AccommodationsDialog(AccommodationOwnerDialog dialog,boolean modality) {
        super(dialog, "Hotels", modality);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 800);
        setLocation(dialog.getX(), dialog.getY());

        setResizable(false);

        AccommodationOwner login_user = dialog.getLoginUser();

        DefaultMutableTreeNode accommodations = new DefaultMutableTreeNode("Accommodations");
        DefaultMutableTreeNode k1;
        DefaultMutableTreeNode k2;

        for (Accommodation accommodation : login_user.getAccommodations()) {
            k1 = new DefaultMutableTreeNode(accommodation.getName());
            accommodations.add(k1);
            k2 = new DefaultMutableTreeNode("Accommodation Services");
            k1.add(k2);
            k1.add(new DefaultMutableTreeNode((accommodation.getM2())+" square metres"));
            k1.add(new DefaultMutableTreeNode("Price: "+accommodation.getPrice()));
            if(accommodation.getWifi())
                k2.add(new DefaultMutableTreeNode("WIFI"));
            if(accommodation.getAirConditioning())
                k2.add(new DefaultMutableTreeNode("Air Conditioning"));
            if(accommodation.getParking())
                k2.add(new DefaultMutableTreeNode("Parking"));
            if(accommodation instanceof Villa){
                if(((Villa) accommodation).getPool())
                    k2.add(new DefaultMutableTreeNode("Pool"));
                if(((Villa) accommodation).getGarden())
                    k2.add(new DefaultMutableTreeNode("Garden"));
            }
            if(accommodation instanceof Maisonette){
                if(((Maisonette) accommodation).getGarden())
                    k2.add(new DefaultMutableTreeNode("Garden"));
            }
            if(accommodation instanceof Apartment){
                k2.add(new DefaultMutableTreeNode("Floor: "+(((Apartment) accommodation).getFloor())));
            }


        }
        JTree accommodationtree = new JTree(accommodations);
        add(accommodationtree, BorderLayout.CENTER);
        //pack();
        setVisible(true);

    }
}