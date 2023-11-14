package uz.tutorial.controller;

import org.springframework.web.bind.annotation.*;
import uz.tutorial.model.BookModel;
import uz.tutorial.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<BookModel> get(){
        return bookRepository.findAll();
    }

    @PostMapping
    public List<BookModel> post(@RequestBody BookModel model){
        bookRepository.saveAll(List.of(model));
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public BookModel getById(@PathVariable Integer id){
        return bookRepository.findAll().stream().filter(book->id.equals(book.getId())).findAny().orElseThrow();
    }

    @DeleteMapping("/{id}")
    public String DeletePost(@PathVariable Integer id){
        bookRepository.deleteById(id);
        return "The book is deleted from the list";
    }

    @PutMapping("/{id}")
    public List<BookModel> updateBook(@PathVariable Integer id, @RequestBody BookModel model){
        BookModel currentModel= bookRepository.findAll().stream().filter(book-> id.equals(book.getId())).findAny().orElseThrow();
        currentModel.setName(model.getName());
        currentModel.setAuthor(model.getAuthor());
        currentModel.setPrice(model.getPrice());
        System.out.println(model);
        bookRepository.save(currentModel);
        return bookRepository.findAll();
    }
}
