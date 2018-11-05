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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains the methods to perform the search of files and directories
 * by a set of criteria.
 *
 * @author Shirley Soto
 * @version 1.0.
 */
public class Search implements ISearch{
    private Logger logger = Logger.getAnonymousLogger();

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
    public List<Asset> searchFiles(Criteria criteria) throws IOException{
        File directory = new File(criteria.getPath());
        List<Asset> results = new ArrayList<>();

        for (File file : Files.fileTraverser().breadthFirst(directory)) {
            //Boolean to identify if the file will be returned as a result
            boolean isValidFile = true;
            String name;
            String extension;

            isValidFile = filterByName(file, criteria.getFileName(),
                    criteria.getIsDirectory());
            isValidFile = isValidFile && filterByExtension(file,
                    criteria.getFileExtension());
            isValidFile = isValidFile && filterBySize(file,
                    criteria.getSizeOption(), criteria.getFileSize(),
                    criteria.getSizeComparator());
            isValidFile = isValidFile && isReadOnly(file, criteria.getReadOnly());
            isValidFile = isValidFile && isHidden(file, criteria.getHidden());
            isValidFile = isValidFile && filterByDirectory(file, criteria.getIsDirectory());
            isValidFile = isValidFile && filterByOwner(file, criteria.getOwner());
            isValidFile = isValidFile && filterByCreatedDate(file, criteria.getCreatedDateSelected(),
                    criteria.getCreatedDate());
            isValidFile = isValidFile && filterByModifiedDate(file, criteria.getModifiedDateSelected(),
                    criteria.getModifiedDate());
            isValidFile = isValidFile && filterByAccessedDate(file, criteria.getAccessedDateSelected(),
                    criteria.getAccessedDate());
            isValidFile = isValidFile && filterByContent(file, criteria.getTextToSearch());
            if (isValidFile) {
                name = Files.getNameWithoutExtension(file.getName());
                extension = Files.getFileExtension(file.getName());
                long size = file.length();
                //Calculate the folder size
                if (file.isDirectory()) {
                    size = FileUtils.sizeOfDirectory(file);
                }
                results.add(createSearchResult(file.getParent(),name,extension,
                    size,!file.canWrite(), file.isHidden(), file.isDirectory(),
                    getCurrentOwner(file), getCreatedDate(file),
                    getModifiedDate(file),getAccessedDate(file)));
            }
        }
        return results;
    }

    /**
     * filterByContent method allows to filter files by content.
     * @param file                   item (file or directory) that will be
     *                               evaluated according to the search criteria.
     * @param textToSearch           String that contains the Text that will be used as
     *                               search criteria.
     * @return addFileToSearchResult Boolean value that is used to determine if
     *                               the file/directory is added to the list of
     *                               results.
     */
    private boolean filterByContent(File file, String textToSearch){
        boolean addFileToSearchResult = false;
        String content;

        if (textToSearch == null) {
            addFileToSearchResult = true;
        } else if (file.isFile()) {
            try {
                content = new String (java.nio.file.Files.readAllBytes(Paths.get(file.getPath())));
                addFileToSearchResult = content.contains(textToSearch);
            } catch (IOException e) {
                logger.log(Level.WARNING, file.getName() + " file could not be read");
            } catch (OutOfMemoryError e) {
                logger.log(Level.SEVERE, file.getName() + " file cannot be allocated to be read. " +
                    "File is bigger than 1GB");
            } catch (SecurityException e) {
                logger.log(Level.WARNING, file.getName() + " file doesn't have read access");
            } catch (Exception e) {
                logger.log(Level.WARNING, "Unexpected error has occurred with " + file.getName());
            }
        }
        return addFileToSearchResult;
    }

    /**
     * filterByCreatedDate method allows to filter files by Created Date.
     * @param file                   Item (file or directory) that will be
     *                               evaluated according to the search criteria.
     * @param isCreatedDateSelected  Boolean that is True if CreatedDate option
     *                               is selected.
     * @param expectedCreatedDate    String that contains the Expected Date that
     *                               will be used as a search criteria.
     * @return addFileToSearchResult Boolean value that is used to determine if
     *                               the file/directory is added to the list of
     *                               results.
     */
    private boolean filterByCreatedDate(File file, boolean isCreatedDateSelected,
                                        String expectedCreatedDate) throws IOException{
        boolean addFileToSearchResult = false;
        String actualCreatedDate;

        if (isCreatedDateSelected == false) {
            addFileToSearchResult = true;
        } else {
            try{
                actualCreatedDate = getCreatedDate(file);
                addFileToSearchResult = actualCreatedDate.equals(expectedCreatedDate);
            } catch (IOException e){
                throw e;
            }
        }
        return addFileToSearchResult;
    }

    /**
     * getCreatedDate method allows to obtain the created date.
     * @param file               Item (file or directory) that will be
     *                           evaluated according to the search criteria.
     * @return actualCreatedDate String value that contains the Created Date.
     */
	private String getCreatedDate(File file) throws IOException{
        String actualCreatedDate="";
        try {
            BasicFileAttributes createdDate = java.nio.file.Files.
                readAttributes(file.toPath(), BasicFileAttributes.class);
            FileTime time = createdDate.creationTime();
            actualCreatedDate = convertDateToString(time);
        } catch (IOException e) {
            throw new IOException("Create date could not be retrieved");
        }
        return actualCreatedDate;
    }

    /**
     * filterByModifiedDate method allows to filter files by Modified Date.
     * @param file                   Item (file or directory) that will be
     * @param isModifiedDateSelected Boolean that is True if ModifiedDate option
     *                               is selected.*
     * @param expectedModifiedDate   String that contains the Expected Date that
     *                               will be used as a search criteria.
     * @return addFileToSearchResult Boolean value that is used to determine if
     *                               the file/directory is added to the list of
     *                               results.
     */
    private boolean filterByModifiedDate(File file, boolean isModifiedDateSelected,
                                         String expectedModifiedDate)throws IOException{
        boolean addFileToSearchResult = false;
        String actualModifiedDate;

        if (isModifiedDateSelected == false) {
            addFileToSearchResult = true;
        } else {
            try {
                actualModifiedDate = getModifiedDate(file);
                addFileToSearchResult = actualModifiedDate.equals(expectedModifiedDate);
            } catch (IOException e){
                throw e;
            }
        }
        return addFileToSearchResult;
    }

	/**
     * getModifiedDate method allows to obtain the Modified date.
     * @param file                Item (file or directory) that will be
     *                            evaluated according to the search criteria.
     * @return actualModifiedDate String value that contains the Created Date.
     */
    private String getModifiedDate(File file) throws IOException{
        String actualModifiedDate="";
        try {
            BasicFileAttributes modifiedDate = java.nio.file.Files.readAttributes(file.toPath(),
                    BasicFileAttributes.class);
            FileTime time = modifiedDate.lastModifiedTime();
            actualModifiedDate = convertDateToString(time);
        } catch (IOException e) {
            throw new IOException("Modified date could not be retrieved");
        }
        return actualModifiedDate;
    }

    /**
     * filterByAccessedDate method allows to filter files by Access Date.
     * @param file                   Item (file or directory) that will be
     * @param isAccessedDateSelected Boolean that is True if Accessed Date option
     *                               is selected.*
     * @param expectedAccessedDate   String that contains the Expected Access Date
     *                               that will be used as a search criteria.
     * @return addFileToSearchResult Boolean value that is used to determine if
     *                               the file/directory is added to the list of
     *                               results.
     */
    private boolean filterByAccessedDate(File file, boolean isAccessedDateSelected,
                                         String expectedAccessedDate) throws IOException{
        boolean addFileToSearchResult = false;
        String actualAccessedDate;

        if (isAccessedDateSelected == false) {
            addFileToSearchResult = true;
        } else {
            try {
                actualAccessedDate = getAccessedDate(file);
                addFileToSearchResult = actualAccessedDate.equals(expectedAccessedDate);
            } catch (IOException e){
                throw e;
            }
        }
        return addFileToSearchResult;
    }

	/**
     * getAccessedDate method allows to obtain the Accessed date.
     * @param file                Item (file or directory) that will be
     *                            evaluated according to the search criteria.
     * @return actualAccessedDate String value that contains the Created Date.
     */
    private String getAccessedDate(File file) throws IOException{
        String actualAccessedDate="";
        try {
            BasicFileAttributes accessedDate = java.nio.file.Files.readAttributes(file.toPath(),
                    BasicFileAttributes.class);
            FileTime time = accessedDate.lastAccessTime();
            actualAccessedDate = convertDateToString(time);
        } catch (IOException e) {
            throw new IOException("Accessed date could not be retrieved");
        }
        return actualAccessedDate;
    }

    /**
     * convertDateToString method allows to convert a Date to String.
     * @param time       File time with the Date to be converted.
     * @return formatted String value that contains the date value converted
     *                   to String.
     */
    public String convertDateToString(FileTime time){
        String pattern = "yyyyMMdd";
        String formatted;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        formatted = simpleDateFormat.format(new Date(time.toMillis()));
        return formatted;
    }

    /**
     * filterByOwner method filters files based on Owner criteria.
     * @param file                   Item (file or directory) that will be
     *                               evaluated according to the search criteria
     * @param owner                  String value which is the expected Owner.
     *                               option is selected.
     * @return addFileToSearchResult Boolean value that is used to determine if
     *                               the file/directory is added to the list of
     *                               results.
     */
    private boolean filterByOwner(File file, String owner) throws IOException{
        boolean addFileToSearchResult = false;
        String currentOwner;

        if (owner == null) {
            addFileToSearchResult = true;
        } else {
            try{
                currentOwner = getCurrentOwner(file);
                addFileToSearchResult = currentOwner.equals(owner);
            } catch (IOException e){
                throw e;
            }
        }
        return addFileToSearchResult;
    }

    /**
     * getCurrentOwner method allows to get the owner of a particular file/directory.
     * @param file   Item (file or directory) that will be
     *               evaluated.
     * @return owner String value that contains the owner name to be used as search
     *               criteria.
     */
    private String getCurrentOwner(File file) throws IOException{
        String owner = null;

        try{
            Path filePath = Paths.get(file.getPath());
            FileOwnerAttributeView ownerInfo = java.nio.file.Files.getFileAttributeView(filePath,
                FileOwnerAttributeView.class);
            UserPrincipal fileOwner = ownerInfo.getOwner();
            owner = fileOwner.getName();
        } catch (IOException e){
            throw new IOException("Owner could not be retrieved");
        }
        return owner;
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
     * @param owner         String  value that stores the information about
     *                      owner attribute.
     * @param createdDate   String value that stores the information about
     *                      Created Date.
     * @param modifiedDate  String value that stores the information about
     *                      Modified Date.
     * @return searchResult Object from SearchResult class that contains the
     *                      information related to the file/directory that will
     *                      be returned as part of the result.
     */
    private SearchResult createSearchResult(String path, String name, String
                                            extension, long size, boolean readOnly,
                                            boolean isHidden, boolean isDirectory,
                                            String owner, String createdDate,
                                            String modifiedDate, String accessedDate) {
        SearchResult searchResult = new SearchResult();
        searchResult.setPathResult(path);
        searchResult.setFileNameResult(name);
        searchResult.setFileExtensionResult(extension);
        searchResult.setFileSizeResult(size);
        searchResult.setReadOnlyResult(readOnly);
        searchResult.setHiddenResult(isHidden);
        searchResult.setIsDirectoryResult(isDirectory);
        searchResult.setOwnerResult(owner);
        searchResult.setCreatedDateResult(createdDate);
        searchResult.setModifiedDateResult(modifiedDate);
        searchResult.setAccessedDateResult(accessedDate);
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
