package com.ruvalcaba.ebookshop.ebook_shop.service;

import com.ruvalcaba.ebookshop.ebook_shop.entity.Manga;
import com.ruvalcaba.ebookshop.ebook_shop.repository.MangaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MangaService {

    private final MangaRepository mangaRepository;

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
        return mangaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manga not found with id: " + id));
    }

    public void deleteManga(Long id) {
        mangaRepository.deleteById(id);
    }
}