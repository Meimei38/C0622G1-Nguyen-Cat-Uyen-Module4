package book_management.controller;

import book_management.model.Book;
import book_management.model.OrderBook;
import book_management.service.IBookService;
import book_management.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;

    @Autowired
    IOrderService orderService;

    @GetMapping("")
    public ModelAndView showListBook() {
        ModelAndView modelAndView = new ModelAndView("book/index");
        List<Book> books = bookService.findAll();
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public ModelAndView showDetail(@PathVariable Integer id){
        Book book = bookService.findById(id);
        ModelAndView modelAndView = new ModelAndView("book/view");
        modelAndView.addObject("book",book);
        return modelAndView;
    }

    @GetMapping("/{id}/borrow")
    public ModelAndView borrow (@PathVariable Integer id){
        Book book = bookService.findById(id);
        book.setQuantity(book.getQuantity()-1);
        bookService.save(book);
        OrderBook orderBook = orderService.createOrder(book);
        ModelAndView modelAndView = new ModelAndView("book/view");
        modelAndView.addObject("otpCode",orderBook.getOtpCode());
        modelAndView.addObject("book",book);
        modelAndView.addObject("message","Mượn sách thành công hỉ");
        return modelAndView;
    }



}
