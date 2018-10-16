/*
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

package com.foundation.search.controller;

import com.foundation.search.view.View;
import com.foundation.search.model.Search;

import java.awt.event.ActionEvent;

public class Controller {
    private View view;
    private Search search;

    public Controller() {
        this.view = new View();
        this.search = new Search();
    }

    public void getBasicFields() {

    }

    public void findEvent(ActionEvent buttonEvent) {

    }
}
