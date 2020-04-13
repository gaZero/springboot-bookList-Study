package com.springbootbookliststudy.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class ReadingListController {

    private static final String reader = "craig";

    private final ReadingListRepository readingListRepository;

    @GetMapping
    public String readerBooks(Model model){
        List<Book> readingList = readingListRepository.findByReader(reader);
        if(readingList != null){
            model.addAttribute("books",readingList);
        }
        return "readingList";
    }

    @PostMapping
    public String addRoReadingList(Book book){
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/";
    }
}
