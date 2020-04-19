package readinglist;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
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

    private final ReadingListRepository readingListRepository;
    private final AmazonProperties amazonProperties;

    @GetMapping
    public String readerBooks(Reader reader, Model model){
        List<Book> readingList = readingListRepository.findByReader(reader);
        if(readingList != null){
            model.addAttribute("books",readingList);
            model.addAttribute("reader", reader);
            model.addAttribute("amazonID",amazonProperties.getAssociateId());
        }
        return "readingList";
    }


    @PostMapping
    public String addRoReadingList(Reader reader, Book book){
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/";
    }
}
