import javax.swing.*;   
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet; 


// Frame is in Swing package
//Color is in awt package
public class Login extends JFrame implements ActionListener{

    JTextField username;
    JPasswordField password;
    JButton login, cancel;

    Login(){

        // CHANGING LABEL BACKGROUND COLOR
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);


        JLabel user = new JLabel("USERNAME");
        user.setBounds(40,20,100,30);
        add(user);

        username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);

        JLabel pass = new JLabel("PASSWORD");
        pass.setBounds(40,70,100,30);
        add(pass);

        password = new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);


        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        // login.setFont(new Font("serif",Font.PLAIN, 24));

        login.addActionListener(this);
        add(login);


        cancel = new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);

        cancel.addActionListener(this);
        add(cancel);


        // yaha humne image liya
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        // uski scalling kari   awt package
        Image i2 = i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        // wapas ussi me move kr diya - because we cannot directly put the object of Image class in JLabel


        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);

        setBounds(500,200,600,300);
        setVisible(true);

    }

    //action event class check krti h ki konsi button click hui h
    public void actionPerformed(ActionEvent ae){

        // for button  = getSource        1 page to another
        if(ae.getSource() == login){

           String user = username.getText();
           String pass = password.getText();

           try{
                Conn c = new Conn();

                String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";

                // For execute query we have function
                ResultSet rs = c.s.executeQuery(query);


                // input aaya h yaa nhi
                // .next() - will return boolean
                if(rs.next()){
                    setVisible(false);
                    new Dashboard();

                }

                else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);

                }

           }catch(Exception e){
             e.printStackTrace();
           }

        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    
    public static void main(String...vr){
        new Login();

    }
}
