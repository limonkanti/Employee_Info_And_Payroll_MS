
package hrm_ms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

 class Delete_Payroll_Record extends JFrame implements ActionListener
{
    
    JLabel idlabel=new JLabel("Enter Id  :");
    
    JLabel line_label=new JLabel("Please enter correct id for deleting employee payroll record");
    
    JTextField t_id=new JTextField(15);
    
    JButton okb=new JButton(" Ok ");
    
    JButton back=new JButton(" Back ");
    
    JPanel panal=new JPanel();
    
  
    Connection con;
    Statement st = null;//help access to the database
    ResultSet rs;
    
   Delete_Payroll_Record(Connection con)
    {
        super("Delete Payroll Record");
        pack();
        this.con=con;
        panal.setLayout(null);
        add(panal);
      //  panal.setBackground(Color.darkGray);
        setSize(380,330);
        setVisible(true);
        setResizable(false);
        setLocation(480,180);
        la_tfild();
        
        
    }
    void la_tfild()
    {
        line_label.setBounds(15, 10, 350, 40);
       // line_label.setForeground(Color.pink);
        panal.add(line_label);
        
        idlabel.setBounds(80, 80, 60, 40);
       // idlabel.setForeground(Color.pink);
        panal.add(idlabel);
        
        t_id.setBounds(150, 80, 100, 40);
       // pnal.add(t_id);
        panal.add(t_id);
      //  pnal.add(this);
        okb.setBounds(90, 200, 80, 40);
        okb.addActionListener(this);
       // okb.setForeground(Color.pink);
     //   okb.setBackground(Color.black);
        panal.add(okb);
        
        back.setBounds(190, 200, 80, 40);
        back.addActionListener(this);
      //  back.setForeground(Color.pink);
      //  back.setBackground(Color.black);
       
        panal.add(back);
        
        
    }
    
 /*  public static void main(String args[])
   {
       
   }*/
    

    public void actionPerformed(ActionEvent e)
    {
       if(e.getSource()==okb)
       {
           
           if (t_id.getText().equals(""))
            {

                JOptionPane.showMessageDialog(null, "Please enter correct id");

            } 
           else
            {
                
                try
                      {
      
                          
// String sql = "Delete employee_info5.name,employee_info5.id,employee_info5.cont,employee_info5.combo,employee_info5.date,employee_pay.position,employee_pay.bsalary,employee_pay.bonous from employee_info5,employee_pay where  id='"+ t_id.getText()+"' and employee_info5.sl_no=employee_pay.sl_no";                                                  
                          
//PreparedStatement ps = con.prepareStatement("Delete employee_info5.name,employee_info5.id,employee_info5.cont,employee_info5.combo,employee_info5.date,employee_pay.position,employee_pay.bsalary,employee_pay.bonous from employee_info5,employee_pay where  id='"+ t_id.getText()+"' and employee_info5.sl_no=employee_pay.sl_no");

 //PreparedStatement ps1 = con.prepareStatement("Delete from employee_info5,employee_pay where id='" + t_id.getText()+"'and  employee_info5.sl_no=employee_pay.sl_no ");
                      

           PreparedStatement ps = con.prepareStatement("Delete from employee_pay where id='" + t_id.getText()+"'");          
                       
                       ps.executeUpdate();
                  //  ps1.executeUpdate();
                    
                      JOptionPane.showMessageDialog(null, "Delete successfully");
                      
                      t_id.setText("");
                        
                      
                      }
                      
              
                 catch (SQLException sql)
                  {
                    JOptionPane.showMessageDialog(null,"The quere is wrong");

                  }
                   
                   
            }
            
                   
       }
    
      if(e.getSource()==back)
      {
       //   new MainFrame_Add_Student_Record(con);
        //  dispose();
      }
      
       
            
    }
     
}
/*class Max
{
    public static void main(String args[])
    {
     //  new Delete_Student_Record();
    }
}*/

