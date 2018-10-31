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

public class Criteria {
    public String path;
    public String fileName;
    public String fileExtension;
    public long fileSize;
    public char sizeComparator;
    public boolean sizeOption;
    public boolean readOnly;
    public boolean hidden;
    public boolean isDirectory;

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
}
