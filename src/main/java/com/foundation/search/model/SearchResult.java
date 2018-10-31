/*
 * Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jalasoft, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 *  with Jalasoft.
 */

package com.foundation.search.model;

public class SearchResult {
    public String pathResult;
    public String fileNameResult;
    public String fileExtensionResult;
    public long fileSizeResult;
    public boolean readOnlyResult;
    public boolean hiddenResult;
    public boolean isDirectoryResult;

    /**
     * getPathResult method returns the path result.
     *
     * @return pathResult String that contains the path where the files were searched.
     */
    public String getPathResult(){
        return this.pathResult;
    }

    /**
     * getFileNameResult method returns the file name result.
     *
     * @return fileNameResult String that contains the file name result.
     */
    public String getFileNameResult(){
        return this.fileNameResult;
    }

    /**
     * getFileExtensionResult method returns the file extension result.
     *
     * @return fileExtensionResult String that contains the file extension result.
     */
    public String getFileExtensionResult(){
        return this.fileExtensionResult;
    }

    /**
     * getFileSizeResult method returns the file extension result.
     *
     * @return fileSizeResult long that contains the file size result.
     */
    public long getFileSizeResult(){
        return this.fileSizeResult;
    }

    /**
     * getReadOnlyResult method returns the Read only status of the file.
     *
     * @return readOnly boolean that contains the read only status.
     */
    public boolean getReadOnlyResult(){
        return this.readOnlyResult;
    }

    /**
     * getHiddenResult method returns the Hidden status of the file.
     *
     * @return hiddenResult  boolean that contains the hidden status.
     */
    public boolean getHiddenResult(){
        return this.hiddenResult;
    }

    /**
     * getIsDirectoryResult method returns the isDirectory status of the file.
     *
     * @return isDirectoryResult boolean that contains the isDirectory status.
     */
    public boolean getIsDirectoryResult(){
        return this.isDirectoryResult;
    }

    /**
     * setPathResult method allows to set the path result.
     *
     * @param path String that contains the path result.
     */
    public void setPathResult(String path){
        pathResult = path;
    }

    /**
     * setFileNameResult method allows to set the File Name result.
     *
     * @param fileName String that contains the file name result.
     */
    public void setFileNameResult(String fileName){
        fileNameResult = fileName;
    }

    /**
     * setFileExtensionResult method allows to set the File Extension result.
     *
     * @param fileExtension String that contains the file extension result.
     */
    public void setFileExtensionResult(String fileExtension){
        fileExtensionResult = fileExtension;
    }

    /**
     * setFileSizeResult method allows to set the File Size result.
     *
     * @param fileSize long that contains the file size result.
     */
    public void setFileSizeResult(long fileSize){
        fileSizeResult = fileSize;
    }

    /**
     * setReadOnlyResult method allows to set the Read Only result.
     *
     * @param readOnly boolean that contains the file size result.
     */
    public void setReadOnlyResult(boolean readOnly){
        readOnlyResult = readOnly;
    }

    /**
     * setHiddenResult method allows to set the Hidden result.
     *
     * @param hidden  boolean that contains the file Hidden result.
     */
    public void setHiddenResult(boolean hidden){
        hiddenResult = hidden;
    }

    /**
     * setIsDirectoryResult method allows to set the isDirectory result.
     *
     * @param isDirectory boolean that contains the isdDirectory result.
     */
    public void setIsDirectoryResult(boolean isDirectory){
        isDirectoryResult = isDirectory;
    }
}
