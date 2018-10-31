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

package com.foundation.search.model;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;

public class Search {

    /**
     * searchFiles method performs a search of files and directories by
     * following next criteria:
     * Search by Path.
     * Search by file name.
     * Search by extension.
     * Search by hidden property.
     * Search by read only property.
     * Search only Directories.
     * Search by Size
     * @param criteria Object that belongs to Criteria class, where
     *                 all the search criteria is defined.
     * @return results List of Objects that contains the search results.
     */
    public List<SearchResult> searchFiles(Criteria criteria){

        File directory = new File(criteria.getPath());
        List<SearchResult> results = new ArrayList<>();

        for (File file : Files.fileTraverser().breadthFirst(directory)) {
            //Boolean to identify if the file will be returned as a result
            boolean isValidFile = true;
            String name;
            String extension;
            isValidFile = filterByName(file, criteria.getFileName(),
                    criteria.isDirectory);
            isValidFile = isValidFile && filterByExtension(file,
                    criteria.getFileExtension());
            isValidFile = isValidFile && filterBySize(file,
                    criteria.getSizeOption(), criteria.getFileSize(),
                    criteria.getSizeComparator());
            isValidFile = isValidFile && isReadOnly(file, criteria.getReadOnly());
            isValidFile = isValidFile && isHidden(file, criteria.hidden);
            isValidFile = isValidFile && filterByDirectory(file, criteria.isDirectory);
            if (isValidFile) {
                name = Files.getNameWithoutExtension(file.getName());
                extension = Files.getFileExtension(file.getName());
                long size = file.length();
                //Calculate the folder size
                if (file.isDirectory()) {
                    size = FileUtils.sizeOfDirectory(file);
                }
                results.add(createSearchResult(file.getParent(),name,extension,
                    size,!file.canWrite(), file.isHidden(), file.isDirectory()));
            }
        }
        return results;
    }

    /**
     * isReadOnly method filters the search results based on readOnly criteria
     * that is provided.
     * @param file                   item (file or directory) that will be
     *                               evaluated according to the search criteria
     * @param isCheckedReadOnly      Boolean value which is true if "Read only"
     *                               option is selected.
     * @return addFileToSearchResult Boolean value that is used to determine if
     *                               the file/directory is added to the list of
     *                               results.
     */
    private boolean isReadOnly(File file, boolean isCheckedReadOnly){
        boolean addFileToSearchResult;

        if (isCheckedReadOnly == false) {
            addFileToSearchResult = true;
        } else {
            addFileToSearchResult = ((!file.canWrite()) == (isCheckedReadOnly));
        }
        return addFileToSearchResult;
    }

    /**
     * isHidden method filters the search results based on isHidden criteria
     * that is provided.
     * @param file                   item (file or directory) that will be
     *                               evaluated according to the search criteria
     * @param isCheckedShowHidden    Boolean value which is true if "is Hidden"
     *                               option is selected.
     * @return addFileToSearchResult Boolean value that is used to determine if
     *                               the file/directory will be added to the
     *                               list of results.
     */
    private boolean isHidden(File file, boolean isCheckedShowHidden) {
        boolean addFileToSearchResult;

        if (!isCheckedShowHidden) {
            addFileToSearchResult = true;
        } else {
            addFileToSearchResult = (file.isHidden() == isCheckedShowHidden);
        }
        return addFileToSearchResult;
    }

    /**
     * createSearchResult method allows to set object result with the file or
     * directory attributes returned from search method.
     * @param path          String value that contains the path where the file
     *                      or directory was found.
     * @param name          String value that contains the file/directory name
     *                      that was found.
     * @param extension     String value that contains the file extension.
     * @param size          Long value that contains the file/directory size.
     * @param readOnly      Boolean value that stores the information about read
     *                      only property.
     * @param isHidden      Boolean value that stores the information about Hiden
     *                      property.
     * @param isDirectory   Boolean value that stores the information about
     *                      isDirectory property.
     * @return searchResult Object from SearchResult class that contains the
     *                      information related to the file/directory that will
     *                      be returned as part of the result.
     */
    private SearchResult createSearchResult(String path, String name, String
                                            extension, long size, boolean readOnly,
                                            boolean isHidden, boolean isDirectory) {
        SearchResult searchResult = new SearchResult();

        searchResult.setPathResult(path);
        searchResult.setFileNameResult(name);
        searchResult.setFileExtensionResult(extension);
        searchResult.setFileSizeResult(size);
        searchResult.setReadOnlyResult(readOnly);
        searchResult.setHiddenResult(isHidden);
        searchResult.setIsDirectoryResult(isDirectory);
        return searchResult;
    }

    /**
     * filterByName method filters the search results based on name value that
     * is provided as a search criteria.
     * @param file                   item (file or directory) that will be
     *                               evaluated according to the search
     *                               criteria.
     * @param nameToFilter           String value that correspond to the
     *                               name search criteria
     * @param isDirectory            Boolean value that correspond to the
     *                               isDirectory search criteria
     * @return addFileToSearchResult Boolean value that is used to determine
     *                               if the file/directory will be  added to
     *                               the list of results.
     */
    public boolean filterByName(File file, String nameToFilter, boolean isDirectory) {
        boolean addFileToSearchResult = false;
        String name = file.getName();

        if (nameToFilter == null) {
            addFileToSearchResult = true;
        } else if ((file.isFile() && isDirectory) || (file.isDirectory() && !isDirectory)){
            addFileToSearchResult = false;
        } else if (file.isFile()) {
            name = Files.getNameWithoutExtension(name);
            addFileToSearchResult = nameToFilter.equals(name);
        }
        return addFileToSearchResult;
    }

    /**
     * filterByExtension method filters the search results based on extension,
     * that is provided as a search criteria.
     * @param file                   item (file or directory) that will be
     *                               evaluated according to the search criteria.
     * @param filterByExtension      String value that contains the extension
     *                               search criteria.
     * @return addFileToSearchResult Boolean value that is used to determine
     *                               if the file/directory will be added to
     *                               the list of results.
     */
    public boolean filterByExtension(File file, String filterByExtension) {
        boolean addFileToSearchResult = false;
        String extension;

        if (filterByExtension == null) {
            addFileToSearchResult = true;
        } else if (file.isDirectory()) {
            addFileToSearchResult = false;
        } else if (file.isFile()) {
            extension = Files.getFileExtension(file.getName());
            addFileToSearchResult = filterByExtension.equals(extension);
        }
        return addFileToSearchResult;
    }

    /**
     * filterBySize method filters the search results based on size, that is
     * provided as a search criteria.
     * @param file                   item (file or directory) that will be
     *                               evaluated according to the search criteria.
     * @param sizeOption             boolean value that indicates if the size
     *                               option is selected as a search criteria.
     * @param fileSize               long value that contains the file/directory
     *                               size.
     * @param sizeComparator         char value that contains the comparator
     *                               (> , < , =)
     * @return addFileToSearchResult Boolean value that is used to determine
     *                               if the file/directory will be added to
     *                               the list of results
     */
    public boolean filterBySize(File file, boolean sizeOption, long fileSize,
                                char sizeComparator){
        boolean addFileToSearchResult = false;

        if (sizeOption == false) {
            addFileToSearchResult = true;
        } else if ((fileSize < 0) && (sizeComparator == '<')){
            addFileToSearchResult = false;
        } else if (sizeComparator == '=') {
            addFileToSearchResult = (file.length() == fileSize);
        } else if (sizeComparator == '<') {
            addFileToSearchResult = (file.length() < fileSize);
        } else if (sizeComparator == '>') {
            addFileToSearchResult = (file.length() > fileSize);
        }
        return addFileToSearchResult;
    }

    /**
     * filterByDirectory method filters the search results based on isDirectory
     * criteria.
     * @param file                   item (file or directory) that will be evaluated
     *                               according to the search criteria
     * @param isDirectory            boolean value. This is equal to true if the
     *                               IsDirectory option is selected as a search
     *                               criteria.
     * @return addFileToSearchResult Boolean value that is used to determine
     *                               if the file/directory will be added to
     *                               the list of results
     */
    public boolean filterByDirectory(File file, boolean isDirectory){
        boolean addFileToSearchResult;

        if (!isDirectory) {
            addFileToSearchResult = true;
        } else {
            addFileToSearchResult = file.isDirectory();
        }
        return addFileToSearchResult;
    }
}
