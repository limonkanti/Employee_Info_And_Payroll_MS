package hrm_ms;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.*;
import javax.print.DocFlavor;
import javax.swing.*;

public class Print_Preview extends JFrame implements ActionListener, Printable {

    JPanel panel = new JPanel();
    SpinnerModel model;
    JSpinner spinner;
    JComponent editor;
    JLabel label1 = new JLabel("Salary Preview");
    JLabel ml = new JLabel("For the month :");

    JLabel bpl = new JLabel("Basic Pay        :");
    JTextField tbpl = new JTextField(15);

    JLabel al = new JLabel("Allowance");
    JLabel all = new JLabel("------------------");

    JLabel abl = new JLabel("Attendence bonus :");
    JTextField atbl = new JTextField(15);
    JLabel fbl = new JLabel("Festival bonus        :");
    JTextField tfbl = new JTextField(15);

    JButton tb = new JButton("Total");
    JTextField ttb = new JTextField(15);

    JButton printview = new JButton("Preview");
    JButton cb = new JButton("Cancel");
    String s1, s2, s3, s4;
    int n;

    Print_Preview() {
        super("Print_Preview");
        panel.setLayout(null);
        add(panel);
        setSize(600, 550);
        setLocation(290, 80);
        setVisible(true);

        add_button();
    }

    void add_button() {

        label1.setBounds(250, 10, 100, 50);
        panel.add(label1);

        ml.setBounds(170, 60, 90, 40);
        panel.add(ml);
        model = new SpinnerDateModel();
        spinner = new JSpinner(model);
        // editor = new JSpinner.DateEditor(spinner, " dd MMMM yyyy");
        editor = new JSpinner.DateEditor(spinner, "MMMM yyyy");
        spinner.setEditor(editor);
        spinner.setBounds(260, 60, 115, 40);
        panel.add(spinner);

        bpl.setBounds(170, 110, 90, 40);
        panel.add(bpl);
        tbpl.setBounds(260, 110, 115, 40);
        panel.add(tbpl);

        al.setBounds(260, 150, 100, 40);
        panel.add(al);
        all.setBounds(250, 175, 100, 10);
        panel.add(all);

        abl.setBounds(160, 190, 110, 40);
        panel.add(abl);
        atbl.setBounds(280, 190, 100, 40);
        panel.add(atbl);

        fbl.setBounds(160, 240, 110, 40);
        panel.add(fbl);
        tfbl.setBounds(280, 240, 100, 40);
        tfbl.addActionListener(this);
        panel.add(tfbl);

        tb.setBounds(170, 300, 100, 40);
        tb.addActionListener(this);
        panel.add(tb);
        ttb.setBounds(280, 300, 100, 40);
        // ttb.addActionListener(this);
        panel.add(ttb);

        printview.setBounds(170, 430, 100, 40);
        panel.add(printview);
        printview.addActionListener(this);
        cb.setBounds(280, 430, 100, 40);
        panel.add(cb);
        cb.addActionListener(this);

    }

    public static void main(String args[]) {
        Print_Preview obp = new Print_Preview();

    }

    public void actionPerformed(ActionEvent e) {
        s1 = tbpl.getText();
        s2 = atbl.getText();
        s3 = tfbl.getText();
        if (e.getSource() == printview) {
            PrinterJob printJob = PrinterJob.getPrinterJob();
           
            printJob.setPrintable(this);
            if (printJob.printDialog()) {
                try {
                    cb.setText("");
                    printview.setText("");
                    panel.setBorder(null);
                    cb.setBorder(null);
                    printJob.print();
                   //  JTable.print(JTable.PrintMode.FIT_WIDTH, header, null);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }

        }

        if (e.getSource() == tb) {

            n = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
            ttb.setText(String.valueOf(n));

        }

    }

    public int print(Graphics g, PageFormat pf, int index) throws PrinterException {
        Graphics2D g2 = (Graphics2D) g;
        if (index >= 1) {
            return Printable.NO_SUCH_PAGE;
        } else {
            //ok.printAll(g2);
            this.printAll(g2);
           // this.print(g, pf, index)
            return Printable.PAGE_EXISTS;
        }
    }

}
