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
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * This class contains the unit tests for search file method.
 * It includes searchs by all criteria that is supported.
 *
 * @author Shirley Soto
 * @version 1.0.
 */
public class SearchTest {

    @Test
    public void searchSearchFilesByNameWithOnlySpaces() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setFileName("  ");
        searchResultList = search.searchFiles(criteria);
        actualCount = 0;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount, expectedCount);
    }

    @Test
    public void searchSearchFilesByEmptyName() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setFileName("");
        searchResultList = search.searchFiles(criteria);
        actualCount = 0;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByNonExistingOwner() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setOwner("testUser");
        searchResultList = search.searchFiles(criteria);
        actualCount = 0;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesTooShortExtension() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        String expectedExtension;
        String actualExtension;
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setFileExtension("a");
        searchResultList = search.searchFiles(criteria);
        actualCount = 0;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesTooLongExtension() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        String expectedExtension;
        String actualExtension;
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setFileExtension("abcdefg");
        searchResultList = search.searchFiles(criteria);
        actualCount = 0;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesEmptyFolder() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setTextToSearch("hi");
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/empty");
        searchResultList = search.searchFiles(criteria);
        actualCount = 0;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByContent() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setTextToSearch("hi");
        searchResultList = search.searchFiles(criteria);
        actualCount = 6;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByAccessedDate() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setAccessedDateOption(true);
        criteria.setAccessedDate("20181104");
        searchResultList = search.searchFiles(criteria);
        actualCount = 17;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByModifiedDate() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setModifiedDate("20181014");
        criteria.setModifiedDateOption(true);
        searchResultList = search.searchFiles(criteria);
        actualCount = 1;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByCreatedDate() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setCreatedDate("20181104");
        criteria.setCreatedDateOption(true);
        searchResultList = search.searchFiles(criteria);
        actualCount = 17;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByOwner() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setOwner("JALASOFT\\Shirley Soto");
        searchResultList = search.searchFiles(criteria);
        actualCount = 17;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByDirectoryOnly() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setIsDirectory(true);
        searchResultList = search.searchFiles(criteria);
        actualCount = 7;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByDirectoryFalse() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setIsDirectory(false);
        searchResultList = search.searchFiles(criteria);
        actualCount = 17;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByHidden() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setHidden(true);
        searchResultList = search.searchFiles(criteria);
        actualCount = 2;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesBytHiddenFalse() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setHidden(false);
        searchResultList = search.searchFiles(criteria);
        actualCount = 17;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByReadOnly() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setReadOnly(true);
        searchResultList = search.searchFiles(criteria);
        actualCount = 1;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByReadOnlyFalse() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setReadOnly(false);
        searchResultList = search.searchFiles(criteria);
        actualCount = 17;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByFileName() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setFileName("file2");
        searchResultList = search.searchFiles(criteria);
        actualCount = 2;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByPath() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        searchResultList = search.searchFiles(criteria);
        actualCount = 17;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByExtensionWithThreeCharacters() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setFileExtension("txt");
        searchResultList = search.searchFiles(criteria);
        actualCount = 4;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByExtensionFourCharacters() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        String expectedExtension;
        String actualExtension;
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setFileExtension("xlsx");
        searchResultList = search.searchFiles(criteria);
        actualCount = 1;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }

    @Test
    public void searchSearchFilesByNameAndExtension() throws IOException{
        int actualCount;
        int expectedCount;

        List<Asset> searchResultList = new ArrayList();
        Search search = new Search();
        Criteria criteria = new Criteria();
        criteria.setPath(System.getProperty("user.dir") + "/test/com/foundation/search/model/files");
        criteria.setFileName("file2");
        criteria.setFileExtension("txt");
        searchResultList = search.searchFiles(criteria);
        actualCount = 1;
        expectedCount = searchResultList.size();
        System.out.println("Actual count: " + actualCount);
        System.out.println("Expected count: " + expectedCount);
        assertEquals(actualCount,expectedCount);
    }
}



