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

/**
 * This class contains the attributes related to the search criteria and also 
 * the methods to get and set these values.
 *
 * @author Shirley Soto
 * @version 1.0.
 */
public class Criteria {
    private String path;
    private String fileName;
    private String fileExtension;
    private long fileSize;
    private char sizeComparator;
    private boolean sizeOption;
    private boolean readOnly;
    private boolean hidden;
    private boolean isDirectory;
    private String owner;
    private boolean isCreatedDateSelected;
    private boolean isModifiedDateSelected;
    private boolean isAccessedDateSelected;
    private String createdDate;
    private String modifiedDate;
    private String accessedDate;
    private String textToSearch;

    /**
     * getPath method returns the path value.
     *
     * @return path String that contains the path where the files will be searched.
     */
    public String getPath(){
        return this.path;
    }

    /**
     * getFileName method returns the file name.
     *
     * @return fileName String that contains the file name.
     */
    public String getFileName(){
        return this.fileName;
    }

    /**
     * getFileExtension method returns the file extension.
     *
     * @return fileExtension String that contains the file extension.
     */
    public String getFileExtension(){
        return this.fileExtension;
    }

    /**
     * getFileSize method returns the file size.
     *
     * @return fileSize long number that contains the file size.
     */
    public long getFileSize(){
        return this.fileSize;
    }

    /**
     * getSizeComparator method returns the size comparator.
     *
     * @return SizeComparator Char that contains the file size comparator.
     */
    public char getSizeComparator(){
        return this.sizeComparator;
    }

    /**
     * getSizeOption method returns true if the Size checkbox is selected.
     *
     * @return sizeOption Boolean that returns if the size checkbox is
     *                    selected.
     */
    public boolean getSizeOption(){
        return this.sizeOption;
    }

    /**
     * getReadOnly method returns the status (checked-unchecked) from read
     * only checkbox.
     *
     * @return readOnly Boolean that returns if the Read only checkbox is
     *                  selected.
     */
    public boolean getReadOnly(){
        return this.readOnly;
    }

    /**
     * getIsDirectory      method returns the status (checked-unchecked) f
     *                     rom Is Directory checkbox.
     *
     * @return isDirectory Boolean that returns if the 'Is Directory'
     *                     checkbox is selected.
     */
    public boolean getIsDirectory(){
        return this.isDirectory;
    }

    /**
     * getHidden method returns the status (checked-unchecked) from Hidden checkbox.
     *
     * @return hidden Boolean that returns if the hidden checkbox is selected.
     */
    public boolean getHidden(){
        return this.hidden;
    }

    /**
     * getOwner method returns the owner name.
     *
     * @return owner String that contains the owner name.
     */
    public String getOwner(){
        return this.owner;
    }

    /**
     * getCreatedDateSelected method returns the status of Created Date checkbox.
     *
     * @return isCreatedDateSelected Boolean equal to true when Created Date checkbox
     *         is selected.
     */
    public boolean getCreatedDateSelected(){
        return this.isCreatedDateSelected;
    }

    /**
     * getModifiedDateSelected method returns the status of Modified Date checkbox.
     *
     * @return isModifiedDateSelected Boolean equal to true when Modified Date checkbox
     *         is selected.
     */
    public boolean getModifiedDateSelected(){
        return this.isModifiedDateSelected;
    }

    /**
     * getAccessedDateSelected method returns the status of Accessed Date checkbox.
     *
     * @return isAccessedDateSelected Boolean equal to true when Accessed Date checkbox
     *         is selected.
     */
    public boolean getAccessedDateSelected(){
        return this.isAccessedDateSelected;
    }

    /**
     * getCreatedDate method returns the created Date value.
     *
     * @return createdDate String that contains the Created Date value.
     */
    public String getCreatedDate(){
        return this.createdDate;
    }

    /**
     * getModifiedDate method returns the Modified Date value.
     *
     * @return modifiedDate String that contains the Modified Date value.
     */
    public String getModifiedDate(){
        return this.modifiedDate;
    }

    /**
     * getAccessedDate method returns the Accessed Date value.
     *
     * @return AccessedDate String that contains the Accessed Date value.
     */
    public String getAccessedDate(){
        return this.accessedDate;
    }

    /**
     * getTextToSearch method returns the Text to search in the files.
     *
     * @return textToSearch String that contains the text to search in files.
     */
    public String getTextToSearch(){
        return this.textToSearch;
    }

    /**
     * setPath method allows to set the path value.
     *
     * @param path String that contains the path value.
     */
    public void setPath(String path){
        this.path = path;
    }

    /**
     * setFileName method allows to set the File Name value.
     *
     * @param fileName String that contains the file name.
     */
    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    /**
     * setFileExtension method allows to set the File Extension value.
     *
     * @param fileExtension String that contains the file extension.
     */
    public void setFileExtension(String fileExtension){
        this.fileExtension = fileExtension;
    }

    /**
     * setFileSize method allows to set the File Size value.
     *
     * @param fileSize long number that contains the file size.
     */
    public void setFileSize(long fileSize){
        this.fileSize = fileSize;
    }

    /**
     * setSizeComparator method allows to set the File Size comparator.
     *
     * @param sizeComparator char that contains the size comparator.
     */
    public void setSizeComparator(char sizeComparator){
        this.sizeComparator = sizeComparator;
    }

    /**
     * setSizeOption method allows to set the  Size option (checkbox).
     *
     * @param sizeOption boolean  that indicates if the size checkbox
     *                   is selected.
     */
    public void setSizeOption(boolean sizeOption){
        this.sizeOption = sizeOption;
    }

    /**
     * setReadOnly method allows to set the  Read only option.
     *
     * @param readOnly boolean  that indicates if the Read Only checkbox
     *                 is selected.
     */
    public void setReadOnly(boolean readOnly){
        this.readOnly = readOnly;
    }

    /**
     * setHidden method allows to set the  hidden option.
     *
     * @param hidden boolean  that indicates if the Hidden checkbox is
     *               selected.
     */
    public void setHidden(boolean hidden){
        this.hidden = hidden;
    }

    /**
     * setIsDirectory method allows to set the  isDirectory option.
     *
     * @param isDirectory boolean  that indicates if the isDirectory
     *                    checkbox is selected.
     */
    public void setIsDirectory(boolean isDirectory){
        this.isDirectory = isDirectory;
    }

    /**
     * setOwner method allows to set the owner value.
     *
     * @param owner string that stores the 'Owner' search criteria
     */
    public void setOwner(String owner){
        this.owner = owner;
    }

    /**
     * setCreatedDateOption method allows to set the value for
     * Created Date checkbox.
     *
     * @param isCreatedDateSelected boolean that stores the information about
     *        Created Date checkbox.
     */
    public void setCreatedDateOption(boolean isCreatedDateSelected){
        this.isCreatedDateSelected = isCreatedDateSelected;
    }

    /**
     * setModifiedDateOption method allows to set the value for
     * Modified Date checkbox.
     *
     * @param isModifiedDateSelected boolean that stores the information about
     *        Modified Date checkbox.
     */
    public void setModifiedDateOption(boolean isModifiedDateSelected){
        this.isModifiedDateSelected = isModifiedDateSelected;
    }

    /**
     * setAccessedDateOption method allows to set the value for
     * Accessed Date checkbox.
     *
     * @param isAccessedDateSelected boolean that stores the information about
     *        Accessed Date checkbox.
     */
    public void setAccessedDateOption(boolean isAccessedDateSelected){
        this.isAccessedDateSelected = isAccessedDateSelected;
    }

    /**
     * setCreatedDate method allows to set the Created Date value.
     *
     * @param createdDate string that stores the 'created Date' search criteria
     */
    public void setCreatedDate(String createdDate){
        this.createdDate = createdDate;
    }

    /**
     * setModifiedDate method allows to set the Modified Date value.
     *
     * @param modifiedDate string that stores the 'Modified Date' search criteria
     */
    public void setModifiedDate(String modifiedDate){
        this.modifiedDate = modifiedDate;
    }

    /**
     * setAccessedDate method allows to set the Accessed Date value.
     *
     * @param accessedDate string that stores the 'accessed Date' search criteria
     */
    public void setAccessedDate(String accessedDate){
        this.accessedDate = accessedDate;
    }

    /**
     * setTextToSearch method allows to set the Text to search.
     *
     * @param textToSearch string that stores the Text to search in files.
     */
    public void setTextToSearch(String textToSearch){
        this.textToSearch = textToSearch;
    }
}
