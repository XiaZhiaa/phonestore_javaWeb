package cn.mrzhang.phonestore.commons;

import java.util.List;

public class Page {

    private List records;

    private Integer pageSize = 5;

    private Integer startIndex;

    private Integer currentPage;

    private Integer prePage;

    private Integer nextPage;

    private Integer totalPages;

    private Integer totalRecords;

    private String url;

    public Page(Integer currentPage, Integer totalRecords) {
        this.currentPage = currentPage;
        this.totalRecords = totalRecords;
        totalPages = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;
        startIndex = (currentPage - 1 ) * pageSize;
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPrePage() {
        prePage = currentPage - 1 > 0 ? currentPage - 1: 1;
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getNextPage() {
        nextPage = currentPage + 1 > totalPages ? totalPages : currentPage + 1;
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
