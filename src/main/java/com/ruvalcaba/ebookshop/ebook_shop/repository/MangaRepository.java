package com.ruvalcaba.ebookshop.ebook_shop.repository;

import com.ruvalcaba.ebookshop.ebook_shop.entity.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Long> {

}
