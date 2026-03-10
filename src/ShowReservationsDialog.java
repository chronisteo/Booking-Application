import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowReservationsDialog extends JDialog {
    public ShowReservationsDialog(AdminDialog dialog, boolean modality){
        super(dialog,"ShowReservations",modality);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,800);
        setLocation(dialog.getX(),dialog.getY() );

        setResizable(false);

        int c=0;
        for(int i=0;i<dialog.getUsers().size();i++){
            if(dialog.getUsers().get(i) instanceof Customer)
                for(int j = 0; j<((Customer) dialog.getUsers().get(i)).getReservations().size(); j++)
                   c++;
        }

        String[] columnNames={"CustomerName","CheckIn-CheckOut","HotelName"};
        String[][] data=new String[c][3];
        int counter=0;
        for(int i=0;i<dialog.getUsers().size();i++) {
            if(dialog.getUsers().get(i) instanceof Customer) {
                for(int j = 0; j<((Customer) dialog.getUsers().get(i)).getReservations().size(); j++) {
                    data[counter][0] = dialog.getUsers().get(i).getFull_name();
                    data[counter][1] = ((Customer) dialog.getUsers().get(i)).getReservations().get(j).getCheckIn().toString() + "--->" + ((Customer) dialog.getUsers().get(i)).getReservations().get(j).getCheckOut().toString();
                    data[counter][2] = ((Customer) dialog.getUsers().get(i)).getReservations().get(j).getBuilding().getName();
                    counter++;
                }
            }
        }

        DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);

        JTable table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);
        table.setEnabled(false);



        //pack();
        setVisible(true);
    }
}
