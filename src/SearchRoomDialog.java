import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

public class SearchRoomDialog extends JDialog {
    private final ArrayList<User> users;
    private final Customer loginuser;
    JButton res;
    JLabel arrival;
    JLabel departure;
    JTextField arrival1;
    JTextField departure1;
    JButton choose1;
    JButton choose2;
    JLabel label;

    public SearchRoomDialog(SearchHotelsDialog dialog, boolean modality) {
        super(dialog, "SearchRoomsMenu", modality);
        users = dialog.getUsers();
        loginuser = dialog.getLoginuser();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setSize(700,800);
        setLocation(dialog.getX(), dialog.getY());

        label = new JLabel("");

        arrival = new JLabel("ARRIVAL DATE");
        departure = new JLabel("DEPARTURE DATE");
        arrival1 = new JTextField("");
        arrival1.setEditable(false);
        departure1 = new JTextField("");
        departure1.setEditable(false);
        choose1 = new JButton("POP-UP");
        choose1.addActionListener(e -> openArrival());
        choose2 = new JButton("POP-UP");
        choose2.addActionListener(e -> openDeparture());
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(0, 3));
        panel1.add(arrival);
        panel1.add(arrival1);
        panel1.add(choose1);
        panel1.add(departure);
        panel1.add(departure1);
        panel1.add(choose2);
        add(panel1, BorderLayout.CENTER);


        String[] columnNames = {"TYPE","NON SMOKING", "BALCONY", "TV","ROOM NUMBER"};
        int counter = 0;
        for (int i = 0; i < dialog.getUsers().size(); i++) {
            if (dialog.getUsers().get(i) instanceof HotelOwner) {
                for (int j = 0; j < ((HotelOwner) dialog.getUsers().get(i)).getHotels().size(); j++) {
                    if (((HotelOwner) dialog.getUsers().get(i)).getHotels().get(j).getName().equals(dialog.getHname()))
                        for (HotelRoom room : ((HotelOwner) dialog.getUsers().get(i)).getHotels().get(j).getHotelRooms()) {
                            if (room.getPrice() <= dialog.getPrice())
                                counter++;
                        }

                }
            }
        }
        String[][] data = new String[counter][5];

        counter = 0;
        for (int i = 0; i < dialog.getUsers().size(); i++) {
            if (dialog.getUsers().get(i) instanceof HotelOwner) {
                for (int j = 0; j < ((HotelOwner) dialog.getUsers().get(i)).getHotels().size(); j++) {
                    if (((HotelOwner) dialog.getUsers().get(i)).getHotels().get(j).getName().equals(dialog.getHname())) {
                        for (HotelRoom room : ((HotelOwner) dialog.getUsers().get(i)).getHotels().get(j).getHotelRooms()) {
                            if (room.getPrice() <= dialog.getPrice()) {
                                if (room instanceof SingleRoom) {
                                    data[counter][0]="SINGLE ROOM";
                                    if(room.getNonSmoking())
                                        data[counter][1]="INCLUDED";
                                    else
                                        data[counter][1]="NOT INCLUDED";
                                    if(room.getBalcony())
                                        data[counter][2]="INCLUDED";
                                    else
                                        data[counter][2]="NOT INCLUDED";
                                    if(room.getTv())
                                        data[counter][3]="INCLUDED";
                                    else
                                        data[counter][3]="NOT INCLUDED";
                                    data[counter][4]=String.valueOf(room.getNumber());
                                    counter++;
                                }else if(room instanceof DoubleRoom){
                                    data[counter][0]="DOUBLE ROOM";
                                    if(room.getNonSmoking())
                                        data[counter][1]="INCLUDED";
                                    else
                                        data[counter][1]="NOT INCLUDED";
                                    if(room.getBalcony())
                                        data[counter][2]="INCLUDED";
                                    else
                                        data[counter][2]="NOT INCLUDED";
                                    if(room.getTv())
                                        data[counter][3]="INCLUDED";
                                    else
                                        data[counter][3]="NOT INCLUDED";
                                    data[counter][4]=String.valueOf(room.getNumber());
                                    counter++;
                                }else{
                                    data[counter][0]="FAMILY ROOM";
                                    if(room.getNonSmoking())
                                        data[counter][1]="INCLUDED";
                                    else
                                        data[counter][1]="NOT INCLUDED";
                                    if(room.getBalcony())
                                        data[counter][2]="INCLUDED";
                                    else
                                        data[counter][2]="NOT INCLUDED";
                                    if(room.getTv())
                                        data[counter][3]="INCLUDED";
                                    else
                                        data[counter][3]="NOT INCLUDED";
                                    data[counter][4]=String.valueOf(room.getNumber());
                                    counter++;
                                }
                            }


                        }
                    }
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

        res=new JButton("MAKE RESERVATION");
        res.addActionListener(e -> {
            if(table.getSelectedRow()==-1){
                label.setText("YOU HAVE NOT SELECTED A ROOM");
                return;
            }
            if(arrival1.getText().equals("") || (departure1.getText().equals(""))){
                label.setText("YOU HAVE NOT SELECTED NEITHER ARRIVAL NOR DEPARTURE DATE");
                return;
            }
            int d1,d2,m1,m2,y1,y2;
            String[] dates1=arrival1.getText().split("-");
            String[] dates2=departure1.getText().split("-");
            d1=Integer.parseInt(dates1[0]);
            m1=Integer.parseInt(dates1[1]);
            y1=Integer.parseInt(dates1[2]);

            d2=Integer.parseInt(dates2[0]);
            m2=Integer.parseInt(dates2[1]);
            y2=Integer.parseInt(dates2[2]);

            Date date1=new Date(d1,m1,y1);
            Date date2=new Date(d2,m2,y2);

            if(date2.lessThan(date1) || date2.isEquals(date1)){
                label.setText("WRONG DATES");
                return;
            }

            int row=table.getSelectedRow();

            for(int i=0;i<dialog.getUsers().size();i++){
                if(dialog.getUsers().get(i) instanceof HotelOwner) {
                    for (int j = 0; j < ((HotelOwner) dialog.getUsers().get(i)).getHotels().size();j++){
                        if(((HotelOwner) dialog.getUsers().get(i)).getHotels().get(j).getName().equals(dialog.getHname())){
                            for(HotelRoom room:((HotelOwner) dialog.getUsers().get(i)).getHotels().get(j).getHotelRooms()){
                                if(room.getNumber()==Integer.parseInt(data[row][4])){
                                    if(!room.isReserved(date1,date2))
                                        loginuser.makeReservation(date1,date2,room,users);
                                    else{
                                        label.setText("THESE DATES ARE RESERVED");
                                        return;
                                    }

                                }

                            }

                        }
                    }
                }
            }

            dispose();
        });

        JPanel panel2=new JPanel();
        panel2.setLayout(new GridLayout(0,1));
        panel2.add(res);
        panel2.add(label);
        add(panel2,BorderLayout.PAGE_END);

        pack();
        setResizable(true);
        setVisible(true);
    }

    public void openArrival() {
        arrival1.setText(new DatePicker(this).setPickedDate());
    }

    public void openDeparture() {
        departure1.setText(new DatePicker(this).setPickedDate());
    }

}