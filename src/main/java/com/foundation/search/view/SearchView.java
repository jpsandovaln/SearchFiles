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
import javax.swing.JFrame;

/**
 * This class is the main class to communicate with the controller.
 * It contains the MainPanel and the settings of the Search window
 *
 * @author Emely LLanos
 * @version 1.0.
 */
public class SearchView extends JFrame{

    private MainPanel mainPanel;

    /**
     * The constructor of ResultsPanel class where the components are set
     * by invoking the setting() and init() method
     */
    public SearchView() {
        super();
        setting();
        init();
    }

    /**
     * setting method will set the properties of the Search Window
     */
    private void setting() {
        mainPanel = new MainPanel();
        this.setTitle("Search Files ");
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * init method adds the mainPanel and makes it visible
     */
    private void init() {
        this.add(mainPanel);
        this.setVisible(true);
    }

    /**
     * This method returns the mainPanel that this frame contains
     * in order to use it's available methods
     *
     * @return parameters
     */
    public MainPanel getMainPanel(){
        return mainPanel;
    }
}