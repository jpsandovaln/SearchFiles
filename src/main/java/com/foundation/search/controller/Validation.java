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

/**
 * This class contains validation methods for entry values
 *
 * @author Mary Ricalde
 * @version 1.0.
 */
public class Validation {

    /**
     * This method verifies that the value of a field if not empty or null.
     *
     * @param field String value to be verified.
     * @return True if the field is empty or null, false otherwise.
     */
    public static boolean isFieldNullOrEmpty(String field){
        boolean fieldVerification = false;

        if (field == null || field.isEmpty()) {
            fieldVerification = true;
        }
        return fieldVerification;
    }

    /**
     * This method verifies valid path expression. The path requires prefixing
     * a drive letter, colon and backslash.
     *
     * @param pathName Name of the path which is going to be verified. i.e. "C:\Users"
     * @return True if the path is valid, false otherwise.
     */
    public static boolean isValidPath(String pathName){
        boolean pathVerification = false;
        String pathPattern = "^[a-zA-Z]:\\\\[\\S|*\\S]?.*$";

        if (isFieldNullOrEmpty(pathName)) {
            return pathVerification;
        }

        if (pathName.matches(pathPattern)) {
            pathVerification = true;
        }
        return pathVerification;
    }

    /**
     * This method verifies valid file name. A file name could contain alphanumeric,
     * underscore and dash characters
     *
     * @param fileName Name of the file which is going to be verified. i.e. "Document 2"
     * @return boolean
     */
    public static boolean isValidFileName(String fileName){
        boolean fileVerification = false;
        String filePattern = "[\\w ?-]*$";

        if (fileName.matches(filePattern)) {
            fileVerification = true;
        }
        return fileVerification;
    }

    /**
     * This method verifies valid owner name. An owner name could contain alphanumeric
     * underscore, backslash, space and dash characters.
     *
     * @param owner Name of the owner which is going to be verified. i.e. "PC1\admin_1"
     * @return boolean
     */
    public static boolean isValidOwnerName(String owner){
        boolean ownerVerification = false;
        String filePattern = "[\\w \\\\-]*$";

        if (owner.matches(filePattern)) {
            ownerVerification = true;
        }
        return ownerVerification;
    }

    /**
     * This method validates the extension of a file, the extension should have a
     * size between 2 and 4 characters only and should match with any of the values
     * on the extension pattern list.
     *
     * @param extension File extension. i.e. "txt"
     * @return boolean
     */
    public static boolean isValidFileExtension(String extension){
        boolean extensionVerification = false;
        String extensionPattern =
            "(exe|png|mp4|pdf|mp3|jpg|txt|xls|xlsx|sh|java|php|bat|avi|xml|json|doc|docx)$";

        if (extension.matches(extensionPattern)) {
            extensionVerification = true;
        }
        return extensionVerification;
    }

    /**
     * This method validates an input size value for a file. The size should be
     * between a range of 0 to 9 whole numbers.
     *
     * @param size File size. i.e. "20"
     * @return boolean
     */
    public static boolean isValidSize(String size){
        boolean sizeVerification = false;
        String sizePattern = "^\\d{1,9}+$";

        if (size.matches(sizePattern)) {
            sizeVerification = true;
        }
        return sizeVerification;
    }
}
