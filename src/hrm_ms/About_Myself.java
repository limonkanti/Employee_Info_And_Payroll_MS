
package hrm_ms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class About_Myself extends JFrame implements ActionListener
{

    JPanel panal=new JPanel();
    
    ImageIcon ic=new ImageIcon("image/limon111.jpg");
    JLabel imag=new JLabel(ic);

    JLabel line,line2,label1,label2,label3,label4,label5,label6,label7;

    About_Myself()
    {
        super("About Ours");
       
        panal.setLayout(null);

        add(panal);
        setSize(860,590);
        setVisible(true);
        setResizable(false);
        //setLocation(200,80);

        picture_add();
        label_use();
    }
    void picture_add()
    {
     

        imag.setBounds(80, 100, 620, 200);

        panal.add(imag);


    }
    void label_use()
    {

        line=new JLabel(" DESIGN AND DEVELOPED BY ");
        
        line.setBounds(250, 20,250 , 30);
        panal.add(line);


        line2=new JLabel(" LIMON KANTI DEY................. ");
     
        line2.setBounds(350, 50,250 , 30);
        panal.add(line2);



        label1=new JLabel("MY AIM IS TO BECOME A:");
        label1.setBounds(250, 280, 300, 100);
     
        panal.add(label1);



        label2=new JLabel("1). JAVA SE AND JAVA EE   DEVELOPER ");
        label2.setBounds(350, 300, 640, 100);
       
        panal.add(label2);


        label3=new JLabel("2). JAVA WEB   DEVELOPER   ");
        label3.setBounds(350, 330, 640, 100);
    
        panal.add(label3);

        label4=new JLabel("3). JAVA ANDROID DEVELOPER");
        label4.setBounds(350, 360, 640, 100);
      
        panal.add(label4);


    }
  /* public static void main(String args[])
    {

      new  About_Myself();
    }*/
    

    public void actionPerformed(ActionEvent eb)
    {


    }


}

