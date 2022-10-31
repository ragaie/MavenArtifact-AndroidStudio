package org.example;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    static JLabel label;
    public static void main(String[] args) {
        System.out.println("Welcome to Ragaie test");
        createUI();
    }
     static void createUI (){
        JFrame frame = new JFrame("KPIT test read file");
        frame.setVisible(true);
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

         //GridBagLayout gridbag = new GridBagLayout();
        frame.add(panel);
        JButton button = new JButton("Select your file");
        panel.add(button);

        // gridbag.setConstraints(button, GridBagConstraints.CENTER);
         panel.add(button);

        button.addActionListener (new Action1());
        label = new JLabel("");
        label.setVerticalAlignment(1);
         panel.add(label);
    }
    static class Action1 implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            openFileDirectory();
        }
    }
     static void openFileDirectory() {
        // create user file selector dialog
        FileDialog dialog = new FileDialog((Frame)null, "Select File to count words");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);

        // get file name and path
        String fileName = dialog.getFile();
        String path = dialog.getDirectory() + dialog.getFile();

        if (!path.equals("nullnull")) {
            // create instance form our api
            KPITApi wordCounter = new KPITApi();
            // call api to count file words inside try catch to handle any run time error.
            try {
                int count = wordCounter.countFileWords(path);
                label.setText(fileName + " have -->  " + count + " words");
            } catch (Exception e) {
                // generic error handling we can add different catch for every specific exception
                // but here only showing exception message for user.
                label.setText("Error message " + e.toString());
            }
        }
    }


}