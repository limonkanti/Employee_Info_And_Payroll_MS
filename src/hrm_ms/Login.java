
package hrm_ms;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener
{
    
    JPanel panel=new JPanel();
    JLabel name=new JLabel("Name          : ");
    JLabel password=new JLabel("Password :  ");
    JTextField tn=new JTextField(15);
    JPasswordField tp=new JPasswordField(15);
    JButton lb=new JButton("Login",new ImageIcon("image/Keys.gif"));
    JButton rb=new JButton("Registration",new ImageIcon("image/Regis.png"));
   
    Connection con;
    Statement st;
    ResultSet rs;
    
    JMenu helpmenu,thememenu,Sub;
    JMenuItem helpitem,theme1,theme2,theme3,exititem;
    JCheckBoxMenuItem sub1,sub2;
    JMenuBar mb;
    
    
    Font font=new Font("SERIF",Font.BOLD|Font.PLAIN,15);
    ImageIcon ic=new ImageIcon();
    
    Cursor cur=new Cursor(Cursor.HAND_CURSOR);
    
    
     Login()
     {
        super("Employee_Login");
        panel.setLayout(null);
        add(panel);
        setSize(350,300);
        setVisible(true);
        setLocation(480,180);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setCursor(cur);
        Add_Component();
        sql_connection();
        Menu();  
     
     }
     void Menu()
     {
         
        helpmenu=new JMenu("Help");
        thememenu=new JMenu("Theme");
        theme1=new JMenuItem("Windows",new ImageIcon("image/Regis.png"));
        theme1.addActionListener(this);
        theme2=new JMenuItem("Metal",new ImageIcon("image/Regis.png"));
        theme2.addActionListener(this);
        theme3=new JMenuItem("Birsoft",new ImageIcon("image/Regis.png"));
        theme3.addActionListener(this);
        mb=new JMenuBar();
        
        
        helpitem=new JMenuItem("Help",new ImageIcon("image/Help.gif"));
        helpitem.setToolTipText("Help");
        helpitem.setAccelerator(KeyStroke.getKeyStroke('H',Event.CTRL_MASK));
        helpitem.addActionListener(this);
        helpmenu.add(helpitem);
        helpmenu.setToolTipText("Help");
        helpmenu.setMnemonic(KeyEvent.VK_H);
        helpmenu.addSeparator();
        
        exititem=new JMenuItem("Exit",new ImageIcon("image/delete.png"));
        exititem.setToolTipText("Exit");
        exititem.addActionListener(this);
        helpmenu.add(exititem);
        helpmenu.addSeparator();
        
        Sub=new JMenu("Sub Menu");
        sub1=new JCheckBoxMenuItem("Sub Menu1");
        sub1.setEnabled(false);
        Sub.add(sub1);
        sub2=new JCheckBoxMenuItem("Sub Menu2");
        Sub.add(sub2);
        helpmenu.add(Sub);
        
        
        thememenu.setMnemonic(KeyEvent.VK_T);
        thememenu.setToolTipText("Theme");
        thememenu.add(theme1);
        thememenu.add(theme2);
        thememenu.add(theme3);
       
        mb.add(helpmenu);
        mb.add(thememenu);
        setJMenuBar(mb);
         
         
     }
      void Add_Component()
     {
        name.setBounds(30, 30, 70, 40);
        tn.setBounds(110, 30, 150, 40);
        tn.setFont(font);
        tn.setForeground(Color.GREEN);
        panel.add(name);
        panel.add(tn);
       
 
        password.setBounds(30, 100, 70, 40);
        tp.setBounds(110, 100, 150, 40);
        panel.add(password);
        panel.add(tp);
        
        lb.setBounds(20,180, 120, 40);
        lb.addActionListener(this);
        lb.setToolTipText("Login");
        lb.setMnemonic(KeyEvent.VK_L);
        panel.add(lb);
        
        rb.setBounds(160,180, 130, 40);
        rb.setToolTipText("Registration");
        rb.setMnemonic(KeyEvent.VK_R);
        rb.addActionListener(this);
        panel.add(rb);
       
        
    }
      
   
    void sql_connection()
    {
        try
        {
            // Class c= Class.forName("com.mysql.jdbc.Driver");
             Class c= Class.forName("com.mysql.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee_Info","root","12345");
             System.out.println("Connection Successfull");
              //con=url
//here jdbc=api
 //mysql is the database
//localhost is the server name where mysql is running
//   3306 is port no
//database name            
//username="root"
//password="";
        }
       catch(Exception e)
       {
            System.out.println(e.toString());
           
       }
    }
    void theme_1()
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Wrong");
        }
    }
    void theme_2()
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        try
        {
                  
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.toString());
        }
    }
 
   void theme_3()
    {
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            }
        catch (Exception e){}
    }

   public static void main(String[] args)
    {
        
         JFrame.setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            }
        catch (Exception e){}
        
        Login ob=new Login();
          
    }
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==theme1)
        {
            theme_1();
        }
        if(e.getSource()==theme2)
        {
            theme_2();
        }
        if(e.getSource()==theme3)
        {
            theme_3();
        }
        if(e.getSource()==helpitem)
            
        {
            new Login_Help();
        }
        if(e.getSource()==rb)
        {
            new Registration(con);
            dispose();
        }
        if(e.getSource()==lb)
        {
            boolean c=false;
            if(tn.getText().equals("")||tp.getText().equals(""))
               {
                   
                 JOptionPane.showMessageDialog(null,"Please enter correct username or password","Warning!!!",JOptionPane.ERROR_MESSAGE);
            
               }
             else
               {
                   
                   
                   try
                   {
                       String query="select * from registration where Name='"+tn.getText()+"'"
                               + "&& Password='"+tp.getText()+"'";
                       st=con.createStatement();
                       rs=st.executeQuery(query);
                       rs.next();
                       String name=rs.getString("Name");
                       String pass=rs.getString("Password");
                       if(tn.getText().equals(name)&&tp.getText().equals(pass))
                       {
                           c=true;
                           new MainFrame(con);
                                           
                         dispose();
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null, "Sorry you have entered wrong name or passwsord","Warning!!!",JOptionPane.ERROR_MESSAGE);
                       }
                               
                   }
                  catch(Exception ez)
                  {
                       JOptionPane.showMessageDialog(null, "Sorry you have entered wrong name or passwsord,try again!","Warning!!!",JOptionPane.WARNING_MESSAGE);
                     
                      // JOptionPane.showMessageDialog(null, ez.toString());
                  }
                  finally
                  {
                      
                       
                  }
            
               }
        
        }
        if(e.getSource()==exititem)
          {
              int respond = JOptionPane.showConfirmDialog(null, "Would you like to exit the program ?", "Exiting", JOptionPane.YES_NO_OPTION);
			//System.out.println(respond);
			
			if(respond == 0)//0 means no;
                        {
		             dispose (); //closing the frame
                            //System.exit(0);
			}
             // System.exit(0);
                    
          }
    }
}
