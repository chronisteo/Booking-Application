import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

public class SearchHotelsDialog extends JDialog {
    private final ArrayList<User> users;
    private final Customer loginuser;
    private final int price;
    private String hname;
    public SearchHotelsDialog(SearchDialog dialog, boolean modality){
        super(dialog,"SearchHotelsMenu",modality);
        users= dialog.getUsers();
        loginuser= dialog.getLoginuser();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setSize(700,800);
        setLocation(dialog.getX() , dialog.getY() );
        price=dialog.getPrice();
        String[] columnNames={"NAME","WIFI","PARKING","AIR CONDITIONING","POOL","BREAKFAST"};
        int counter=0;
        for(int i=0;i<dialog.getUsers().size();i++){
            if(dialog.getUsers().get(i) instanceof HotelOwner){
                for(int j = 0; j<((HotelOwner) dialog.getUsers().get(i)).getHotels().size(); j++) {
                    if(((HotelOwner) dialog.getUsers().get(i)).getHotels().get(j).getLocation().equals(dialog.getLoc()))
                        counter++;
                }
            }
        }
        String[][] data=new String[counter][6];

        counter=0;
        for(int i=0;i<dialog.getUsers().size();i++) {
            if (dialog.getUsers().get(i) instanceof HotelOwner) {
                for (int j = 0; j < ((HotelOwner) dialog.getUsers().get(i)).getHotels().size(); j++) {
                    if (((HotelOwner) dialog.getUsers().get(i)).getHotels().get(j).getLocation().equals(dialog.getLoc())){
                        data[counter][0]=((HotelOwner) dialog.getUsers().get(i)).getHotels().get(j).getName();
                        if(((HotelOwner) dialog.getUsers().get(i)).getHotels().get(j).getWifi())
                            data[counter][1]="INCLUDED";
                        else
                            data[counter][1]="NOT INCLUDED";
                        if(((HotelOwner) dialog.getUsers().get(i)).getHotels().get(j).getParking())
                            data[counter][2]="INCLUDED";
                        else
                            data[counter][2]="NOT INCLUDED";
                        if(((HotelOwner) dialog.getUsers().get(i)).getHotels().get(j).getAirConditioning())
                            data[counter][3]="INCLUDED";
                        else
                            data[counter][3]="NOT INCLUDED";
                        if(((HotelOwner) dialog.getUsers().get(i)).getHotels().get(j).getPool())
                            data[counter][4]="INCLUDED";
                        else
                            data[counter][4]="NOT INCLUDED";
                        if(((HotelOwner) dialog.getUsers().get(i)).getHotels().get(j).getBreakfast())
                            data[counter][5]="INCLUDED";
                        else
                            data[counter][5]="NOT INCLUDED";

                    }
                    counter++;

                }
            }
        }

        TableModel model = new DefaultTableModel(data, columnNames)
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;//This causes all cells to be not editable
            }
        };

        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.PAGE_START);
        table.setEnabled(true);

        JLabel label=new JLabel("");


        JButton proceed = new JButton("Proceed to select Room");
        proceed.addActionListener(e -> {
            if(table.getSelectedRow()==-1){
                label.setText("YOU HAVE NOT SELECTED A HOTEL");
                return;
            }
            hname=data[table.getSelectedRow()][0];
            openSearchRoomDialog();
            dispose();
        });
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(0,1));
        panel.add(proceed);
        panel.add(label);
        add(panel,BorderLayout.PAGE_END);
        pack();
        setResizable(true);
        setVisible(true);
    }

    public void openSearchRoomDialog(){
         new SearchRoomDialog(this, true);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public Customer getLoginuser() {
        return loginuser;
    }

    public int getPrice(){
        return price;
    }
    public String getHname(){
        return hname;
    }
}
