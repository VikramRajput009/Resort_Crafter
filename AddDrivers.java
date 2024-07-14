
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class AddDrivers extends JFrame  implements ActionListener{


    JButton add, cancel;
    JTextField tfname, tfage, tfcompany, tfmodel, tflocation;
    JComboBox availablecombo, gendercombo;

    AddDrivers(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //
        JLabel heading = new JLabel("Add Drivers");
        heading.setBounds(150,10,200,20);
        heading.setFont(new Font("TAHOMA", Font.BOLD,18));
        add(heading);




        //
        JLabel lblroomno = new JLabel("Name");
        lblroomno.setFont(new Font("TAHOMA", Font.PLAIN,16));
        lblroomno.setBounds(60,60,120,30);      
        add(lblroomno);

        tfname = new JTextField();
        tfname.setBounds(200,60,150,30);
        add(tfname);



        //
        JLabel lblage = new JLabel("Age");  
        lblage.setFont(new Font("TAHOMA", Font.PLAIN,16));
        lblage.setBounds(60,100,120,30);      
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200,100,150,30);
        add(tfage);




        //
        JLabel lblclean = new JLabel("Gender");  
        lblclean.setFont(new Font("TAHOMA", Font.PLAIN,16));
        lblclean.setBounds(60,140,120,30);      
        add(lblclean);

        String cleanOptions[] = {"Male", "Female"};
        gendercombo = new JComboBox(cleanOptions);
        gendercombo.setBounds(200,140,150,30);   
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);




        //
        JLabel lblprice = new JLabel("Car Company");
        lblprice.setFont(new Font("TAHOMA", Font.PLAIN,16));
        lblprice.setBounds(60,180,120,30);      
        add(lblprice);

        tfcompany = new JTextField();
        tfcompany.setBounds(200,180,150,30);
        add(tfcompany);




        //
        JLabel lbltype = new JLabel("Car Model");  
        lbltype.setFont(new Font("TAHOMA", Font.PLAIN,16));
        lbltype.setBounds(60,220,120,30);      
        add(lbltype);

        tfmodel = new JTextField();
        tfmodel.setBounds(200,220,150,30);
        add(tfmodel);




        JLabel lblavailable = new JLabel("Available");  
        lblavailable.setFont(new Font("TAHOMA", Font.PLAIN,16));
        lblavailable.setBounds(60,260,120,30);      
        add(lblavailable);

        String driverOptions[] = {"Available", "Busy"};
        availablecombo = new JComboBox(driverOptions);
        availablecombo.setBounds(200,260,150,30);   
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);




        //
        JLabel lbllocation = new JLabel("Location");  
        lbllocation.setFont(new Font("TAHOMA", Font.PLAIN,16));
        lbllocation.setBounds(60,300,120,30);      
        add(lbllocation);

        //
        tflocation = new JTextField();
        tflocation.setBounds(200,300,150,30);
        add(tflocation);




        //
        add = new JButton("Add Driver");
        add.setBounds(60,370,130,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        //
        cancel = new JButton("Cancel");
        cancel.setBounds(220,370,130,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);




        //
        //  IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);


        setBounds(330,200,980,470);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == add){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String)gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String brand= tfmodel.getText();
            String available= (String)availablecombo.getSelectedItem();
            String location = tflocation.getText();


            try{

                Conn conn = new Conn();

                String str = "insert into driver values('"+ name +"', '"+ age +"', '"+ gender +"', '"+ company +"', '"+ brand +"', '"+ available +"', '"+ location +"')";

                conn.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "New Driver Added Successfully"); 

                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);;
        }

    }

    public static void main(String...vr){
        new AddDrivers();
    }   
}
