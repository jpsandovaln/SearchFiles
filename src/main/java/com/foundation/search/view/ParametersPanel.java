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

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.imageio.ImageIO;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
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
import java.util.Date;
import java.util.Properties;

/**
 * Class ParametersPanel receives all parameters to perform the search
 * and provides these parameters by get methods to be used by the Controller
 *
 * @author Emely LLanos
 * @version 1.0.
 */

public class ParametersPanel extends JPanel implements ItemListener {

    JLabel pathLabel = new JLabel("    Location (Mandatory):");
    JLabel nameLabel = new JLabel("    By Name:");
    JLabel extensionLabel = new JLabel("    By Extension:");
    JLabel sizeLabel = new JLabel("    By Size: ");
    JLabel ownerLabel = new JLabel("    By owner: ");
    JLabel contentLabel = new JLabel("    By content(Only Files): ");
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
    private JCheckBox readOnly;
    private JCheckBox onlyFiles;
    private boolean hiddenCH = false;
    private boolean readOnlyCh = false;
    private boolean onlyFilesCh = false;
    private JCheckBox byCreationDate;
    private JCheckBox byModificationDate;
    private JCheckBox byLastDayAccessed;
    private JDatePanelImpl creationDate;
    private JDatePanelImpl modificationDate;
    private JDatePanelImpl lastAccessDate;
    private Date creationDateSelected = null;
    private Date modificationDateSelected = null;
    private Date lastAccessDateSelected = null;

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
        //setting all components displayed in this panel
        addBrowseButton();
        initializeInputs();
        createCalendars();

        //creating the layout that will contain every sub-panel
        setLayout(new BorderLayout());

        //Creating instructions panel
        Border borderB = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);
        JPanel instructionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        instructionsPanel.setBorder(borderB);
        try {
            BufferedImage image = ImageIO.read(new File("src/main/java/resources/background.jpg"));
            JLabel label = new JLabel(new ImageIcon(image));
            instructionsPanel.add(label);
        }
        catch(Exception exception){
            System.out.println("Unable to open the picture");
        }

        //Creating buttons panel
        JPanel rightside = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setPreferredSize(new Dimension(1,485));
        separator.setBorder(borderB);
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
        pathLabel.setToolTipText("Insert the path where you want to search");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        centerPanel.add(pathLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 6;
        c.gridx = 1;
        c.gridy = 0;
        centerPanel.add(pathInputLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 7;
        c.gridy = 0;
        centerPanel.add(btnBrowse, c);

        //File Name and extension parameters
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        centerPanel.add(nameLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 4;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 1;
        centerPanel.add(nameInput, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 4;
        c.gridy = 1;
        centerPanel.add(extensionLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 4;
        c.gridwidth = 1;
        c.gridx = 6;
        c.gridy = 1;
        centerPanel.add(extensionInput, c);

        //by content and owner parameters
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        centerPanel.add(ownerLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 4;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 2;
        centerPanel.add(ownerInput, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 4;
        c.gridy = 2;
        centerPanel.add(contentLabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 4;
        c.gridwidth = 2;
        c.gridx = 6;
        c.gridy = 2;
        centerPanel.add(contentInput, c);

        //by size
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.ipady = 22;
        c.gridx = 0;
        c.gridy = 3;
        centerPanel.add(sizeLabel, c);
        c.weightx = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.ipady = 4;
        c.gridx = 1;
        c.gridy = 3;
        centerPanel.add(sizeComparison, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.ipady = 8;
        c.gridx = 2;
        c.gridy = 3;
        centerPanel.add(sizeInput, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.ipady = 4;
        c.gridx = 4;
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
        c.gridwidth = 3;
        c.gridx = 3;
        c.gridy = 4;
        centerPanel.add(readOnly, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 22;
        c.gridwidth = 2;
        c.gridx = 7;
        c.gridy = 4;
        centerPanel.add(onlyFiles, c);

        //Calendars - Labels only
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 5;
        centerPanel.add(byCreationDate, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 3;
        c.gridy = 5;
        centerPanel.add(byModificationDate, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 7;
        c.gridy = 5;
        centerPanel.add(byLastDayAccessed, c);

        //Calendars - Adding the calendars
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 6;
        centerPanel.add(creationDate, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 3;
        c.gridy = 6;
        centerPanel.add(modificationDate, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 7;
        c.gridy = 6;
        centerPanel.add(lastAccessDate, c);

        //main division
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 7;
        centerPanel.add(new JLabel("  "), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 7;
        centerPanel.add(new JLabel("  "), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 7;
        centerPanel.add(new JLabel("          "), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 7;
        centerPanel.add(new JLabel(" "), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 7;
        centerPanel.add(new JLabel(" "), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
        c.gridy = 7;
        centerPanel.add(new JLabel(" "), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 7;
        c.gridy = 7;
        centerPanel.add(new JLabel(" "), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 8;
        c.gridy = 7;
        centerPanel.add(new JLabel(" "), c);

        //adding the panels to main parameters panel
        add(instructionsPanel, BorderLayout.LINE_START);
        add(centerPanel, BorderLayout.CENTER);
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
     * This method initialize all input labels, combo boxes and check boxes
     * displayed in this panel
     *
     */
    public void initializeInputs(){
        //initializing the inputs, comboboxes and checkboxes
        nameInput = new JTextField();
        String[] extensions = {"","exe", "png","mp3","pdf","mp4","jpg","txt","xls",
                               "xlsx","sh","java","php","bat","avi"};
        extensionInput = new JComboBox(extensions);
        sizeInput = new JTextField();
        String[] comparisonSelection = {"", "<", ">","="};
        sizeComparison = new JComboBox(comparisonSelection);
        String[] units = {"", "MB", "GB","KB","byte"};
        sizeUnit=new JComboBox(units);
        ownerInput = new JTextField();
        contentInput = new JTextField();
        findButton = new JButton("Search");
        cleanButton = new JButton("Clean");
        hidden = new JCheckBox("Include Hidden Files");
        hidden.setMnemonic(KeyEvent.VK_D);
        hidden.setSelected(false);
        readOnly = new JCheckBox("Include Read-Only Files");
        readOnly.setMnemonic(KeyEvent.VK_D);
        readOnly.setSelected(false);
        onlyFiles = new JCheckBox("Include Directories Only");
        onlyFiles.setMnemonic(KeyEvent.VK_D);
        onlyFiles.setSelected(false);
        byCreationDate = new JCheckBox("Files created at");
        byCreationDate.setMnemonic(KeyEvent.VK_D);
        byCreationDate.setSelected(false);
        byModificationDate = new JCheckBox("Files modified at");
        byModificationDate.setMnemonic(KeyEvent.VK_D);
        byModificationDate.setSelected(false);
        byLastDayAccessed = new JCheckBox("Files accessed at");
        byLastDayAccessed.setMnemonic(KeyEvent.VK_D);
        byLastDayAccessed.setSelected(false);

        //Registering a listener for the checkBoxes
        hidden.addItemListener(this);
        readOnly.addItemListener(this);
        onlyFiles.addItemListener(this);
        byCreationDate.addItemListener(this);
        byModificationDate.addItemListener(this);
        byLastDayAccessed.addItemListener(this);
    }

    /**
     * This method creates and adds action Listener to the Browse button in order to get
     * the path where to search
     *
     */
    public void addBrowseButton() {
        //defining the browse button
        pathInputLabel = new JTextField();
        btnBrowse = new JButton("Browse");
        pathInput = new JFileChooser();
        //Adding the actionListener
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
    }

    /**
     * This method creates the calendars to display for the 3 options to filter dates
     * Creation date, Modification date and Last Access date
     *
     */
    public void createCalendars(){
        //Creating the calendars
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        creationDate = new JDatePanelImpl(model, p);
        UtilDateModel modelM = new UtilDateModel();
        Properties pm = new Properties();
        pm.put("text.today", "Today");
        pm.put("text.month", "Month");
        pm.put("text.year", "Year");
        modificationDate = new JDatePanelImpl(modelM, pm);
        UtilDateModel modelA = new UtilDateModel();
        Properties pa = new Properties();
        pa.put("text.today", "Today");
        pa.put("text.month", "Month");
        pa.put("text.year", "Year");
        lastAccessDate = new JDatePanelImpl(modelA, pa);

        //set false to the calendars initially
        creationDate.setVisible(false);
        modificationDate.setVisible(false);
        lastAccessDate.setVisible(false);

        //Adding the actionListener
        creationDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                creationDateSelected = (Date) creationDate.getModel().getValue();
            }
        });
        modificationDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificationDateSelected = (Date) modificationDate.getModel().getValue();
            }
        });
        lastAccessDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lastAccessDateSelected = (Date) lastAccessDate.getModel().getValue();
            }
        });
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
        sizeData = new String[3];
        sizeData[0] = sizeComparison.getSelectedItem().toString();
        sizeData[1] = sizeInput.getText();
        sizeData[2] = sizeUnit.getSelectedItem().toString();
        return sizeData;
    }

    /**
     * This method listens the performed actions on the checkboxes; it overwrites the existing
     * method in the ItemListener interface
     *
     * @param ItemEvent it is the event
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();

        if (source == hidden) {
            hiddenCH = true;
        } else if (source == readOnly) {
            readOnlyCh = true;
        } else if (source == onlyFiles) {
            onlyFilesCh = true;
        } else if (source == byCreationDate) {
            creationDate.setVisible(true);
            creationDate.getModel().setDay(1);
            creationDate.getModel().setSelected(true);
            creationDateSelected = (Date) creationDate.getModel().getValue();
        } else if (source == byModificationDate) {
            modificationDate.setVisible(true);
            modificationDate.getModel().setDay(1);
            modificationDate.getModel().setSelected(true);
            modificationDateSelected = (Date) modificationDate.getModel().getValue();
        } else if (source == byLastDayAccessed) {
            lastAccessDate.setVisible(true);
            lastAccessDate.getModel().setDay(1);
            lastAccessDate.getModel().setSelected(true);
            lastAccessDateSelected= (Date) lastAccessDate.getModel().getValue();
        }

        if (e.getStateChange() == ItemEvent.DESELECTED) {
            if (source == hidden) {
                hiddenCH = false;
            } else if (source == readOnly) {
                readOnlyCh = false;
            } else if (source == onlyFiles) {
                onlyFilesCh = false;
            } else if (source == byCreationDate) {
                creationDate.setVisible(false);
                creationDateSelected = null;
            } else if (source == byModificationDate) {
                modificationDate.setVisible(false);
                modificationDateSelected = null;
            } else if (source == byLastDayAccessed) {
                lastAccessDate.setVisible(false);
                lastAccessDateSelected = null;
            }
        }
    }

    /**
     * This method returns the value of Hidden checkbox
     *
     * @return boolean hiddenCH
     */
    public boolean getHidden(){
        return hiddenCH;
    }

    /**
     * This method returns the value of read_only checkbox
     *
     * @return boolean read_onlyCH
     */
    public boolean getReadOnly(){
        return readOnlyCh;
    }

    /**
     * This method returns the value of only_files checkbox
     *
     * @return boolean only_filesCH
     */
    public boolean getOnlyFiles(){
        return onlyFilesCh;
    }

    /**
     * This method returns the Date selected to filter the search by creation date
     *
     * @return creationDateSelected
     */
    public Date getCreationDate(){
        return creationDateSelected;
    }

    /**
     * This method returns the Date selected to filter the search by modification date
     *
     * @return modificationDateSelected
     */
    public Date getModificationDate(){
        return modificationDateSelected;
    }

    /**
     * This method returns the Date selected to filter the search by last access date date
     *
     * @return lastAccessDateSelected
     */
    public Date getLastAccessDate(){
        return lastAccessDateSelected;
    }

    /**
     * This method returns the Owner inserted to filter the search by owner
     *
     * @return owner
     */
    public String getOwner(){
        return ownerInput.getText();
    }

    /**
     * This method returns the content inserted to filter the search by content
     *
     * @return owner
     */
    public String getContent(){
        return contentInput.getText();
    }
}