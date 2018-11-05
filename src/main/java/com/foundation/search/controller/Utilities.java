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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is an utility library that contains conversion methods
 *
 * @author Mary Ricalde
 * @version 1.0.
 */
public class Utilities {
    private static final long UNIT_MEASURE_BASE = 1024;
    private static final long UNIT_MEASURE_KB = UNIT_MEASURE_BASE;
    private static final long UNIT_MEASURE_MB = UNIT_MEASURE_BASE * UNIT_MEASURE_KB;
    private static final long UNIT_MEASURE_GB = UNIT_MEASURE_BASE * UNIT_MEASURE_MB;
    private static final String FORMAT_DATE_PATTERN = "yyyyMMdd";

    /**
     * This method converts a provided size which can be in GB. MB or KB to bytes
     *
     * @param value         Integer value to be converter to bytes
     * @param unitOfMeasure Initial unit of measure for the introduced value.
     *                      This can be GB, MB or KB.
     * @return A long value with the equivalence of byte numbers
     */
    public static long convertToBytes(int value, String unitOfMeasure){
        String unitMeasureOption = unitOfMeasure.toUpperCase();
        long  convertedToBytes = 0;

        switch (unitMeasureOption) {
            case "GB":
                System.out.println("entro aca!");
                convertedToBytes = value * UNIT_MEASURE_GB;
                break;
            case "MB":
                convertedToBytes = value * UNIT_MEASURE_MB;
                break;
            case "KB":
                convertedToBytes = value * UNIT_MEASURE_KB;
                break;
        }
        return convertedToBytes;
    }

    /**
     * This method converts a provided date to String.
     *
     * @param date Value of data type Date to convert
     * @return String value that contains the date value converted
     *         to String formatted to yyyyMMdd
     */
    public static String convertToFormatDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE_PATTERN);
        String formatted = simpleDateFormat.format(date);
        return formatted;
    }

    /**
     * This method converts a boolean result to String
     *
     * @param result Boolean value to convert (true or false)
     * @return String value Yes or No
     */
    public static String convertBooleanResultToString(boolean result){
        if (result == true) {
            return "Yes";
        } else {
            return "No";
        }
    }

    /**
     * This method converts a boolean directory result to String
     *
     * @param isDirectory Boolean value to convert (true or false)
     * @return String value Directory or File
     */
    public static String convertDirectoryResultToString(boolean isDirectory){
        if (isDirectory == true) {
            return "Directory";
        } else {
            return "File";
        }
    }
}
