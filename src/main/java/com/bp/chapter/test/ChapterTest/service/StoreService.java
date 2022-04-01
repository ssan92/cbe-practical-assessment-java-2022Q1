package com.bp.chapter.test.ChapterTest.service;

import com.bp.chapter.test.ChapterTest.exception.StoreException;
import com.bp.chapter.test.ChapterTest.model.response.DataResponse;
import com.bp.chapter.test.ChapterTest.request.StoreRequest;

public interface StoreService {

    public DataResponse fnCreateStore(StoreRequest storeRequest) throws StoreException;
}
