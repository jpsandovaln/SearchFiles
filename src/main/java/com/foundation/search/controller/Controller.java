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
import java.util.Date;
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
        Criteria searchCriteria = new Criteria();
        // boolean variable that will control if the fields are valid to do the
        // searching criteria
        boolean validFields = false;
        String path = (view.getMainPanel().getParametersPanel().getPath()).trim();
        String fileName = (view.getMainPanel().getParametersPanel().getNameInput().getText()).trim();
        String extension = (view.getMainPanel().getParametersPanel().getExtensionInput()).trim();
        String owner = (view.getMainPanel().getParametersPanel().getOwner()).trim();
        String content = (view.getMainPanel().getParametersPanel().getContent()).trim();
        String[] size = view.getMainPanel().getParametersPanel().getSizeInput();;
        String unitOfMeasure;
        char sizeComparator;
        Date createdDate = (view.getMainPanel().getParametersPanel().getCreationDate());
        Date modifiedDate = (view.getMainPanel().getParametersPanel().getModificationDate());
        Date lastAccessedDate = (view.getMainPanel().getParametersPanel().getLastAccessDate());

        if (Validation.isValidPath(path)) {
            searchCriteria.setPath(path);
            validFields = true;
        } else {
            view.getMainPanel().errorMessage("Path value is not valid or it is empty. Insert a valid path (i.e. C:\\)");
        }

        if (!(Validation.isFieldNullOrEmpty(fileName))
                &&(Validation.isValidFileName(fileName))) {
            searchCriteria.setFileName(fileName);
        } else if (!(Validation.isFieldNullOrEmpty(fileName))
                      &&!(Validation.isValidFileName(fileName))) {
            view.getMainPanel().errorMessage("File name is not valid. Insert a valid file name");
            validFields = false;
        }

        if (!(Validation.isFieldNullOrEmpty(extension))
                && (Validation.isValidFileExtension(extension))) {
            searchCriteria.setFileExtension(extension);
        } else if (!(Validation.isFieldNullOrEmpty(extension))
                      &&!(Validation.isValidFileExtension(extension))) {
            view.getMainPanel().errorMessage("Extension is not valid. Insert a valid file extension");
            validFields = false;
        }

        if (!(Validation.isFieldNullOrEmpty(size[1]))
                && (Validation.isValidSize(size[1]))) {
            long sizeInBytes;
            int convertedSize = Integer.parseInt(size[1]);
            sizeComparator = size[0].charAt(0);
            unitOfMeasure = size[2];

            if (!unitOfMeasure.equalsIgnoreCase("byte")) {
                sizeInBytes = Utilities.convertToBytes(convertedSize,unitOfMeasure);
            } else {
                sizeInBytes = convertedSize;
            }
            searchCriteria.setFileSize(sizeInBytes);
            searchCriteria.setSizeComparator(sizeComparator);
            searchCriteria.setSizeOption(true);
        } else if (!(Validation.isFieldNullOrEmpty(size[1])) &&
                      !(Validation.isValidSize(size[1]))) {
            view.getMainPanel().errorMessage("Size is not valid. The size should be" +
                " between a range of 0 to 9 whole numbers.");
            validFields = false;
        }

        if (!(Validation.isFieldNullOrEmpty(owner))
                &&(Validation.isValidOwnerName(owner))) {
            searchCriteria.setOwner(owner);
        } else if (!(Validation.isFieldNullOrEmpty(owner))
                &&!(Validation.isValidOwnerName(owner))) {
            view.getMainPanel().errorMessage("Owner value is not valid. Insert a valid owner name");
            validFields = false;
        }

        if (!Validation.isFieldNullOrEmpty(content)) {
            searchCriteria.setTextToSearch(content);
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

        if (createdDate != null) {
            String searchCreationDate = Utilities.convertToFormatDate(createdDate);
            searchCriteria.setCreatedDate(searchCreationDate);
            searchCriteria.setCreatedDateOption(true);
        }

        if (modifiedDate != null) {
            String searchModifiedDate = Utilities.convertToFormatDate(modifiedDate);
            searchCriteria.setModifiedDate(searchModifiedDate);
            searchCriteria.setModifiedDateOption(true);
        }

        if (lastAccessedDate != null) {
            String searchLastAccessedDate = Utilities.convertToFormatDate(lastAccessedDate);
            searchCriteria.setAccessedDate(searchLastAccessedDate);
            searchCriteria.setAccessedDateOption(true);
        }

        // Sending searching criteria to the search method if validFields is true
        if (validFields == true) {
            List<SearchResult> files = search.searchFiles(searchCriteria);
            setTableResults(files);
        }
    }

    /**
     * This method is going to clean data on the result table
     */
    private void cleanResultTable() {
        view.getMainPanel().getResultsPanel().cleanTable();
        view.getMainPanel().getResultsPanel().setFilesFoundLabel(-1);
    }

    /**
     * This method is going set the data into the result table given a list of files
     */
    private void setTableResults(List<SearchResult> files){
        // Cleaning the table
        view.getMainPanel().getResultsPanel().cleanTable();
        if (files.size()!=0) {
            // Setting results on the table result
            for (SearchResult file: files){
                view.getMainPanel().getResultsPanel().setFilesFoundLabel(1);
                view.getMainPanel().getResultsPanel().setNewRowResult(new Object[]{
                    Utilities.convertDirectoryResultToString(file.getIsDirectoryResult()),
                    file.getFileNameResult(), file.getPathResult(),
                    file.getFileExtensionResult(), file.getFileSizeResult(),
                    Utilities.convertBooleanResultToString(file.getHiddenResult()),
                    Utilities.convertBooleanResultToString(file.getReadOnlyResult()),
                    file.getOwnerResult(), file.getModifiedDateResult(),
                    file.getCreatedDateResult(), file.getAccessedDateResult()});
            }
        } else {
            view.getMainPanel().getResultsPanel().setFilesFoundLabel(0);
        }
    }
}
