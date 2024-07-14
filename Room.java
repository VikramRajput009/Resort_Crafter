
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import net.proteanit.sql.*;


import javax.swing.*;
public class Room extends JFrame implements ActionListener{

    JTable table;
    JButton back;

    Room(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        //
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/room1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);


        //
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(4,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(100,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(200,10,100,20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(300,10,100,20);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(400,10,100,20);
        add(l5);


        //
        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);

        try{
            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }


        //
        back = new JButton("Back");
        back.setBounds(200,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);

        back.addActionListener(this);
        add(back);



        setBounds(300,200,1050,600);
        setVisible(true);


    }


    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();

    }

    public static void main(String...vr){
        new Room();

    }
    
}
