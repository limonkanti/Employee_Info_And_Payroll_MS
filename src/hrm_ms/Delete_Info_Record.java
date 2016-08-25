
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


public class Delete_Info_Record extends JFrame implements ActionListener
{
    
    
    JLabel idlabel=new JLabel("Enter Id  :");
    
    JLabel line_label=new JLabel("Please enter correct id for deleting employee information record");
    
    JTextField t_id=new JTextField(15);
    
    JButton okb=new JButton(" Ok ");
    
    JButton back=new JButton(" Back ");
    
    JPanel panal=new JPanel();
    
  
    Connection con;
    Statement st = null;//help access to the database
    ResultSet rs;
    
   Delete_Info_Record(Connection con)
    {
        super("Delete Information Record");
        pack();
        this.con=con;
        
        panal.setLayout(null);
        add(panal);
        panal.setBackground(Color.darkGray);
        setSize(380,330);
        setVisible(true);
        setResizable(false);
        setLocation(480,180);
        la_tfild();
        
        
    }
    void la_tfild()
    {
        line_label.setBounds(15, 10, 350, 40);
        line_label.setForeground(Color.pink);
        panal.add(line_label);
        
        idlabel.setBounds(80, 80, 60, 40);
        idlabel.setForeground(Color.pink);
        panal.add(idlabel);
        
        t_id.setBounds(150, 80, 100, 40);
       // pnal.add(t_id);
        panal.add(t_id);
      //  pnal.add(this);
        okb.setBounds(90, 200, 80, 40);
        okb.addActionListener(this);
        okb.setForeground(Color.pink);
        okb.setBackground(Color.black);
        panal.add(okb);
        
        back.setBounds(190, 200, 80, 40);
        back.addActionListener(this);
        back.setForeground(Color.pink);
        back.setBackground(Color.black);
        panal.add(back);
        
    }

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
                
                try {

           PreparedStatement ps = con.prepareStatement("Delete from employee_info5 where id='" + t_id.getText()+"'");          
                       
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Record deleted successfully");
            
        }             
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());//
        }       
                   
       }           
       }
    
  //    if(e.getSource()==back)
    //  {
       //   new MainFrame_Add_Student_Record(con);
     //   //  dispose();
     // }
    }
     
}
