package book_management.controller;

import book_management.model.Book;
import book_management.model.OrderBook;
import book_management.service.IBookService;
import book_management.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;

    @Autowired
    IOrderService orderService;
    public final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd - MM - yyyy");

    @GetMapping("")
    public ModelAndView showListBook() {
        ModelAndView modelAndView = new ModelAndView("book/list");
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
    public ModelAndView borrow (@PathVariable Integer id) throws Exception {
        Book book = bookService.findById(id);
        if(bookService.save(book)==null){
            throw new Exception();
        }else {
            OrderBook orderBook = orderService.createOrder(book);
            ModelAndView modelAndView = new ModelAndView("book/view");
            modelAndView.addObject("otpCode","Your otp code is "+orderBook.getOtpCode());
            modelAndView.addObject("book",book);
            modelAndView.addObject("message","You have borrowed "+book.getName()+", on "+dateTimeFormatter.format(orderBook.getBorrowDate())+"." +
                    " Your book should be returned before "+dateTimeFormatter.format(orderBook.getReturnDate()));
            return modelAndView;
        }


    }
    @GetMapping("/{id}/return")
    public ModelAndView showOtpForm(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("book/otpForm");
        Book book = bookService.findById(id);
        modelAndView.addObject("book",book);
        return modelAndView;
    }
    @GetMapping("/returnCheck")
    public ModelAndView returnBook(@RequestParam Integer id, String code){
        ModelAndView modelAndView = new ModelAndView("book/list");
        Book book = bookService.findBookReturn(id, code);
        OrderBook orderBook = orderService.findOrderReturn(id,code);
        if(book != null){
            book.setQuantity(book.getQuantity()+1);
            bookService.save(book);
            orderService.deleteOrderBookById(orderBook.getId());
            List<Book> books = bookService.findAll();
            modelAndView.addObject("books", books);
            modelAndView.addObject("success","You have returned a book named: "+book.getName());
        }else {
            List<Book> books = bookService.findAll();
            modelAndView.addObject("books", books);
            modelAndView.addObject("success","Wrong OTP!");
        }
        return modelAndView;
    }
    @ExceptionHandler(Exception.class)
    public String handleError() {
        return "book/error";
    }


}
