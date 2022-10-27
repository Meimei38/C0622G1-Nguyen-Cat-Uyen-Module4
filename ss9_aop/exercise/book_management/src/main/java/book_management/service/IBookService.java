package book_management.service;

import book_management.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(Integer id);

    void save(Book book);

    Book findBookReturn(Integer id, String code);
}
