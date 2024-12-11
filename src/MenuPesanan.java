import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
public class MenuPesanan implements ActionListener{
    ArrayList<String> itemsSearch = new ArrayList<>();
    JFrame frame = new JFrame();
    JPanel searchArea = new JPanel();
    JPanel resultArea = new JPanel();
    JLabel title = new JLabel();
    JLabel result = new JLabel();
    JButton searchButton = new JButton();
    JTextField searchBar = new JTextField();

   
    
   

    public void createFrame(){
        //tambah data ke array
        itemsSearch.add("item1");
        itemsSearch.add("item2");
        itemsSearch.add("item3");

        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        searchArea.setPreferredSize(new Dimension(200, 200));
        searchArea.setLayout(new FlowLayout());

        resultArea.setPreferredSize(new Dimension(200, 200));
        resultArea.setLayout(new BorderLayout());
 
        title.setText("Cari Tukang");
        title.setHorizontalAlignment(JLabel.LEFT);
        title.setVerticalAlignment(JLabel.TOP);
        searchArea.add(title);

        result.setText("Result");
        result.setVerticalAlignment(JLabel.CENTER);
        result.setHorizontalAlignment(JLabel.CENTER);
        result.setVisible(false);
        resultArea.add(result, BorderLayout.NORTH);
        
        
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
        if(e.getSource()==searchButton){
            result.setVisible(true);
            String resText = searchBar.getText();   
            result.setText(search(resText));
            
        }
    }

    public String search(String item){
        for (String items : itemsSearch) {
            if(items.equals(item)){
                return items;
            } 
        }
        return "Not Found";
    }

    
}
