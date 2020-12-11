package com.xib.assessment.utils;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Page implements Pageable {
    private final int pageSize;
    private final int pageNumber;

    public Page(int pageNumber, int pageSize) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    /**
     * Returns the page to be returned.
     *
     * @return the page to be returned.
     */
    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * Returns the number of items to be returned.
     *
     * @return the number of items of that page
     */
    @Override
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Returns the offset to be taken according to the underlying page and page size.
     *
     * @return the offset to be taken
     */
    @Override
    public long getOffset() {
        return 0;
    }

    /**
     * Returns the sorting parameters.
     *
     * @return
     */
    @Override
    public Sort getSort() {
        return Sort.by("id");
    }

    /**
     * Returns the {@link Pageable} requesting the next {@link Page}.
     *
     * @return
     */
    @Override
    public Pageable next() {
        return this;
    }

    /**
     * Returns the previous {@link Pageable} or the first {@link Pageable} if the current one already is the first one.
     *
     * @return
     */
    @Override
    public Pageable previousOrFirst() {
        return this;
    }

    /**
     * Returns the {@link Pageable} requesting the first page.
     *
     * @return
     */
    @Override
    public Pageable first() {
        return this;
    }

    /**
     * Returns whether there's a previous {@link Pageable} we can access from the current one. Will return
     * {@literal false} in case the current {@link Pageable} already refers to the first page.
     *
     * @return
     */
    @Override
    public boolean hasPrevious() {
        return false;
    }
}
