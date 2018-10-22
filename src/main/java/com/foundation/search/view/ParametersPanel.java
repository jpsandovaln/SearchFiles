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
import java.awt.*;

/**
 * Class ParametersPanel receives all parameters to perform the search
 * and provides these parameters by get methods to be used by the Controller
 *
 * @author Emely LLanos
 * @version 1.0.
 */

public class ParametersPanel extends JPanel{

    private JLabel instruction;
    private JLabel textFilesFound;
    private JLabel nameLabel;
    private JTextField nameInput;
    private JLabel pathLabel;
    private JTextField pathInput;
    private JLabel extensionLabel;
    private JTextField extensionInput;
    private JLabel sizeLabel;
    private JTextField sizeInput;
    private JButton findButton;

    /**
     * The constructor of ResultsPanel class where the components are set
     * by invoking the setting() and init() method
     */
    public ParametersPanel() {
        super();
        setting();
        init();
    }

    /**
     * setting method sets the properties of this Panel.
     */
    private void setting() {
        //to define
    }

    /**
     * init method sets and initializes all the elements added
     * to this Panel.
     */
    private void init() {
        //Initializing the components
        instruction = new JLabel("Please enter the parameters to perform the search");
        textFilesFound = new JLabel("All files found according to the criteria set:");
        nameLabel = new JLabel("Name:");
        nameInput = new JTextField();
        pathLabel = new JLabel("Path:");
        pathInput = new JTextField();
        extensionLabel = new JLabel("Extension:");
        extensionInput = new JTextField();
        sizeLabel = new JLabel("Size: ");
        sizeInput = new JTextField();
        findButton = new JButton("Search");
        //creating the layout that will contain every sub-panel
        setLayout(new BorderLayout());
        //creating the sub-panel displayed in the header
        JPanel upPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        upPanel.add(instruction);
        upPanel.add(findButton);
        //creating the sub-panel where the text of Files found is displayed
        //right above the table
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(new JLabel(" "));
        bottomPanel.add(new JLabel(" "));
        bottomPanel.add(new JSeparator());
        bottomPanel.add(textFilesFound);
        //creating the sub-panel where all the input fields will be displayed
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,7,3,4));
        centerPanel.add(new JLabel(" "));
        centerPanel.add(pathLabel);
        centerPanel.add(pathInput);
        centerPanel.add(new JLabel(" "));
        centerPanel.add(nameLabel);
        centerPanel.add(nameInput);
        centerPanel.add(new JLabel(" "));
        centerPanel.add(new JLabel(" "));
        centerPanel.add(extensionLabel);
        centerPanel.add(extensionInput);
        centerPanel.add(new JLabel(" "));
        centerPanel.add(sizeLabel);
        centerPanel.add(sizeInput);
        centerPanel.add(new JLabel(" "));
        //adding all sub-panels to the main panel
        add(upPanel,BorderLayout.NORTH);
        add(bottomPanel,BorderLayout.SOUTH);
        add(centerPanel,BorderLayout.CENTER);
    }

    /**
     * This method returns the button to be able to perform the
     * listener from controller class
     *
     * @return findButton
     */
    public JButton getSearchButton(){
        return findButton;
    }

    /**
     * This method returns the size input provided
     *
     * @return sizeInput
     */
    public JTextField getSizeInput(){
        return sizeInput;
    }

    /**
     * This method returns the path provided
     *
     * @return pathInput
     */
    public JTextField getPathInput(){
        return pathInput;
    }

    /**
     * This method returns the File Name provided
     *
     * @return nameInput
     */
    public JTextField getNameInput(){
        return nameInput;
    }

    /**
     * This method returns the extention entered
     *
     * @return extensionInput
     */
    public JTextField getExtensionInput(){
        return extensionInput;
    }
}