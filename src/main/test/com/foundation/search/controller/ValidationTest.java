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

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This class contains unit tests for field validations
 *
 * @author Mary Ricalde
 * @version 1.0.
 */
public class ValidationTest {

    @Test
    public void validationIsValidPathWithDriveLetterColonAndBackslash() {
        String path = "C:\\";
        boolean actualResult = Validation.isValidPath(path);
        assertEquals(true, actualResult);
    }

    @Test
    public void validationIsValidPathWhenValidPathIsIntroduced() {
        String path = "C:\\files";
        boolean actualResult = Validation.isValidPath(path);
        assertEquals(true, actualResult);
    }

    @Test
    public void validationIsValidPathWithInvalidDrive(){
        String path = "@:";
        boolean actualResult = Validation.isValidPath(path);
        assertEquals(false, actualResult);
    }

    @Test
    public void validationIsValidPathWithMissingColon(){
        String path = "C\\";
        boolean actualResult = Validation.isValidPath(path);
        assertEquals(false, actualResult);
    }

    @Test
    public void validationIsValidPathWithMissingBackslash() {
        String path = "C:";
        boolean actualResult = Validation.isValidPath(path);
        assertEquals(false, actualResult);
    }

    @Test
    public void validationIsValidPathWithEmptyPath(){
        String path = "";
        boolean actualResult = Validation.isValidPath(path);
        assertEquals(false, actualResult);
    }

    @Test
    public void validationIsFieldNullOrEmptyWhenPathIsNull(){
        String path = null;
        boolean actualResult = Validation.isFieldNullOrEmpty(path);
        assertEquals(true, actualResult);
    }

    @Test
    public void validationIsFieldNullOrEmptyWhenPathIsEmpty(){
        String path = "";
        boolean actualResult = Validation.isFieldNullOrEmpty(path);
        assertEquals(true, actualResult);
    }

    @Test
    public void validationIsValidFileNameWhenItIsAlphanumeric() {
        String fileName = "text 12";
        boolean actualResult = Validation.isValidFileName(fileName);
        assertEquals(true, actualResult);
    }

    @Test
    public void validationIsValidFileNameWithDash() {
        String fileName = "text-t12";
        boolean actualResult = Validation.isValidFileName(fileName);
        assertEquals(true, actualResult);
    }

    @Test
    public void validationIsValidFileNameWithUnderscore() {
        String fileName = "text_t12";
        boolean actualResult = Validation.isValidFileName(fileName);
        assertEquals(true, actualResult);
    }

    @Test
    public void validationIsValidFileNameWithInvalidCharacters() {
        String fileName = "text1@+";
        boolean actualResult = Validation.isValidFileName(fileName);
        assertEquals(false, actualResult);
    }

    @Test
    public void validationIsValidOwnerNameWithAlphanumericText() {
        String ownerName = "juan10";
        boolean actualResult = Validation.isValidOwnerName(ownerName);
        assertEquals(true, actualResult);
    }

    @Test
    public void validationIsValidOwnerNameWithOnlyText() {
        String ownerName = "admin";
        boolean actualResult = Validation.isValidOwnerName(ownerName);
        assertEquals(true, actualResult);
    }

    @Test
    public void validationIsValidOwnerNameWithValidCharacter() {
        String ownerName = "juan_10";
        boolean actualResult = Validation.isValidOwnerName(ownerName);
        assertEquals(true, actualResult);
    }

    @Test
    public void validationIsValidOwnerNameWithAllValidCharacters() {
        String ownerName = "PC1\\admin 1";
        boolean actualResult = Validation.isValidOwnerName(ownerName);
        assertEquals(true, actualResult);
    }

    @Test
    public void validationIsValidOwnerNameWithInvalidCharacter() {
        String ownerName = "admin@1";
        boolean actualResult = Validation.isValidOwnerName(ownerName);
        assertEquals(false, actualResult);
    }

    @Test
    public void validationIsValidFileExtensionWithLengthOf2() {
        String extension = "sh";
        boolean actualResult = Validation.isValidFileExtension(extension);
        assertEquals(true, actualResult);
    }

    @Test
    public void validationIsValidFileExtensionWithLengthOf4() {
        String extension = "xlsx";
        boolean actualResult = Validation.isValidFileExtension(extension);
        assertEquals(true, actualResult);
    }

    @Test
    public void validationIsValidFileExtensionWithValidAlphanumericText() {
        String extension = "mp4";
        boolean actualResult = Validation.isValidFileExtension(extension);
        assertEquals(true, actualResult);
    }

    @Test
    public void validationIsValidFileExtensionWithLengthOf6() {
        String extension = "pdfxls";
        boolean actualResult = Validation.isValidFileExtension(extension);
        assertEquals(false, actualResult);
    }

    @Test
    public void validationIsValidFileExtensionWithLengthOf1() {
        String extension = "t";
        boolean actualResult = Validation.isValidFileExtension(extension);
        assertEquals(false, actualResult);
    }

    @Test
    public void validationIsValidFileExtensionWithEmptyText() {
        String extension = " ";
        boolean actualResult = Validation.isValidFileExtension(extension);
        assertEquals(false, actualResult);
    }

    @Test
    public void validationIsValidSizeWithMaxWholeNumbers() {
        String size = "999999999";
        boolean actualResult = Validation.isValidSize(size);
        assertEquals(true, actualResult);
    }

    @Test
     public void validationIsValidSizeWithMinimumSizeNumber() {
        String size = "0";
        boolean actualResult = Validation.isValidSize(size);
        assertEquals(true, actualResult);
    }

    @Test
    public void validationIsValidSizeWithoutDefinedLength() {
        String size = "";
        boolean actualResult = Validation.isValidSize(size);
        assertEquals(false, actualResult);
    }

    @Test
    public void validationIsValidSizeWithInvalidAlphanumericText() {
        String size = "22d";
        boolean actualResult = Validation.isValidSize(size);
        assertEquals(false, actualResult);
    }

    @Test
     public void validationIsValidSizeWhenSizeExceedsOf9Numbers() {
        String size = "9999999887";
        boolean actualResult = Validation.isValidSize(size);
        assertEquals(false, actualResult);
    }

    @Test
    public void validationIsValidSizeWhenSpacesAreFound() {
        String size = "150 5";
        boolean actualResult = Validation.isValidSize(size);
        assertEquals(false, actualResult);
    }

    @Test
    public void validationIsValidSizeWhenSizeHasDecimals() {
        String size = "150.25";
        boolean actualResult = Validation.isValidSize(size);
        assertEquals(false, actualResult);
    }
}