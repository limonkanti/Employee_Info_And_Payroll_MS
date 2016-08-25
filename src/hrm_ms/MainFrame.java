
package hrm_ms;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.*;


public class MainFrame extends JFrame implements ActionListener
{
    
    Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
    JPanel panel=new JPanel();
    JPanel npanel=new JPanel();
    JMenu fmenu,vmenu,pmenu,amenu,hmenu;
    JMenuItem eis,eps,eedit,epedit,edelete,epdelete,vips,vseir,vsepr,vcheckid,abitem,hitem,pritem;
    JMenuBar mb;
    JToolBar tb;
    JButton b1,b2;
    ImageIcon ic;
    JLabel label,label2,anilabel;
    JToolBar tob;
    JButton exitb,saveb;
    ImageIcon icc;
    JDesktopPane dp=new JDesktopPane();
    Connection con;
    Statement st;
    ResultSet rs;
    
    
    MainFrame(Connection con)
    {
         
      
        super("MainFrame");
        this.con=con;
        panel.setLayout(null);
        add(panel);
        setSize(dim); 
       // setSize(1400,740);
//anilabel=new JLabel("<html><p style='color: #ff0ff; font-size:20pt'>Hi I am Limon kanti dey</p></html>");
//anilabel.setHorizontalTextPosition(SwingConstants.CENTER);
//anilabel.setSize(300,300);
//(anilabel);   
        add(dp);
        setVisible(true);
        add_menu();
        add_toolbar();
      //  animation_text();
       
    }
        
  void add_menu()

        {
       
            fmenu=new JMenu("File");
            vmenu=new JMenu("View");
            pmenu=new JMenu("Print");
            amenu=new JMenu("About");
            hmenu=new JMenu("Help");
            mb=new JMenuBar();
            fmenu.setMnemonic(KeyEvent.VK_F);
            vmenu.setMnemonic(KeyEvent.VK_V);
            pmenu.setMnemonic(KeyEvent.VK_P);
            amenu.setMnemonic(KeyEvent.VK_A);
            hmenu.setMnemonic(KeyEvent.VK_H);
            fmenu.setToolTipText("File");
            vmenu.setToolTipText("View");
            pmenu.setToolTipText("Print");
            amenu.setToolTipText("About");
            
            hmenu.setToolTipText("Help");   
            eis=new JMenuItem("Employee Information System",new ImageIcon("image/emp.png"));
            eis.addActionListener(this);
            eps=new JMenuItem("Employee Payroll System",new ImageIcon("image/Business.png"));
            eps.addActionListener(this);
            eedit=new JMenuItem("Edit Employee Information System",new ImageIcon("image/employee.png"));
            eedit.addActionListener(this);
            
            epedit=new JMenuItem("Edit Employee Payroll System",new ImageIcon("image/edit.png"));
            epedit.addActionListener(this);
            
            edelete=new JMenuItem("Delete Employee Information System",new ImageIcon("image/exits.png"));
            edelete.addActionListener(this);
            
            epdelete=new JMenuItem("Delete Employee Payroll System",new ImageIcon("image/delete.png"));
            epdelete.addActionListener(this);
            
            vips=new JMenuItem("View Info. And Payroll System",new ImageIcon("image/order details.png"));
            vips.addActionListener(this);
            vseir=new JMenuItem("Search Emp Info Record");
            vseir.addActionListener(this);
            
            vsepr=new JMenuItem("Search Emp Payroll Record");
            vsepr.addActionListener(this);
            
            
            
            abitem=new JMenuItem("About Myself",new ImageIcon("image/author.png"));
            abitem.addActionListener(this);
          //  hitem.addActionListener(this);
            hitem=new JMenuItem("Help",new ImageIcon("image/help.png"));
            hitem.addActionListener(this);
            
            pritem=new JMenuItem("Print",new ImageIcon("image/print.gif"));
            pritem.addActionListener(this);
            fmenu.add(eis);
            fmenu.addSeparator();
            fmenu.add(eps);
            fmenu.addSeparator();
            fmenu.add(eedit);
            fmenu.addSeparator();
            fmenu.add(epedit);
            fmenu.addSeparator();
            fmenu.add(edelete);
            fmenu.addSeparator();
            fmenu.add(epdelete);
            fmenu.addSeparator();
            
            vmenu.add(vips);
            vmenu.add(vseir);
            vmenu.add(vsepr);
            
            amenu.add(abitem);
            pmenu.add(pritem);
            hmenu.add(hitem);       
            
            
            mb.add(fmenu);
            mb.add(vmenu);
            mb.add(pmenu);
            mb.add(amenu);
            mb.add(hmenu);
            setJMenuBar(mb);
        }
  void add_toolbar()
  {
      
      saveb=new JButton(new ImageIcon("image/SAVE.GIF"));
      exitb=new JButton(new ImageIcon("image/Exit.gif"));
      exitb.setToolTipText("Exit");
      exitb.addActionListener(this);
      saveb.setToolTipText("Save");
      saveb.addActionListener(this);
      npanel.setLayout(new FlowLayout());
      tob=new JToolBar("Toolbar",JToolBar.HORIZONTAL);
      tob.add(exitb);
      tob.add(saveb);
      tob.setBorderPainted(true);//
      add(tob,BorderLayout.NORTH);
  
  }
   void animation_text()
      {
          
          
          int x=1;
          int y=5;
         
          try{
              while(x<1000)
                    {
                    anilabel.setLocation(x,y);
                    Thread.sleep(150);
                    x+=30;
                    y+=30;
                    
                    if(x>1000) x=1;
                    if(y>500) y=5;
 
                    } 
   
             }
          catch(InterruptedException ie){System.out.println("Interrupted...");}
          
     
      }
   /*public static void main(String args[])
    {
     MainFrame objec=new MainFrame(con);
      
    }*/
 
    public void actionPerformed(ActionEvent em) 
    {
        if(em.getSource()==exitb)
        {
            System.exit(0);
        }
        if(em.getSource()==abitem)
        {
            new About_Myself();
        }
        if(em.getSource()==eis)
        {
            Emp_Info_Frame info=new Emp_Info_Frame(con);
            dp.add(info);
        }
        if(em.getSource()==eps)
        {
             Emp_Payroll_Frame payroll=new  Emp_Payroll_Frame(con);
             dp.add(payroll);
        }  
        if(em.getSource()==hitem)
        {
            MainFrame_Help mp=new MainFrame_Help();
            dp.add(mp);
        }
        if(em.getSource()==eedit)
        {
            Update_Emp_Info_Record ou=new Update_Emp_Info_Record(con);
            
        }
       if(em.getSource()==epedit)
        {
            Update_Emp_Payroll_Record op=new Update_Emp_Payroll_Record(con);
            
        }
      if(em.getSource()==vips)
        {
            View_Emp_Info_And_Payroll_Record ov=new View_Emp_Info_And_Payroll_Record(con);
         
        }   
       if(em.getSource()==edelete)
        {
            Delete_Info_Record od=new Delete_Info_Record(con);
            
        } 
        if(em.getSource()==epdelete)
        {
           // Delete_Payroll_Record oop=new Delete_Payroll_Record(con);
            
             Delete_Payroll_Record op=new Delete_Payroll_Record(con);
            
        } 
        if(em.getSource()==pritem)
        {
            new Print_Preview();
        }
        
      if(em.getSource()==vseir)
        {
           new Emp_Info_Record(con);
        }
      if(em.getSource()==vsepr)
        {
           new Emp_Pay_Record(con);
        }
      
    }
         
}


