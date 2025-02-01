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

    @GetMapping("/my-mangas")
    public String getMyMangas(Model model){
        List<MyMangas> list = myMangasService.getAllMyMangas();
        model.addAttribute("manga", list);

        return "myMangas";
    }

    @PostMapping("/save-manga")
    public String addManga(@ModelAttribute Manga m){
        mangaService.save(m);
        return "redirect:/all-mangas";
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
