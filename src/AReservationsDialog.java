import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AReservationsDialog extends JDialog {

    public AReservationsDialog(AccommodationOwnerDialog dialog, boolean modality){
        super(dialog,"Reservations",modality);
        AccommodationOwner login_user = dialog.getLoginUser();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,800);
        setLocation(dialog.getX(),dialog.getY() );

        setResizable(false);


        String[] columnNames={"CustomerName","CheckIn-CheckOut","AccommodationName"};
        String[][] data=new String[login_user.getProviderReservations().size()][3];
        for(int i = 0; i< login_user.getProviderReservations().size(); i++){
            data[i][0]= login_user.getProviderReservations().get(i).getCustomerName();
            data[i][1]= login_user.getProviderReservations().get(i).getCheckIn().toString()+"--->"+ login_user.getProviderReservations().get(i).getCheckOut().toString();
            data[i][2]= login_user.getProviderReservations().get(i).getBuilding().getName();
        }

        DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);

        JTable table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);



        //pack();
        setVisible(true);
    }
}
