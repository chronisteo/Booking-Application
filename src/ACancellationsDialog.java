import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ACancellationsDialog extends JDialog {


    public ACancellationsDialog(AccommodationOwnerDialog dialog, boolean modality){
        super(dialog,"Cancellations",modality);
        AccommodationOwner login_user=dialog.getLoginUser();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,800);
        setLocation(dialog.getX(),dialog.getY() );

        setResizable(false);

        String[] columnNames={"CustomerName","CheckIn-CheckOut","AccommodationName"};
        String[][] data=new String[login_user.getProviderCancellations().size()][3];
        for(int i=0;i<login_user.getProviderCancellations().size();i++){
            data[i][0]=login_user.getProviderCancellations().get(i).getCustomerName();
            data[i][1]=login_user.getProviderCancellations().get(i).getCheckIn().toString()+"--->"+login_user.getProviderCancellations().get(i).getCheckOut().toString();
            data[i][2]=login_user.getProviderCancellations().get(i).getBuilding().getName();
        }

        DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);

        JTable table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);



        //pack();
        setVisible(true);
    }
}

