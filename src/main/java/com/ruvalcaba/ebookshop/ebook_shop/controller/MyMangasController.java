package com.ruvalcaba.ebookshop.ebook_shop.controller;

import com.ruvalcaba.ebookshop.ebook_shop.entity.Manga;
import com.ruvalcaba.ebookshop.ebook_shop.entity.MyMangas;
import com.ruvalcaba.ebookshop.ebook_shop.service.MangaService;
import com.ruvalcaba.ebookshop.ebook_shop.service.MyMangasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyMangasController {

    private MangaService mangaService;
    private MyMangasService myMangasService;

    //Dependency injection
    public MyMangasController(MangaService mangaService, MyMangasService myMangasService){
        this.mangaService = mangaService;
        this.myMangasService = myMangasService;
    }

    @GetMapping("/my-mangas")
    public String getMyMangas(Model model){
        List<MyMangas> list = myMangasService.getAllMyMangas();
        model.addAttribute("manga", list);

        return "myMangas";
    }

    @RequestMapping("/my-mangas/add/{id}")
    public String addToMyMangas(@PathVariable("id") Long id){
        Manga manga=mangaService.getMangaById(id);
        MyMangas myMangas = new MyMangas(manga.getId(),manga.getTitle(),manga.getPublisher(),manga.getVolume(),manga.getPrice());
        myMangasService.saveMyMangas(myMangas);
        return "redirect:/my-mangas";
    }

    @RequestMapping("/my-mangas/delete/{id}")
    public String deleteFromMyMangas(@PathVariable("id") Long id){
        myMangasService.deleteById(id);
        return "redirect:/my-mangas";
    }
}
