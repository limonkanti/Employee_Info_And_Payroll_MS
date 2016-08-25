
package hrm_ms;

import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class Registration  extends JFrame implements ActionListener
{
    JPanel panel=new JPanel();
    JLabel name=new JLabel("Name         : ");
    JLabel email=new JLabel("E-mail     :  ");
    JLabel password=new JLabel("Password :  ");
    
    JLabel email_error=new JLabel();
    
    JTextField tn=new JTextField(15);
    JTextField te=new JTextField(15);
    JPasswordField tp=new JPasswordField(15);
    
    ImageIcon ic;
    
   
    JButton sb=new JButton("Save",new ImageIcon("image/SAVE.GIF"));
    JButton bb=new JButton("Back",new ImageIcon("image/ok.png"));
    
    Connection con;
    Statement st;
    ResultSet rs;
    
   
    
    Registration(Connection con)
    {
        super("Registration");
        this.con=con;
        panel.setLayout(null);
        add(panel);
        setSize(350,300);
        setVisible(true);
        setLocation(480,180);
        setResizable(false);
        Add_Component();
    }
    void Add_Component()
    {
        name.setBounds(30, 10, 70, 40);
        tn.setBounds(110, 10, 150, 40);
        panel.add(name);
        panel.add(tn);
        
        email.setBounds(30, 60, 70, 40);
        te.setBounds(110, 60, 150, 40);
        panel.add(email);
        panel.add(te);
       
        password.setBounds(30, 110, 70, 40);
        tp.setBounds(110, 110, 150, 40);
        panel.add(password);
        panel.add(tp);
        
        
        
        
        sb.setBounds(20,180, 120, 40);
        sb.addActionListener(this);
        panel.add(sb);
        
        bb.setBounds(160,180, 130, 40);
        bb.addActionListener(this);
        panel.add(bb);    
        
    }
    

    /*public static void main(String[] args)
    {
      //Registration obr=new Registration();
    }*/

   
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bb)
        {
            new Login();
            dispose();
        }
        
        if(e.getSource()==sb)
        {
            String tinput=tn.getText();
            
            String pinput=tp.getText();
           
           
          
                if(tinput.equals("")||te.equals("")||pinput.equals(""))
                  {
                     JOptionPane.showMessageDialog(null, "Please enter correct name email or password");
                  }
          
                else
                {
                 try
                    {
                         String str="insert into registration(Name,Email,Password)"
                                + "values('"+tn.getText()+"','"+te.getText()+"','"+tp.getText()+"')";
                          st=con.createStatement();
                          st.execute(str);
                          JOptionPane.showMessageDialog(null,"Registration Successfully");
                          tn.setText(null);
                          tp.setText(null);        
                    
                     }
                  catch(Exception ee)
                   {
                      JOptionPane.showMessageDialog(null,"Sorry,Name,Email or Passwoed already exist!","Warning!!!",JOptionPane.ERROR_MESSAGE);
                       
                      //  JOptionPane.showMessageDialog(null,ee.toString());
                  }  
        }
      }
    }

   
}

