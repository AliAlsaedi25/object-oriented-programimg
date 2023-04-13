import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

import static java.awt.SystemColor.text;


public class User implements ISub, ActionListener
{

    public void notify (String name, String message){
        textField1.append(name + ": "+ message + "\n");
    }

    public void actionPerformed (ActionEvent arg0){
        textField1.setText(text);
    }

    public String name;
    public Server chatroom;
    public JTextArea textField1;
    public JTextArea textField2;
    public String text;



    public User(String name, Server chatroom){

        this.name = name;
        this.chatroom = chatroom;
        this.chatroom.subscribe(name,this);
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel(name), BorderLayout.NORTH);
        textField1 = new JTextArea(15,15);
        textField2 = new JTextArea(15,15);
        panel1.add(textField1, BorderLayout.NORTH);
        panel1.add(textField2, BorderLayout.SOUTH);
        JButton button = new JButton("SEND");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                text = textField2.getText();
                String h = name;
                String x = ( h + " ");
                chatroom.display(x,text);
                textField2.setText("");
            }
        });
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.setSize(10,10);
        panel1.add(button,BorderLayout.SOUTH);
        frame.add(panel1,BorderLayout.SOUTH);


        frame.pack();
        frame.setVisible(true);


    }

}
//done
