package com.ruvalcaba.ebookshop.ebook_shop.service;

import com.ruvalcaba.ebookshop.ebook_shop.entity.MyMangas;
import com.ruvalcaba.ebookshop.ebook_shop.repository.MyMangasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyMangasService {

    private MyMangasRepository myMangasRepository;

    MyMangasService(MyMangasRepository myMangasRepository){
        this.myMangasRepository = myMangasRepository;
    }

    public void saveMyMangas(MyMangas myMangas){
        myMangasRepository.save(myMangas);
    }

    public List<MyMangas> getAllMyMangas(){
        return myMangasRepository.findAll();
    }

    public void deleteById(Long id) {
        myMangasRepository.deleteById(id);
    }
}
