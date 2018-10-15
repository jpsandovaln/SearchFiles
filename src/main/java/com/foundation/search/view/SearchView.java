/**
 * Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jalasoft, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */

package com.foundation.search.view;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 * Class SearchView that will receive the data to search and will have communication with the controller
 *
 * @author Emely LLanos
 * @version 1.0.
 */

public class SearchView extends JFrame implements ActionListener{

    private JLabel nameLabel;
    private JTextField nameInput;
    private JLabel pathLabel;
    private JTextField pathInput;
    private JButton findButton;

    public SearchView() {
        super();
        configureWindow();
        initializeComponents();
    }

    private void configureWindow() {
        this.setTitle("Search Files ");
        this.setSize(510, 410);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeComponents() {
        // creating the components
        nameLabel = new JLabel();
        nameInput = new JTextField();
        pathLabel = new JLabel();
        pathInput = new JTextField();
        findButton = new JButton();
        // configuring the components
        nameLabel.setText("Please input the name of the file to search");
        nameLabel.setBounds(50, 40, 300, 25);
        nameInput.setBounds(380, 40, 100, 25);
        pathLabel.setText("Please input the path where you want to search");
        pathLabel.setBounds(50, 70, 300, 25);
        pathInput.setBounds(380, 70, 100, 25);

        findButton.setText("Search");
        findButton.setBounds(150, 120, 200, 30);
        findButton.addActionListener(this);
        // adding the components to the window
        this.add(nameLabel);
        this.add(nameInput);
        this.add(pathLabel);
        this.add(pathInput);
        this.add(findButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameInput.getText();
        String path = pathInput.getText();
        JOptionPane.showMessageDialog(this, "I will search the file:  '"
                + name + "' in the following path: " + path);
    }

    public static void main(String[] args) {
        SearchView view = new SearchView();
        view.setVisible(true);
    }
}