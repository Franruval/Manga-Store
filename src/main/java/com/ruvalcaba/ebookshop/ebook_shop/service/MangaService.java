package com.ruvalcaba.ebookshop.ebook_shop.service;

import com.ruvalcaba.ebookshop.ebook_shop.entity.Manga;
import com.ruvalcaba.ebookshop.ebook_shop.repository.MangaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaService {

    private MangaRepository mangaRepository;

    // Dependency injection
    public MangaService(MangaRepository mangaRepository){
        this.mangaRepository = mangaRepository;
    }

    public List<Manga> getAllMangas(){
       return mangaRepository.findAll();
    }

    public void save(Manga m){
        mangaRepository.save(m);
    }

    public Manga getMangaById(Long id){
        return mangaRepository.findById(id).get();
    }
}
