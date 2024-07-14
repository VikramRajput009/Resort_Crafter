
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

// actionlistener k pass Clickevent h jisko humne next button pr apply kiya h
class HMS extends JFrame implements ActionListener{

    HMS(){
        // setSize(1366,565);
        // setLocation(100,100);

        //(location x , loc.....y, length , bredth)
        setBounds(0,0,1556,1000);
        setLayout(null);


        // FOR IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1550,1000);
        add(image);


        // For adding text
        JLabel text = new JLabel("RESORT CRAFTER");
        text.setBounds(600,30,850,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN, 50));
        // font family , font type , font size
        image.add(text);


        //FOR BUTTON
        JButton next = new JButton("Next");
        next.setBounds(1300,700,150,50);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);

        // whenever we click on the button the action event will be called and we have to catch it
        next.addActionListener(this);
        text.setFont(new Font("serif",Font.PLAIN, 34));
        image.add(next);


        // For Dipper we are using MultiThreading Concept
        setVisible(true);
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);

            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }        
    }

    public void actionPerformed(ActionEvent ae){
        // Current frame will be close
        setVisible(false);
        new Login();      
    }

    public static void main(String...vr){
        new HMS();
    }
}