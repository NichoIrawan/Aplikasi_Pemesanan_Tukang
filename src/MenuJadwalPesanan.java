import java.awt.*;
import javax.swing.*;
public class MenuJadwalPesanan {

    JFrame frame = new JFrame();
    JTextField timeInput = new JTextField();
    JTextField dateInput = new JTextField();
    JLabel title = new JLabel();

    

    public void createFrame(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        title.setText("Masukkan Tanggal Pesanan");
        title.setPreferredSize(new Dimension(50, 50));
        timeInput.setPreferredSize(new Dimension(100, 100));
        dateInput.setPreferredSize(new Dimension(100, 100));

        
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(3,1));
        frame.add(title);
        frame.add(timeInput);
        frame.add(dateInput);



    }
}
