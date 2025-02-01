package com.ruvalcaba.ebookshop.ebook_shop.repository;

import com.ruvalcaba.ebookshop.ebook_shop.entity.MyMangas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyMangasRepository extends JpaRepository<MyMangas, Long> {
}
