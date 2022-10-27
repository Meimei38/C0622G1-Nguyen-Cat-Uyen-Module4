package book_management.service;

import book_management.model.Book;
import book_management.model.OrderBook;

public interface IOrderService {
    OrderBook createOrder(Book book);
    void deleteOrderBookById(Integer id);

    OrderBook findOrderReturn(Integer id, String code);


}
