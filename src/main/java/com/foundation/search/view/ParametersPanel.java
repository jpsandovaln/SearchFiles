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

import javax.imageio.ImageIO;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.io.File;

/**
 * Class ParametersPanel receives all parameters to perform the search
 * and provides these parameters by get methods to be used by the Controller
 *
 * @author Emely LLanos
 * @version 1.0.
 */

public class ParametersPanel extends JPanel implements ItemListener {

    private JTextField nameInput;
    private JTextField pathInputLabel;
    private JFileChooser pathInput;
    private JButton btnBrowse;
    private JComboBox extensionInput;
    private JTextField ownerInput;
    private JTextField contentInput;
    private JTextField sizeInput;
    private JComboBox sizeComparison;
    private JComboBox sizeUnit;
    private String sizeData[];
    private JButton findButton;
    private JButton cleanButton;
    private JCheckBox hidden;
    private JCheckBox read_only;
    private JCheckBox only_files;
    private boolean hiddenCH = false;
    private boolean read_onlyCH = false;
    private boolean only_filesCH = false;

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
        //Creating the labels
        JLabel pathLabel = new JLabel("    Location (Mandatory):");
        JLabel nameLabel = new JLabel("    By Name:");
        JLabel extensionLabel = new JLabel("    By Extension:");
        JLabel sizeLabel = new JLabel("    By Size: ");
        JLabel ownerLabel = new JLabel("    By owner: ");
        JLabel contentLabel = new JLabel("    By content(Only Files): ");
        //defining the browse button
        pathInputLabel = new JTextField();
        btnBrowse = new JButton("Browse");
        pathInput = new JFileChooser();
        btnBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pathInput.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                pathInput.setAcceptAllFileFilterUsed(false);
                int rVal = pathInput.showOpenDialog(null);
                if (rVal == JFileChooser.APPROVE_OPTION) {
                    pathInputLabel.setText(pathInput.getSelectedFile().toString());
                }
            }
        });
        //initializing the inputs, comboboxes and checkboxes
        nameInput = new JTextField();
        String[] extensions = {"exe", "png","mp4","pdf","mp4","jpg","txt","xls",
                                        "xcls","sh","java","php","bat","avi"};
        extensionInput = new JComboBox(extensions);
        sizeInput = new JTextField();
        String[] comparisonSelection = {"<", ">","="};
        sizeComparison = new JComboBox(comparisonSelection);
        String[] units = {"MB", "GB","KB","byte"};
        sizeUnit=new JComboBox(units);
        ownerInput = new JTextField();
        contentInput = new JTextField();
        findButton = new JButton("Search");
        cleanButton = new JButton("Clean");
        hidden = new JCheckBox("Include Hidden Files");
        hidden.setMnemonic(KeyEvent.VK_D);
        hidden.setSelected(false);
        read_only = new JCheckBox("Include Read-Only Files");
        read_only.setMnemonic(KeyEvent.VK_D);
        read_only.setSelected(false);
        only_files = new JCheckBox("Include Files Only");
        only_files.setMnemonic(KeyEvent.VK_D);
        only_files.setSelected(false);
        //Registering a listener for the checkBoxes
        hidden.addItemListener(this);
        read_only.addItemListener(this);
        only_files.addItemListener(this);
        //creating the layout that will contain every sub-panel
        setLayout(new BorderLayout());
        //Creating instructions panel
        JPanel instructionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        instructionsPanel.setBackground(Color.LIGHT_GRAY);
        try {
            BufferedImage image = ImageIO.read(new File("E:/searchD/src/main/java/com/foundation/search/view/pictures/Background.png"));
            JLabel label = new JLabel(new ImageIcon(image));
            instructionsPanel.add(label);
        }
        catch(Exception exception){
            System.out.println("Unable to open the picture");
        }
        //Creating buttons panel
        JPanel rightside = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setPreferredSize(new Dimension(3,300));
        rightside.add(separator);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.Y_AXIS));
        buttonsPanel.add(findButton);
        buttonsPanel.add(new JLabel(" "));
        buttonsPanel.add(cleanButton);
        buttonsPanel.add(new JLabel(" "));
        rightside.add(buttonsPanel);
        //creating the sub-panel where all the input fields will be displayed
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        centerPanel.setLayout(new GridBagLayout());
        //Path parameters
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        centerPanel.add(pathLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.ipady = 2;
        c.gridx = 1;
        c.gridy = 0;
        centerPanel.add(pathInputLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 4;
        c.gridy = 0;
        centerPanel.add(btnBrowse, c);
        //File Name and extension parameters
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 22;
        c.gridx = 0;
        c.gridy = 1;
        centerPanel.add(nameLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        c.gridx = 1;
        c.gridy = 1;
        centerPanel.add(nameInput, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;
        centerPanel.add(extensionLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        c.gridx = 4;
        c.gridy = 1;
        centerPanel.add(extensionInput, c);
        //by content and owner parameters
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 22;
        c.gridx = 0;
        c.gridy = 2;
        centerPanel.add(ownerLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        c.gridx = 1;
        c.gridy = 2;
        centerPanel.add(ownerInput, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        centerPanel.add(contentLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        c.gridx = 4;
        c.gridy = 2;
        centerPanel.add(contentInput, c);
        //by size
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 22;
        c.gridx = 0;
        c.gridy = 3;
        centerPanel.add(sizeLabel, c);
        c.weightx = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        c.gridx = 1;
        c.gridy = 3;
        centerPanel.add(sizeComparison, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 5;
        c.gridx = 2;
        c.gridy = 3;
        centerPanel.add(sizeInput, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        c.gridx = 3;
        c.gridy = 3;
        centerPanel.add(sizeUnit, c);
        //by hidden, rea-only, only-Files
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 22;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 4;
        centerPanel.add(hidden, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 22;
        c.gridwidth = 2;
        c.gridx = 2;
        c.gridy = 4;
        centerPanel.add(read_only, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 22;
        c.gridwidth = 2;
        c.gridx = 4;
        c.gridy = 4;
        centerPanel.add(only_files, c);
       //main division
        JButton button;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 5;
        centerPanel.add(new JLabel(" "), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 5;
        centerPanel.add(new JLabel(" "), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 5;
        centerPanel.add(new JLabel(" "), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 5;
        centerPanel.add(new JLabel(" "), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 5;
        centerPanel.add(new JLabel(" "), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 5;
        centerPanel.add(new JLabel(" "), c);
        add(instructionsPanel, BorderLayout.LINE_START);
        add(centerPanel,BorderLayout.CENTER);
        add(rightside, BorderLayout.LINE_END);
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
     * This method returns the button to be able to perform the
     * listener from controller class
     *
     * @return cleanButton
     */
    public JButton getCleanButton(){
        return cleanButton;
    }

     /**
     * This method returns the path provided
     *
     * @return pathInput
     */
     public String getPath(){
        return pathInputLabel.getText();
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
    public String getExtensionInput() {
        return extensionInput.getSelectedItem().toString();
    }

    /**
     * This method returns an array of String with information to search by size
     *
     * @return sizeData
     */
    public String[] getSizeInput(){
        sizeData = new String[2];
        sizeData[0] = sizeComparison.getSelectedItem().toString();
        sizeData[1] = sizeInput.getText();
        sizeData[2] = sizeUnit.getSelectedItem().toString();
        return sizeData;
    }

    /**
     * This method listens the actions in the checkboxes. overwrites the method
     * existent in the ITemListener interface
     *
     * @param ItemEvent it is the event
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();

        if (source == hidden) {
            System.out.println("hidden is true");
            hiddenCH = true;
        } else if (source == read_only) {
            System.out.println("read only is true");
            read_onlyCH = true;
        } else if (source == only_files) {
            System.out.println("only files is true");
            only_filesCH = true;
        }

        if (e.getStateChange() == ItemEvent.DESELECTED){
            System.out.println("itemevent is deselected");
            if (source == hidden) {
                System.out.println("hidden is false again");
                hiddenCH = false;
            } else if (source == read_only) {
                System.out.println("read only is false again");
                read_onlyCH = false;
            } else if (source == only_files) {
                System.out.println("only files is false again");
                only_filesCH = false;
            }
        }
    }

    /**
     * This method returns the value of Hidden checkbox
     *
     * return boolean hiddenCH
     */
    public boolean getHidden(){
        return hiddenCH;
    }

    /**
     * This method returns the value of Hidden checkbox
     *
     * return boolean hiddenCH
     */
    public boolean getReadOnly(){
        return read_onlyCH;
    }

    /**
     * This method returns the value of Hidden checkbox
     *
     * return boolean hiddenCH
     */
    public boolean getOnlyFiles(){
        return only_filesCH;
    }

}