
package hrm_ms;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Update_Emp_Info_Record extends JFrame implements ActionListener
{
     JLabel id_label=new JLabel("Enter id       : ");
     
     JTextField tcont=new JTextField(15);
     
     JButton okb=new JButton(" Ok ");
     
    JLabel lbook_code;
    
    JTextField tbook_code;
    
    JLabel line_label=new JLabel("Enter id and new contract number which you want to update");
    
    JButton back=new JButton(" Back ");
    
    JPanel panal=new JPanel();
    
    Connection con;
    
    Statement st ;
    
    ResultSet rs;
    
    Update_Emp_Info_Record(Connection con)
    {
        super("Upadate Employee Information Record");
        
        this.con=con;
        
        panal.setLayout(null);
      
        add(panal);
        
        setSize(550,450);
        
        setVisible(true);
        setResizable(false);
        setLocation(320,230);
        lax_tfild();
        
        
    }
    void lax_tfild()
    {
        line_label.setBounds(50, 30, 350, 40);
        panal.add(line_label);
        
        id_label.setBounds(100, 100, 110, 40);
        panal.add(id_label);
        tcont.setBounds(220, 100, 180, 40);
        panal.add(tcont);   
       
        lbook_code=new JLabel("Contract     : ");
        lbook_code.setBounds(100, 150, 110, 40);
        tbook_code=new JTextField(15);
        tbook_code.setBounds(220, 150, 180, 40);
        panal.add(lbook_code);
        panal.add(tbook_code);

        
        okb.setBounds(100, 330, 150, 40);
        okb.addActionListener(this);
        panal.add(okb);
        
        back.setBounds(260, 330, 150, 40);
        back.addActionListener(this);
        panal.add(back);    
    }

    public void actionPerformed(ActionEvent exx)
    {
       if(exx.getSource()==okb)
           
       {
           if(tcont.getText().equals("")||tbook_code.getText().equals(""))
           {
               JOptionPane.showMessageDialog(null, "Please enter correct id");
               
           }
           
           else
           {
            try
            {
  
                
                Statement st = con.createStatement();
                //PreparedStatement ps=c.prepareStatement ("Update Directory set  Date=?,Name=?,Class=?,Shift=?,Progress=?,Address=?,City=?,Permenent_Address=?,PhoneNo=?,eaddress=?  where Id="+id.getText());
                PreparedStatement ps= con.prepareStatement("Update employee_info5 set cont='"+tbook_code.getText()+"' where id='" + tcont.getText()+"'");
                //PreparedStatement ps= con.prepareStatement("Update student_record set Name=?, Dept=?, Date=?, Bcode=?, MobileN=?, Padd=?,Email=? where Id=" + text_id.getText());
                ps.executeUpdate();
                
              //jp.showMessageDialog(this, "Record Updated Successfully", "SUCCESS");
               JOptionPane.showMessageDialog(null,"Update Successfully");
               tcont.setText("");
               tbook_code.setText("");   
                
            }
            catch(Exception ex)
            {
                
                JOptionPane.showMessageDialog(null,"The quere is wrong\n");
                
            }
           }
                
       }
      
        
    }

    }
   /* class M
    {
        public static void main(String args[])
        {
          // Update_Emp_Info_Record o=new Update_Emp_Info_Record(con);
            
        }
    }*/

