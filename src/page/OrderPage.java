package tubespbo.src.page;
import tubespbo.src.userClass.*;

import javax.swing.*;
public class OrderPage {
    private Tukang tukang;
    JFrame frame = new JFrame("Order Page");
    JLabel tukangName = new JLabel();
    public OrderPage(Tukang tukang) {
        this.tukang = tukang;
    }

    public void createFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);

        tukangName.setText(tukang.getName());
        tukangName.setHorizontalAlignment(JLabel.CENTER);
        tukangName.setVerticalAlignment(JLabel.CENTER);
        frame.add(tukangName);


    }
}
