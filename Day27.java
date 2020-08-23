// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 26 : GUI for collecting user information
// Day 26 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;



class GUI extends JPanel
{
    // GUI is your main panel
    public GUI()
    {
        JPanel imgPanel = new JPanel();
        JLabel imgLabel = new JLabel(new ImageIcon("img_data/android-chrome-192x192.png"));
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        imgLabel.setVerticalAlignment(JLabel.CENTER);
        imgLabel.setPreferredSize(new Dimension(300,400));
       
        imgPanel.setBackground(Color.WHITE);
        imgPanel.setPreferredSize(new Dimension(300, 400));

        imgPanel.add(
            imgLabel, BorderLayout.CENTER
            );
        

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.WHITE);

        JPanel previewPanel = new JPanel();
        previewPanel.setBackground(Color.BLUE);
        previewPanel.setPreferredSize(new Dimension(100, 100));

        JPanel pointsPanel = new JPanel();
        pointsPanel.setBackground(Color.RED);
        pointsPanel.setPreferredSize(new Dimension(100, 50));

        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setPreferredSize(new Dimension(100, 400));
        infoPanel.add(previewPanel);
        infoPanel.add(pointsPanel);

        add(imgPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.EAST);
    }
}

public class Day27 
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Java Rules");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GUI());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);


    }
}