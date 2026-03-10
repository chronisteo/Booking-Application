import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MakeCancellationDialog extends JDialog {

    public MakeCancellationDialog(CustomerDialog dialog, boolean modality){
        super(dialog,"MakeCancellation",modality);
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
        table.setEnabled(true);

        JPanel panel=new JPanel(new GridLayout(0,1));
        JLabel label=new JLabel("");
        JButton button=new JButton("CANCEL SELECTED RESERVATION");
        panel.add(button);
        panel.add(label);
        add(panel,BorderLayout.PAGE_END);

        button.addActionListener(e -> {
            if (table.getSelectedRow() == -1)
                label.setText("SELECT A RESERVATION FIRST");
            else {
                    dialog.getLoginUser().makeCancellation(dialog.getUsers(),table.getSelectedRow());
                    dispose();

            }

        });



        //pack();
        setVisible(true);

    }
}