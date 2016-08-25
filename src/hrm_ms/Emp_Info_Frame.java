
package hrm_ms;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;

public class Emp_Info_Frame extends JInternalFrame implements ActionListener

{
    JPanel panel=new JPanel();
    JLabel ename=new JLabel("Employee Name       : ");
    JLabel eid=  new JLabel("Employee Id              :  ");
    JLabel econtract=  new JLabel("Employee Contract :  ");
    JLabel ejoin=  new JLabel("Employee Join          :  ");
    
    JLabel esex=  new JLabel("Employee Sex           :  ");
    JTextField tname=new JTextField(15);
    JTextField tid=new JTextField(15);
    JTextField tcontract=new JTextField(15);
    JTextField tdate;
    String sex1[]={"Male","Female","Common"};
    JComboBox tcombo=new JComboBox(sex1);
    JButton sb=new JButton("Save",new ImageIcon("image/Save.gif"));
    JButton bb=new JButton("Back",new ImageIcon("image/Regis.png"));
     
    Font font=new Font("SERIF",Font.BOLD|Font.PLAIN,15);
    ImageIcon ic=new ImageIcon();
   
   
    Connection con;
    Statement st=null;
    ResultSet rs;
      
   Emp_Info_Frame(Connection con)
   {
       
        super("Employee_Information",true,true,true,true);
       
        this.con=con;
        panel.setLayout(null);
        add(panel);
        setSize(550,450);
        setVisible(true);
        setLocation(480,90);
        //setResizable(false);
        
        Add_Component_E();     
      
  }
   
    void Add_Component_E()
     {
         
        ename.setBounds(30, 30, 130, 40);
        tname.setBounds(170, 30, 150, 40);
      //  tname.setFont(font);
      //  etn.setForeground(Color.BLACK);
        panel.add(ename);
        panel.add(tname);
      
        eid.setBounds(30, 80, 130, 40);
        tid.setBounds(170, 80, 150, 40);
        panel.add(eid);
        panel.add(tid);
        
        econtract.setBounds(30, 130, 130, 40);
        tcontract.setBounds(170, 130, 150, 40);
        panel.add(econtract);
        panel.add(tcontract);
        
        
       Date date=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("dd:MM:yyyy");////
       String string_date=sdf.format(date);
       tdate=new JTextField(string_date);
        ejoin.setBounds(30, 180, 130, 40);
       tdate.setBounds(170, 180, 150, 40);
        panel.add(ejoin);
        panel.add(tdate);
        
        esex.setBounds(30, 230, 130, 40);
        tcombo.setBounds(170, 230, 150, 40);
        panel.add(esex);
        panel.add(tcombo);
        
        
        
        
        sb.setBounds(120,350, 140, 40);
        sb.addActionListener(this);
        sb.setToolTipText("Save");
        sb.setMnemonic(KeyEvent.VK_S);
        panel.add(sb);
        
        bb.setBounds(270,350, 140, 40);
        bb.setToolTipText("Back");
        bb.setMnemonic(KeyEvent.VK_B);
        bb.addActionListener(this);
        panel.add(bb);
      
    }
   
  /* public static void main(String args[])
   {
      //Emp_Info_Frame info=new Emp_Info_Frame();
   }*/

   public void actionPerformed(ActionEvent einfo)
    {
        if(einfo.getSource()==sb)
        {
        
            if(tname.getText().equals("")||tid.getText().equals("")||tcontract.getText().equals("")
                   )
            {
                JOptionPane.showMessageDialog(null, "Please enter correct name,id and contract no.");
            }
            
        else
            {
                try
                {
                
 
    String sqlx="insert into employee_info5(name,id,cont,combo,date)"
                        + "values('"+tname.getText()+"','"+tid.getText()+"','"+tcontract.getText()+"','"+tcombo.getSelectedItem()+"','"+tdate.getText()+"')";
                
                
                st=con.createStatement();
                st.execute(sqlx);
                JOptionPane.showMessageDialog(null,"Record inserted successfully");
                tname.setText("");
               // tid.setText("");
                tcontract.setText("");
                
                }
                catch(SQLException esql)
                {
                     JOptionPane.showMessageDialog(null,"Sorry the record you have entered already exists");
                }
                

                
            }
            
            
        }
       
      
    }
    
    
}
