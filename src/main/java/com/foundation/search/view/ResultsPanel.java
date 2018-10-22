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

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 * Class ResultsPanel is in charge of setting the table with files resultant
 * This class provides a method to add files found row by row and a method
 * to clean the table
 *
 * @author Emely LLanos
 * @version 1.0.
 */

public class ResultsPanel extends JPanel {

    DefaultTableModel defTableModel;
    //setting the names of columns and temporal data to the table
    //this data should be cleaned by the controller
    String[] columnNames = {"Name","Path","Extension", "Size"};
    Object[][] data = {{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};

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
        add(new JLabel(" "));
        add(new JLabel(" "));
        add(resultsTableTitles);
    }

    /**
     * This method allows to add a new row with data to the table
     *
     * @param insertRowData array of objects to add in the table
     */
    public void setNewRowResult(Object [] insertRowData){
        defTableModel.insertRow(2,insertRowData);
    }

    /**
     * This method cleans the table, removing all existent rows
     *
     * @return True If the table was clean
     */
    public boolean cleanTable(){
        defTableModel.getDataVector().removeAllElements();
        return true;
    }
}
