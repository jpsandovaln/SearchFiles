/*
 *  Copyright (c) 2018 Jalasoft.
 *  2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of
 *  Jalasoft, ("Confidential Information").  You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jalasoft.
 *
 */

package com.foundation.search.view;

import javax.swing.*;

public class MainPanel extends JPanel {

    private JLabel text;
    private JLabel nameLabel;
    private JTextField nameInput;
    private JLabel pathLabel;
    private JTextField pathInput;
    private JButton findButton;

    public MainPanel() {
        super();
        configureWindow();
        initializeComponents();
    }

    private void configureWindow() {
        this.setSize(510, 410);
        this.setLayout(null);
    }

    private void initializeComponents() {
        // creating the components
        text = new JLabel();
        nameLabel = new JLabel();
        nameInput = new JTextField();
        pathLabel = new JLabel();
        pathInput = new JTextField();
        findButton = new JButton();

        // configuring the components
        text.setText("Please provide the information to help you to search the files you need");
        text.setBounds(50, 40, 400, 25);
        nameLabel.setText("Name: ");
        nameLabel.setBounds(50, 70, 50, 25);
        nameInput.setBounds(150, 70, 100, 25);
        pathLabel.setText("Path: ");
        pathLabel.setBounds(50, 100, 50, 25);
        pathInput.setBounds(150, 100, 100, 25);
        findButton.setText("Search");
        findButton.setBounds(150, 150, 200, 30);

        // adding the components to the window
        this.add(text);
        this.add(nameLabel);
        this.add(nameInput);
        this.add(pathLabel);
        this.add(pathInput);
        this.add(findButton);
    }

    public JButton getSearchButton(){
        return findButton;
    }

    /*@Override
    public void actionPerformed(ActionEvent e) {
        String name = nameInput.getText();
        String path = pathInput.getText();
        JOptionPane.showMessageDialog(this, "I will search the file:  '"
                + name + "' in the following path: " + path);
    }

    public static void main(String[] args) {
        MainPanel panel = new MainPanel();
        panel.setVisible(true);
    }*/
}
