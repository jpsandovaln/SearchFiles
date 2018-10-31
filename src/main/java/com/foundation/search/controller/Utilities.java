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
 * This class is an utility library that contains conversion to bytes method
 *
 * @author Mary Ricalde
 * @version 1.0.
 */
public class Utilities {
    private static final long UNIT_MEASURE_BASE = 1024;
    private static final long UNIT_MEASURE_KB = UNIT_MEASURE_BASE;
    private static final long UNIT_MEASURE_MB = UNIT_MEASURE_BASE * UNIT_MEASURE_KB;
    private static final long UNIT_MEASURE_GB = UNIT_MEASURE_BASE * UNIT_MEASURE_MB;

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
}
