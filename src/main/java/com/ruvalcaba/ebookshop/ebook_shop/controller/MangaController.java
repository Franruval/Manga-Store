package com.ruvalcaba.ebookshop.ebook_shop.controller;


import com.ruvalcaba.ebookshop.ebook_shop.entity.Manga;
import com.ruvalcaba.ebookshop.ebook_shop.entity.MyMangas;
import com.ruvalcaba.ebookshop.ebook_shop.service.MangaService;
import com.ruvalcaba.ebookshop.ebook_shop.service.MyMangasService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MangaController {

    private MangaService mangaService;
    private MyMangasService myMangasService;

    public MangaController(MangaService mangaService, MyMangasService myMangasService){
        this.mangaService = mangaService;
        this.myMangasService = myMangasService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/register-manga")
    public String registerManga(){
        return "registerManga";
    }

    @GetMapping("/all-mangas")
    public ModelAndView getAllMangas(){
        List<Manga> list = mangaService.getAllMangas();
        //Manually set ModelAndView Object atributes instead of using constructor
        /*ModelAndView mv = new ModelAndView();
        mv.setViewName("listOfMangas");
        mv.addObject("manga",list);*/
        return new ModelAndView("listOfMangas", "manga", list);
    }

    @PostMapping("/save-manga")
    public String addManga(@ModelAttribute Manga m){
        mangaService.save(m);
        return "redirect:/all-mangas";
    }

    @RequestMapping("/all-mangas/delete/{id}")
    public String deleteManga(@PathVariable("id") Long id){
        return "home";
    }

    @RequestMapping("/all-mangas/edit/{id}")
    public String updateManga(@PathVariable("id") Long id){
        return "home";
    }

}
