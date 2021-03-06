package View;

import javax.swing.*;
import java.awt.*;

public class ViewSignUp extends JFrame {
    JLabel title = new JLabel("WELCOME -Selamat Menjadi Member Baru!-");

    JLabel lUser = new JLabel("Username : ");
    JTextField tfUser = new JTextField();
    JLabel lPass = new JLabel("Password : ");
    JTextField tfPass = new JTextField();

    public JButton btnSignUp = new JButton("Add Acount");
    public JButton btnAdd = new JButton("Log In");

    Color salem  = new Color(249, 239, 234);
    Color red2 = new Color(150, 54, 54);
    Color red = new Color(212, 76, 76);
    Color green2 = new Color(61, 99, 65);
    Color green = new Color(85, 138, 90);
    Color yellow = new Color(255, 196, 33);
    Color pink = new Color(255, 148, 177);

    Color bg = new Color(176, 208, 211);
    Color puce = new Color(192, 132, 151);
    Color orange  = new Color(247, 175, 157);
    Color peach = new Color(247, 227, 175);
    Color yellow2 = new Color(243, 238, 195);


    ImageIcon img = new ImageIcon("src\\Assets\\signup.jpg");
    JLabel logo = new JLabel(img);

    Font font = new Font("Helvetica",Font.PLAIN,25);

    public ViewSignUp(){
        getContentPane().setBackground(salem);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setBounds(400,50,1200,700);

        add(title);
        title.setBounds(270,50,800,50);
        title.setFont(new Font("Helvetica",Font.BOLD,25));

        add(logo);
        logo.setBounds(100,150,626,417);

        add(lUser);
        lUser.setBounds(850, 150, 200, 25);
        lUser.setFont(font);
        add(tfUser);
        tfUser.setBounds(850, 200, 200, 30);
        tfUser.setBackground(pink);

        add(lPass);
        lPass.setBounds(850, 250, 200, 25);
        lPass.setFont(font);
        add(tfPass);
        tfPass.setBounds(850, 300, 200, 30);
        tfPass.setBackground(pink);

        add(btnSignUp);
        btnSignUp.setBounds(900, 350, 100, 40);
        btnSignUp.setBackground(green);
        btnSignUp.setForeground(salem);

        add(btnAdd);
        btnAdd.setBounds(900, 430, 100, 40);
        btnAdd.setBackground(red);
        btnAdd.setForeground(peach);

    }

    public String getUser(){
        return tfUser.getText();
    }
    public String getPass(){
        return tfPass.getText();
    }

}
