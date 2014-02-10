package Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by desk on 2/9/14.
 */
public class DetailPanel extends JPanel {


    public DetailPanel(){
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Personal Detail"));

        JLabel nameLabel = new JLabel("Name :");
        JLabel occupationLabel = new JLabel("Occupation: ");

        JTextField nameField = new JTextField(10);
        JTextField occupationField = new JTextField(10);

        JButton addBtn = new JButton("add");


        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

    }
}
