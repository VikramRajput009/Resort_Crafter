import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener{

    Dashboard(){

        setBounds(0,0,1550,1000);

        setLayout(null);    

        // For setting image on DASHBOARD
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);




        JLabel text = new JLabel("NIVI GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        // Specially for the frame
        text.setFont(new Font("Tahoma", Font.PLAIN,46));
        text.setForeground(Color.WHITE);

        // on the image we are adding our content
        image.add(text);


        

        // Menu Bar
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.BLACK);
        mb.add(hotel);

        //MENU ITEM = CLASS for the DROPDOWN  added in menu   
        // menu in MENUBAR
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);



        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLACK);
        mb.add(admin);

        JMenuItem employee = new JMenuItem("ADD EMPLOYEE");
        employee.addActionListener(this);
        admin.add(employee);

        JMenuItem rooms = new JMenuItem("ADD ROOMS");
        rooms.addActionListener(this);
        admin.add(rooms);

        JMenuItem drivers = new JMenuItem("ADD DRIVERS");
        drivers.addActionListener(this);
        admin.add(drivers);



        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){

        // for menu items      getActionCommand 
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }
        else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDrivers();
        }
        else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }

    public static void main(String...vr){
        new Dashboard();
    }
    
}
