
package hrm_ms;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainFrame_Help extends JInternalFrame
{
    JPanel panal=new JPanel();

    ImageIcon ic=new ImageIcon("image/SDC16059.jpg");
    //ImageIcon ic=new ImageIcon("help.png");
    JLabel imag=new JLabel(ic);

    JLabel line,label1,label2,label3,label4,label5,label6,label7;

    MainFrame_Help()
    {
        super("Help Instruction",true,true,true,true);
        //("Books",new ImageIcon("library.jpg"));
        
      //  panal.setBackground(Color.darkGray);
        //panal.setForeground(Color.pink);
        panal.setLayout(null);
        
        add(panal);
        setSize(860,590);
        setVisible(true);
        setResizable(false);
        setLocation(200,80);

        picture_add();
        label_use();
    }
    void picture_add()
    {
       //imag.setBounds(5, 0, 900, 550);

        imag.setBounds(80, 50, 620, 150);
        imag.setBackground(Color.white);
        imag.setForeground(Color.pink);
        panal.add(imag);
       // panal.add(imag);

    }
    void label_use()
    {

        line=new JLabel("UNIVERSITY      OF      CHITTAGONG     "
                );
       // line.setBackground(Color.white);
      //  line.setForeground(Color.pink);
        line.setBounds(280, 10,250 , 30);
        panal.add(line);





        label1=new JLabel("Using instruction of the System:");
        label1.setBounds(200, 200, 300, 100);
        panal.add(label1);



        label2=new JLabel("1)  Enter   book code of the book   .");
        label2.setBounds(230, 220, 640, 100);
       // label2.setForeground(Color.pink);
        panal.add(label2);


        label3=new JLabel("2)  Enter  the address of the student  .");
        label3.setBounds(230, 250, 640, 100);
       // label3.setForeground(Color.pink);
        panal.add(label3);


        label4=new JLabel("3)  Enter  depertment of the student  .");
        label4.setBounds(230, 280, 640, 100);
       // label4.setForeground(Color.pink);
        panal.add(label4);

        label5=new JLabel("4)  Enter  id no. of the student  .");
        label5.setBounds(230, 310, 640, 100);
       // label5.setForeground(Color.pink);
        panal.add(label5);


        label6=new JLabel("5)  Enter  mobile no. of the student  .");
        label6.setBounds(230, 340, 640, 100);
        //label6.setForeground(Color.pink);
        panal.add(label6);

        label7=new JLabel("6)  Enter  e-mail id of the student  .");
        label7.setBounds(230, 370, 640, 100);
        //label7.setForeground(Color.pink);
        panal.add(label7);


    }


}
/*class hlp
{
    public static void main(String args[])
    {
       //Help_Frame ob=new Help_Frame();
     //  new  Help_Frame();
    }
}*/

