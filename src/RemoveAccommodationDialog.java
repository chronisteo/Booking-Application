import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RemoveAccommodationDialog extends JDialog {

    private final AccommodationOwner login_user;
    private final JLabel removesucc;
    public RemoveAccommodationDialog(AccommodationOwnerDialog dialog, boolean modality){
        super(dialog,"RemoveAccommodation",modality);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,800);
        setLocation(dialog.getX(),dialog.getY());

        setResizable(true);

        login_user=dialog.getLoginUser();

        ButtonGroup group=new ButtonGroup();

        JRadioButton[] buttons=new JRadioButton[login_user.getAccommodations().size()];

        for(int i=0;i<login_user.getAccommodations().size();i++){
            buttons[i]=new JRadioButton(login_user.getAccommodations().get(i).getName());
            group.add(buttons[i]);
        }



        JPanel radiopanel=new JPanel(new GridLayout(0,1));
        for(int i=0;i<login_user.getAccommodations().size();i++){
            radiopanel.add(buttons[i]);
        }

        TitledBorder border = BorderFactory.createTitledBorder("CHOOSE THE ACCOMMODATION YOU WANT TO REMOVE");
        radiopanel.setBorder(border);
        add(radiopanel);
        removesucc=new JLabel("");

        JButton button = new JButton("REMOVE");
        button.addActionListener(e -> {
            if(login_user.getAccommodations().size()==0) {
                removesucc.setText("There are no accommodations to remove");
                return;
            }
            for(int i=0;i<login_user.getAccommodations().size();i++){
                if(buttons[i].isSelected()){
                    login_user.removeAccommodation(login_user.getAccommodations().get(i),dialog.getUsers());

                }
            }
            removesucc.setText("Accommodation removed");
            dispose();
        });
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(removesucc);
        add(panel,BorderLayout.PAGE_END);


        pack();
        setVisible(true);
    }
}