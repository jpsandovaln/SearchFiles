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
 * information related to files and directories that are part of the search 
 * results.
 *
 * @author Shirley Soto
 * @version 1.0.
 */
public class SearchResult extends Asset{
    private boolean readOnlyResult;
    private boolean isDirectoryResult;

    /**
     * getReadOnlyResult method returns the Read only status of the file.
     *
     * @return readOnly boolean that contains the read only status.
     */
    public boolean getReadOnlyResult(){
        return this.readOnlyResult;
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
     * setReadOnlyResult method allows to set the Read Only result.
     *
     * @param readOnly boolean that contains the file size result.
     */
    public void setReadOnlyResult(boolean readOnly){
        readOnlyResult = readOnly;
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
