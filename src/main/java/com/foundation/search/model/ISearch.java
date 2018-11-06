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

import java.io.IOException;
import java.util.List;

/**
 * This interface define the behavior of the methods to perform the search of
 * different files by a set of criteria.
 *
 * @author Shirley Soto
 * @version 1.0.
 */
public interface ISearch {
    List<Asset> searchFiles(Criteria criteria) throws IOException;
}
