import javax.swing.*;

public class CMessagesDialog extends JDialog {

    public CMessagesDialog(CustomerDialog dialog, boolean modality){
        super(dialog,"Messages from Admin",modality);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,800);
        setLocation(dialog.getX(),dialog.getY() );

        setResizable(false);

        Customer login_user=dialog.getLoginUser();

        int counter=0;
        DefaultListModel<String> l1 = new DefaultListModel<>();
        for(int i=0;i<login_user.getInbox().size();i++) {
            counter++;
            l1.addElement(counter+"."+login_user.getInbox().get(i).getText());
        }
        JList<String> list = new JList<>(l1);
        list.setBounds(100,100, 75,75);
        add(list);







        //pack();
        setVisible(true);
    }
}
