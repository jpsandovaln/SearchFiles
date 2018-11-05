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

/**
 * This class contains the attributes and methods which purpose is to set the
 * information related to different type of files that are part of a search
 * results.
 *
 * @author Shirley Soto
 * @version 1.0.
 */
public class Asset {
    private String pathResult;
    private String fileNameResult;
    private String fileExtensionResult;
    private long fileSizeResult;
    private boolean hiddenResult;
    private String ownerResult;
    private String createdDateResult;
    private String modifiedDateResult;
    private String accessedDateResult;

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
     * getHiddenResult method returns the Hidden status of the file.
     *
     * @return hiddenResult  boolean that contains the hidden status.
     */
    public boolean getHiddenResult(){
        return this.hiddenResult;
    }

    /**
     * getOwnerResult method returns the Owner of the file.
     *
     * @return ownerResult String that contains the file/directory owner.
     */
    public String getOwnerResult(){
        return this.ownerResult;
    }

    /**
     * getCreatedDateResult method returns the Created Date from the search
     * result.
     *
     * @return createdDateResult String that contains the Created Date value.
     */
    public String getCreatedDateResult(){
        return this.createdDateResult;
    }

    /**
     * getModifiedDateResult method returns the Modified Date from the search
     * result.
     *
     * @return modifiedDateResult String that contains the Modified Date value.
     */
    public String getModifiedDateResult(){
        return this.modifiedDateResult;
    }

    /**
     * getAccessedDateResult method returns the Accessed Date from the search
     * result.
     *
     * @return accessedDateResult String that contains the Accessed Date value.
     */
    public String getAccessedDateResult(){
        return this.accessedDateResult;
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
     * setHiddenResult method allows to set the Hidden result.
     *
     * @param hidden  boolean that contains the file Hidden result.
     */
    public void setHiddenResult(boolean hidden){
        hiddenResult = hidden;
    }

    /**
     * setOwnerResult method allows to set the owner result.
     *
     * @param owner String that contains the owner name to set as a result.
     */
    public void setOwnerResult(String owner){
        ownerResult = owner;
    }

    /**
     * setCreatedDateResult method allows to set the Created Date result.
     *
     * @param createdDate String that contains the Created Date to set as a result.
     */
    public void setCreatedDateResult(String createdDate){
        createdDateResult = createdDate;
    }

    /**
     * setModifiedDateResult method allows to set the Modified Date result.
     *
     * @param modifiedDate String that contains the Modified Date to set as a result.
     */
    public void setModifiedDateResult(String modifiedDate){
        modifiedDateResult = modifiedDate;
    }

    /**
     * setAccessedDateResult method allows to set the Accessed Date result.
     *
     * @param accessedDate String that contains the Accessed Date to set as a result.
     */
    public void setAccessedDateResult(String accessedDate){
        accessedDateResult = accessedDate;
    }
}
