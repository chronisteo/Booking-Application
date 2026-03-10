import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RemoveHotelDialog extends JDialog {
    private final HotelOwner login_user;

    public RemoveHotelDialog(HotelOwnerDialog dialog, boolean modality){
        super(dialog,"RemoveHotel",modality);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,800);
        setLocation(dialog.getX(),dialog.getY() );

        setResizable(true);

        login_user=dialog.getLoginUser();

        ButtonGroup group=new ButtonGroup();

        JRadioButton[] buttons=new JRadioButton[login_user.getHotels().size()];

        for(int i=0;i<login_user.getHotels().size();i++){
            buttons[i]=new JRadioButton(login_user.getHotels().get(i).getName());
            group.add(buttons[i]);
        }



        JPanel radiopanel=new JPanel(new GridLayout(0,1));
        for(int i=0;i<login_user.getHotels().size();i++){
            radiopanel.add(buttons[i]);
        }

        TitledBorder border = BorderFactory.createTitledBorder("CHOOSE THE HOTEL YOU WANT TO REMOVE");
        radiopanel.setBorder(border);
        add(radiopanel);

        JButton button = new JButton("REMOVE");
        button.addActionListener(e -> {
            for(int i=0;i<login_user.getHotels().size();i++){
                if(buttons[i].isSelected()){
                    login_user.removeHotel(login_user.getHotels().get(i), dialog.getUsers());
                }
            }
        });
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(button);
        add(panel,BorderLayout.PAGE_END);


        pack();
        setVisible(true);





    }
}

