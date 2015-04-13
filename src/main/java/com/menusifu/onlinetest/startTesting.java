package com.menusifu.onlinetest;

import javax.swing.*;

/**
 * Created by kai on 4/13/2015.
 */
public class startTesting {
    private JButton button1;
    private JButton button2;
    private JPanel JPanel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("startTesting");
        frame.setContentPane(new startTesting().JPanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
