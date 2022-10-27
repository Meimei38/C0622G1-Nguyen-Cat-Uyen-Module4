package book_management.service.impl;

import book_management.model.Book;
import book_management.repository.IBookRepository;
import book_management.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book save(Book book) {
        Integer bookCount = book.getQuantity();
        if(bookCount >0){
            book.setQuantity(bookCount-1);
            bookRepository.save(book);
            return book;
        }else {
            return null;
        }

    }

    @Override
    public Book findBookReturn(Integer id, String code) {
        return bookRepository.findBookReturn(id,code);
    }
}
