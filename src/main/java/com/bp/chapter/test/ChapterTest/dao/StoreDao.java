package com.bp.chapter.test.ChapterTest.dao;

import com.bp.chapter.test.ChapterTest.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreDao  extends JpaRepository<Store, Long> {
}
