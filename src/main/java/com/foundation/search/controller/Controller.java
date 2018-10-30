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

import com.foundation.search.model.Criteria;
import com.foundation.search.model.Search;
import com.foundation.search.model.SearchResult;
import com.foundation.search.view.SearchView;
import java.util.List;

/**
 * This class integrates the view and model layers
 *
 * @author Mary Ricalde
 * @version 1.0.
 */
public class Controller {
    private SearchView view;
    private Search search;

    /**
     * The constructor of Controller class where the view and model classes are
     * instantiated and the action listener for the search button is called
     */
    public Controller() {
        this.view = new SearchView();
        this.search = new Search();
        view.getMainPanel().getParametersPanel().getSearchButton().addActionListener(e -> getSearchCriteria());
        view.getMainPanel().getParametersPanel().getCleanButton().addActionListener(c -> cleanResultTable());
    }

    /**
     * This method reads the fields for the searching criteria and send these values
     * to the search method.
     * This set the list of files results to the table result
     */
    public void getSearchCriteria() {
        Criteria searchCriteria = new Criteria("C:/");
        // boolean variable that will control if the fields are valid for to do
        // the searching criteria
        boolean validFields = false;
        String path = view.getMainPanel().getParametersPanel().getPath();
        String fileName = view.getMainPanel().getParametersPanel().getNameInput().getText();
        String extension = view.getMainPanel().getParametersPanel().getExtensionInput();
        String[] size = view.getMainPanel().getParametersPanel().getSizeInput();;
        String unitOfMeasure;
        char sizeComparator;

        if (Validation.isValidPath(path)){
            searchCriteria.setPath(path);
            validFields = true;
        } else {
            //view.getMainPanel().errorMessage("Path", " is not valid or is empty. Insert a valid path (i.e. C:\\)");
        }

        if (!(Validation.isFieldNullOrEmpty(fileName))
                &&(Validation.isValidFileName(fileName))){
            searchCriteria.setFileName(fileName);
        } else if (!(Validation.isFieldNullOrEmpty(fileName))
                      &&!(Validation.isValidFileName(fileName))) {
            //view.getMainPanel().errorMessage("File name", " is not valid. Insert a valid file name");
            validFields = false;
        }

        if (!(Validation.isFieldNullOrEmpty(extension))
                && (Validation.isValidFileName(extension))){
            searchCriteria.setFileExtension(extension);
        } else if (!(Validation.isFieldNullOrEmpty(extension))
                      &&!(Validation.isValidFileExtension(extension))) {
            //view.getMainPanel().errorMessage("extension", " is not valid. Insert a valid file extension");
            validFields = false;
        }

        if (!(Validation.isFieldNullOrEmpty(size[1]))
                && (Validation.isValidSize(size[1]))) {
            long sizeInBytes;
            int convertedSize = Integer.parseInt(size[1]);
            sizeComparator = size[0].charAt(0);
            unitOfMeasure = size[2];

            if (!unitOfMeasure.equalsIgnoreCase("byte")){
                sizeInBytes = Utilities.convertToBytes(convertedSize,unitOfMeasure);
            } else {
                sizeInBytes = convertedSize;
            }
            searchCriteria.setFileSize(sizeInBytes);
            searchCriteria.setSizeComparator(sizeComparator);
            searchCriteria.setSizeOption(true);
        } else if (!(Validation.isFieldNullOrEmpty(size[1])) &&
                      !(Validation.isValidSize(size[1]))) {
            //view.getMainPanel().errorMessage("size", " is not valid. Max length is 9 digits");
            validFields = false;
        }

        boolean isHidden = view.getMainPanel().getParametersPanel().getHidden();
        if (isHidden == true) {
            searchCriteria.setHidden(isHidden);
        }

        boolean isReadOnly = view.getMainPanel().getParametersPanel().getReadOnly();
        if (isReadOnly == true) {
            searchCriteria.setReadOnly(isReadOnly);
        }

        boolean onlyDirectory = view.getMainPanel().getParametersPanel().getOnlyFiles();
        if (onlyDirectory == true) {
            searchCriteria.setIsDirectory(onlyDirectory);
        }

        // Sending searching criteria to the search method if validFields is true
        if (validFields == true){
            List<SearchResult> files = search.searchFiles(searchCriteria);
            setTableResults(files);
        }
    }

    private void cleanResultTable() {
        view.getMainPanel().getResultsPanel().cleanTable();
    }

    private void setTableResults(List<SearchResult> files){
        // Cleaning the table
        view.getMainPanel().getResultsPanel().cleanTable();
        if (files.size()!=0) {
            // Setting results on the table result
            for (SearchResult file: files){
                view.getMainPanel().getResultsPanel().setNewRowResult(new Object[]{
                        file.getIsDirectoryResult(), file.getFileNameResult(), file.getPathResult(),
                        file.getFileExtensionResult(), file.getFileSizeResult(), file.getHiddenResult(),
                        file.getReadOnlyResult(), "Owner:1", "ModificationDate",
                        "CreationDate","LastAccessDate"});
            }
        } else {
            //view.getMainPanel().errorMessage("No data", " no hay resultados");
        }
    }
}
