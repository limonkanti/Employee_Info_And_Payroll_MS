
package hrm_ms;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Emp_Pay_Record implements ActionListener 
{

    JFrame frame1,frame2;
    JTextField textbox;
    JLabel label;
    JButton button;
    JPanel panel, panel1;
    JTable table;
    String[] columnNames = { "Id","Position","B.Salary","Bonous"};
    Connection con;
    Statement st;
    ResultSet rs;
    Emp_Pay_Record(Connection con) 
    {
        this.con=con;
        frame1=new JFrame("Database search result");
        frame1.setLayout(null);
        textbox = new JTextField();
        textbox.setBounds(165, 40, 150, 40);
        label = new JLabel("Enter employee id :");//
        label.setBounds(45, 40, 115, 40);//
        button = new JButton("Search");//
        button.setBounds(125, 130, 130, 30);//
        button.addActionListener(this);//
        frame1.add(textbox);
        frame1.add(label);
        frame1.add(button);
        frame1.setVisible(true);
        frame1.setSize(380, 230);
        frame1.setLocation(480, 180);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==button)
        {
            showTableData();
        }
       // button = (JButton) ae.getSource();
       // System.out.println("Showing Table Data.......");
      //  showTableData();
    }

    public void showTableData()
    {

       frame2=new JFrame("Database search result");
       frame2.setLayout(new BorderLayout());
     

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        table = new JTable();
        table.setModel(model);
      
        JScrollPane scroll = new JScrollPane(table);
    
        String textvalue = textbox.getText();
      
        String id = "";
        String position = "";
        String bsalary = "";
        String bonous = "";
        try {
           
     String sql = "select * from employee_pay where id ='"+textvalue+"'";
     
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            if (rs.next()) {
               
                id = rs.getString("id");
                position = rs.getString("position");
                bsalary = rs.getString("bsalary");
                bonous = rs.getString("bonous");

                model.addRow(new Object[]{id, position,bsalary,bonous});
                i++;
            }
            if (i < 1) 
            {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) 
            {
                System.out.println(i + " Record Found");
            } 
            else 
            {
                System.out.println(i + " Records Found");
            }
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);//
        }
        frame2.add(scroll);//
        frame2.setVisible(true);//
        frame2.setSize(500, 500);//
        frame2.setLocation(480, 140);
    }

}

