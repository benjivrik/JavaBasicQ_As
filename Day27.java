// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 27 : GUI for collecting User information - I
// Day 27 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

import java.awt.Dimension;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Box;



class GUI extends JPanel
{
    /**
     *
     */
    private static final long serialVersionUID = -6021547927386781783L;

    // GUI is your main panel
    public GUI()
    {
        JPanel imgPanel = new JPanel();
        JLabel imgLabel = new JLabel(new ImageIcon("img_data/android-chrome-192x192.png"));
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        imgLabel.setVerticalAlignment(JLabel.CENTER);
        imgLabel.setPreferredSize(new Dimension(200,270));
       
        imgPanel.setBackground(Color.WHITE);
        imgPanel.setPreferredSize(new Dimension(200, 270));

        imgPanel.add(
            imgLabel, BorderLayout.CENTER
            );
        

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.WHITE);

        // user input fields
        JTextField lastName, firstName;
        JLabel lastNameLabel, firstNameLabel,dateOfBirthLabel;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        JFormattedTextField dateTextField = new JFormattedTextField(format);
        
        lastName = new JTextField();
        lastNameLabel = new JLabel("Last name");
        firstName = new JTextField();
        firstNameLabel = new JLabel("First name");
        dateOfBirthLabel = new JLabel("Date of birth");
        
        JPanel inputsPanel = new JPanel();
        inputsPanel.setPreferredSize(new Dimension(250, 100));
        inputsPanel.setLayout(new BoxLayout(inputsPanel, BoxLayout.Y_AXIS));
        inputsPanel.setBackground(Color.WHITE);
        inputsPanel.add(lastNameLabel);
        inputsPanel.add(lastName);
        inputsPanel.add(firstNameLabel);
        inputsPanel.add(firstName);
        inputsPanel.add(dateOfBirthLabel);
        inputsPanel.add(dateTextField);

        // JButtons
        JButton submit, reset;
        submit = new JButton("Submit");
        submit.setMargin(new Insets(20,25,20,25));
        submit.setBackground(Color.WHITE);
        reset = new JButton("Reset");
        reset.setMargin(new Insets(20,25,20,25));
        reset.setBackground(Color.WHITE);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.WHITE);
        buttonsPanel.setPreferredSize(new Dimension(250, 50));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(submit);
        buttonsPanel.add(Box.createRigidArea(new Dimension(35, 0)));
        buttonsPanel.add(reset);
        

        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setPreferredSize(new Dimension(250, 270));
        infoPanel.add(Box.createRigidArea(new Dimension(250, 40)));
        infoPanel.add(inputsPanel);
        infoPanel.add(Box.createRigidArea(new Dimension(250,20)));
        infoPanel.add(buttonsPanel);
        infoPanel.add(Box.createRigidArea(new Dimension(250,50)));

        add(imgPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.EAST);
    }
}

public class Day27 
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("User registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GUI());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();


    }
}