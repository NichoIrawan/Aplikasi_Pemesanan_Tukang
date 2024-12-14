package tubespbo.src.page;

import tubespbo.src.userClass.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;
import javax.swing.*;
public class MenuPesanan implements ActionListener{
    HashMap<String ,Tukang> itemsSearch = new HashMap<>();
    JFrame frame = new JFrame();
    JPanel searchArea = new JPanel();
    JPanel resultArea = new JPanel();
    JLabel title = new JLabel();
    JLabel result = new JLabel();
    JButton orderButton = new JButton();
    JButton searchButton = new JButton();
    JTextField searchBar = new JTextField();

   
    
   

    public void createFrame(){
        //tambah data ke array
        itemsSearch.put("1", new Tukang("abc123@gmail.com", "1234", "1", "Ujang"));
        itemsSearch.put("2", new Tukang("bobi@gmail.com", "3214", "2", "Bobi"));
        itemsSearch.put("3", new Tukang("agus@gmail.com", "1452", "3", "Agus"));


        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        searchArea.setPreferredSize(new Dimension(200, 200));
        searchArea.setLayout(new FlowLayout());

        resultArea.setPreferredSize(new Dimension(200, 200));
        resultArea.setLayout(new FlowLayout());
 
        title.setText("Cari Tukang");
        title.setHorizontalAlignment(JLabel.LEFT);
        title.setVerticalAlignment(JLabel.TOP);
        searchArea.add(title);

        result.setText("Result");
        result.setVerticalAlignment(JLabel.CENTER);
        result.setHorizontalAlignment(JLabel.CENTER);
        result.setVisible(false);
        orderButton.setVisible(false);
        orderButton.setText("Pesan");
        orderButton.addActionListener(this);
        resultArea.add(result);
        resultArea.add(orderButton);
        
        
        searchBar.setPreferredSize(new Dimension(250, 40));
        searchArea.add(searchBar);
        searchButton.setText("Cari");
        searchButton.addActionListener(this);
        searchArea.add(searchButton);

        frame.add(searchArea, BorderLayout.NORTH);
        frame.add(resultArea, BorderLayout.SOUTH);
        frame.setVisible(true);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String resText = searchBar.getText();
        String item = search(resText);
        if(e.getSource()==searchButton){
            orderButton.setVisible(true);
            result.setVisible(true);
            result.setText(itemsSearch.get(item).getEmail());
        }
        if ((e.getSource()==orderButton)){
            frame.setVisible(false);
            new OrderPage(itemsSearch.get(item)).createFrame();
        }
    }

    public String search(String item){
        for (String i : itemsSearch.keySet()) {
            if (itemsSearch.get(i).getName().equals(item)) {
                return i;
            }
        }
        return "Not Found";
    }

    
}
