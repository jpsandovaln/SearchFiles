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

/**
 * This class contains the parameters panel and results panel
 *
 * @author Emely LLanos
 * @version 1.0.
 */

public class MainPanel extends JPanel {

    private ParametersPanel parameters;
    private ResultsPanel result;

    /**
     * The constructor of ResultsPanel class where the components are set
     * by invoking the setting() and init() method
     */
    protected MainPanel() {
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
     * init method adds the two panels: ParametersPanel and ResultsPanel
     * to the main panel
     */
    private void init() {
        //Setting up BoxLayout
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //adding panel to receive the parameters for the search
        parameters = new ParametersPanel();
        add(parameters);
        //adding the panel to show the list of files and folders found
        ResultsPanel result = new ResultsPanel();
        add(result);
    }

    /**
     * This method returns the parametersPanel that this panel contains
     * in order to use it's available methods
     *
     * @return parameters
     */
    public JPanel getParametersPanel(){
        return parameters;
    }

    /**
     * This method returns the resultsPanel that this panel contains
     * in order to use it's available methods
     *
     * @return result
     */
    public JPanel getResultsPanel(){
        return result;
    }
}
