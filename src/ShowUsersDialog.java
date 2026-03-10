import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowUsersDialog extends JDialog {

    public ShowUsersDialog(AdminDialog dialog, boolean modality){
        super(dialog,"ShowUsers",modality);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,800);
        setLocation(dialog.getX(),dialog.getY() );

        setResizable(true);

        String[] columnNames={"FULLNAME","USERNAME","PASSWORD","ADDRESS","TYPE OF USER"};
        String[][] data=new String[dialog.getUsers().size()][5];

        for(int i=0;i<dialog.getUsers().size();i++){
            data[i][0]=dialog.getUsers().get(i).getFull_name();
            data[i][1]=dialog.getUsers().get(i).getUsername();
            data[i][2]=dialog.getUsers().get(i).getPassword();
            if(dialog.getUsers().get(i) instanceof HotelOwner) {
                data[i][3] = ((HotelOwner) dialog.getUsers().get(i)).getAddress();
                data[i][4]="HOTEL OWNER";
            }
            else if(dialog.getUsers().get(i) instanceof AccommodationOwner) {
                data[i][3] = ((AccommodationOwner) dialog.getUsers().get(i)).getAddress();
                data[i][4]="ACCOMMODATION OWNER";
            }
            else if(dialog.getUsers().get(i) instanceof Customer) {
                data[i][3] = ((Customer) dialog.getUsers().get(i)).getAddress();
                data[i][4]="CUSTOMER";
            }
            else if(dialog.getUsers().get(i) instanceof Admin) {
                data[i][3] = ((Admin) dialog.getUsers().get(i)).getAddress();
                data[i][4]="ADMIN";
            }

        }

        DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);

        JTable table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);
        table.setEnabled(false);


        setVisible(true);

    }
}
