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

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JSeparator;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Class ResultsPanel is in charge of setting the table with files resultant
 * This class provides a method to add files found row by row and a method
 * to clean the table
 *
 * @author Emely LLanos
 * @version 1.0.
 */

public class ResultsPanel extends JPanel {

    private DefaultTableModel defTableModel;
    //setting the names of columns and temporal data to the table
    //this data should be cleaned by the controller
    private String[] columnNames = {"File/Dir","Name","Path","Extension", "Size", "Hidden", "Read-Only","Owner","ModificationDate", "CreationDate","LastAccessDate"};
    private Object[][] data = null;
    private JLabel filesFoundText = new JLabel(" ");

    /**
     * The constructor of ResultsPanel class where the components are set
     * by invoking thesetting() and init() method
     */
    public ResultsPanel() {
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
     * init method sets and initializes the table added to this Panel.
     */
    private void init() {
        defTableModel = new DefaultTableModel(data, columnNames);
        JTable results = new JTable(defTableModel);
        //Create a JScrollPane to display the title of columns
        JScrollPane resultsTableTitles = new JScrollPane(results);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //creating the sub-panel where the text of Files found is displayed
        //right above the table
        Border borderB = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);
        JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(50,1));
        separator.setBorder(borderB);
        add(separator);
        add(new JLabel(" "));
        add(filesFoundText);
        add(new JLabel(" "));
        add(resultsTableTitles);
    }

    /**
     * This method allows to add a new row with data to the table
     *
     * @param insertRowData array of objects to add in the table
     */
    public void setNewRowResult(Object [] insertRowData){
        defTableModel.addRow(insertRowData);
    }

    /**
     * This method cleans the table, removing all existent rows
     */
    public void cleanTable(){
        defTableModel.setRowCount(0);
    }

    /**
     * This method sets the text to display above the table with resultant files found
     *
     * @param label this parameter will define the text to display
     *              -1 if no search was performed or if the table was cleaned
     *              0 if there is no files found according to search criteria
     *              1 if there is files found according to search criteria
     */
    public void setFilesFoundLabel(int label){
        if (label == -1) {
            filesFoundText.setText("  ");
        } else if (label == 0) {
            filesFoundText.setForeground(Color.gray);
            filesFoundText.setText("No files found according to criteria set above.  ");
        } else if (label == 1) {
            filesFoundText.setForeground(Color.black);
            filesFoundText.setText("List of files found according to criteria set above.  ");
        }
    }
}
