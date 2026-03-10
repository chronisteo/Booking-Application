import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class SendMessageDialog extends JDialog {

    private final JLabel label;
    private final JTextField mess;
    private int number;

    public SendMessageDialog(AdminDialog dialog, boolean modality){
        super(dialog,"SendMessage",modality);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,800);
        setLocation(dialog.getX(),dialog.getY());
        setResizable(false);

        number=0;
        for(int i=0;i<dialog.getUsers().size();i++){
            if(dialog.getUsers().get(i) instanceof AccommodationOwner || dialog.getUsers().get(i) instanceof HotelOwner || dialog.getUsers().get(i) instanceof Customer)
                number++;
        }
        mess=new JTextField("HERE YOU WRITE THE MESSAGE YOU WANT TO SEND");
        label=new JLabel("");



        ButtonGroup group=new ButtonGroup();

        JRadioButton[] buttons=new JRadioButton[number];

        int c=0;
        for(int i=0;i<dialog.getUsers().size();i++){
            if(dialog.getUsers().get(i) instanceof AccommodationOwner || dialog.getUsers().get(i) instanceof HotelOwner || dialog.getUsers().get(i) instanceof Customer) {
                buttons[c] = new JRadioButton(dialog.getUsers().get(i).getUsername());
                group.add(buttons[c]);
                c++;
            }
        }



        JPanel radiopanel=new JPanel(new GridLayout(0,1));
        for(int i=0;i<number;i++){
            radiopanel.add(buttons[i]);
        }

        TitledBorder border = BorderFactory.createTitledBorder("CHOOSE THE USER YOU WANT TO SEND THE MESSAGE");
        radiopanel.setBorder(border);
        add(radiopanel);

        JButton button = new JButton("SEND MESSAGE");
        button.addActionListener(e -> {
            if(mess.getText().equals("")){
                 label.setText("BLANK MESSAGE FORM");
                 return;
            }

            int counter=0;
            for(int i=0;i<number;i++){
                 if(!buttons[i].isSelected()){
                     counter++;
                 }
            }
            if(counter==number){
                label.setText("SELECT THE USER YOU WANT TO SEND THE MESSAGE");
                return ;
            }

           for(int i=0;i<number;i++){
                if(buttons[i].isSelected()){
                     String name=buttons[i].getText();
                     for(int j=0;j<dialog.getUsers().size();j++){
                         if(dialog.getUsers().get(j).getUsername().equals(name)){
                             if(dialog.getUsers().get(j) instanceof Customer) {
                                 ((Customer) dialog.getUsers().get(j)).addMessage(new Message(mess.getText()));
                                 label.setText("MESSAGE SEND!");
                                 return;
                             }
                             else if(dialog.getUsers().get(j) instanceof HotelOwner) {
                                 ((HotelOwner) dialog.getUsers().get(j)).addMessage(new Message(mess.getText()));

                                 label.setText("MESSAGE SEND!");
                                 return;
                             }
                             else if(dialog.getUsers().get(j) instanceof AccommodationOwner) {
                                 ((AccommodationOwner) dialog.getUsers().get(j)).addMessage(new Message(mess.getText()));
                                 label.setText("MESSAGE SEND!");
                                 return;
                             }

                         }
                     }
                }
            }
        });
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(0,1,10,10));
        panel.add(mess);
        panel.add(button);
        panel.add(label);
        add(panel,BorderLayout.PAGE_END);

        pack();

        setVisible(true);
    }
}
