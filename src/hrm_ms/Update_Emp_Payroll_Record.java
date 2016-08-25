
package hrm_ms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Update_Emp_Payroll_Record extends JFrame implements ActionListener
{
    JPanel panel=new JPanel();
    
    JLabel eid=  new JLabel("Employee Id                              :  ");
    JLabel edesignation=  new JLabel("Employee Designation           :  ");
    JLabel ebs=new JLabel("Employee Basic Salary          : ");
   // JLabel econtract=  new JLabel("Employee Contract :  ");
    JLabel emab=  new JLabel("Monthly Attendence Bonus  :  ");
   
    String d[]={"Programmer","Manager","Accounter"};
    JComboBox cb=new JComboBox(d);
    
 
   
    JTextField ti=new JTextField(15);
    JTextField tc=new JTextField(15);
    JTextField ts=new JTextField(15);
    JTextField tb=new JTextField(15);
    
    JButton sb=new JButton("Save",new ImageIcon("Save.gif"));
    JButton bb=new JButton("Back",new ImageIcon("Regis.png"));
    
   
    Connection con;
    Statement st;
    ResultSet rs;
    
    
    Font font=new Font("SERIF",Font.BOLD|Font.PLAIN,15);
    ImageIcon ic=new ImageIcon();
    
    
   Update_Emp_Payroll_Record(Connection con)
   {
       
        super("Employee_Payroll_System");
        this.con=con;
        panel.setLayout(null);
        add(panel);
        setSize(550,450);
        setVisible(true);
        setLocation(480,90);
        setResizable(false);
        Add_Component();
        
      
   }
    void Add_Component()
     {
        eid.setBounds(30, 30, 170, 40);
        ti.setBounds(210, 30, 150, 40);
        panel.add(eid);
        panel.add(ti);
        
        edesignation.setBounds(30, 80, 170, 40);
        cb.setBounds(210, 80, 150, 40);
        panel.add(edesignation);
        panel.add(cb);
        
        
        ebs.setBounds(30, 130, 170, 40);
        ts.setBounds(210, 130, 150, 40);
        ts.setFont(font);
        ts.setForeground(Color.BLACK);
        panel.add(ebs);
        panel.add(ts);
      
        
        emab.setBounds(30, 180, 170, 40);
        tb.setBounds(210, 180, 150, 40);
        panel.add(emab);
        panel.add(tb);
        
        
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
 /*  public static void main(String args[])
   {
        
      
   }*/
    public void actionPerformed(ActionEvent epay)
    {
        if(epay.getSource()==sb)
        {
            
            if(ti.getText().equals("")||ts.getText().equals("")||tb.getText().equals("")
                   )
            {
                JOptionPane.showMessageDialog(null, "Please enter correct name,id and contract no.");
            }
            
        else
            {
                try
                {
                
 
  //  String sqlpx="insert into employee_pay(id,combo,bsalary,bonous)"
                    //    + "values('"+ti.getText()+"','"+cb.getSelectedItem()+"','"+ts.getText()+"','"+tb.getText()+"')";
                
                /*UPDATE Customers
SET ContactName='Alfred Schmidt', City='Hamburg'
WHERE CustomerName='Alfreds Futterkiste';      */      
                
    
    
   PreparedStatement ps= con.prepareStatement("Update employee_pay set position='"+cb.getSelectedItem()+"', bsalary='"+ts.getText()+"' , bonous='"+tb.getText()+"' where id='" + ti.getText()+"'");
                //PreparedStatement ps= con.prepareStatement("Update student_record set Name=?, Dept=?, Date=?, Bcode=?, MobileN=?, Padd=?,Email=? where Id=" + text_id.getText());
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Record updated successfully");
               // ti.setText("");
             //   ts.setText("");
             //   tb.setText("");
                
                }
                catch(SQLException epsql)
                {
                     JOptionPane.showMessageDialog(null,"Sorry the record you have entered already exists");
                }
                

                
            }
        }
      
    }
    
    
}
