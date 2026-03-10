import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CReservationsDialog extends JDialog{

    public CReservationsDialog(CustomerDialog dialog, boolean modality){
        super(dialog,"ShowReservations",modality);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,800);
        setLocation(dialog.getX(),dialog.getY() );

        setResizable(false);

        int c=0;
        for(int i=0;i<dialog.getLoginUser().getReservations().size();i++){
            c++;
        }

        String[] columnNames={"CustomerName","CheckIn-CheckOut","HotelName"};
        String[][] data=new String[c][3];

        for(int i = 0; i<dialog.getLoginUser().getReservations().size(); i++) {
            data[i][0] = dialog.getLoginUser().getFull_name();
            data[i][1] = dialog.getLoginUser().getReservations().get(i).getCheckIn().toString() + "--->" + dialog.getLoginUser().getReservations().get(i).getCheckOut().toString();
            data[i][2] =  dialog.getLoginUser().getReservations().get(i).getBuilding().getName();
        }



        DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);

        JTable table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);
        table.setEnabled(false);



        //pack();
        setVisible(true);
    }
}
