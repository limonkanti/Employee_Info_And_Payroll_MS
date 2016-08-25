
package hrm_ms;

import javax.swing.*;


public class Login_Help extends JFrame
{
    JPanel panel=new JPanel();
    JLabel label=new JLabel("Using Instruction:");
    JLabel label1=new JLabel("1). At first user should registration .");
    JLabel label3=new JLabel("2). After Registration user can login .");
    
    Login_Help()
     {
        super("Login_Help");
        panel.setLayout(null);
        add(panel);
        setSize(350,300);
        setVisible(true);
        setLocation(480,180);
        setResizable(false);
        Add_Label();
     
     }
    void Add_Label()
    {
        label.setBounds(20, 30, 100, 40);
        panel.add(label);
        
       label1.setBounds(40, 80, 350, 40);
       panel.add(label1);
       
       label3.setBounds(40, 130, 350, 40);
       panel.add(label3);
       
       
        
    }
   /* public static void main(String args[])
    {
       // Login_Help obh=new Login_Help();
    }*/
    
}
