package book_management.service.impl;

import book_management.model.Book;
import book_management.model.OrderBook;
import book_management.repository.IOrderRepository;
import book_management.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService implements IOrderService {
    @Autowired
    IOrderRepository orderRepository;

    @Override
    public OrderBook createOrder(Book book) {
        String code = String.valueOf((int) (Math.random() * 100000));
        OrderBook orderBook = new OrderBook();
        orderBook.setBorrowDate(LocalDate.now());
        orderBook.setReturnDate(LocalDate.now().plusDays(5));
        orderBook.setBook(book);
        orderBook.setOtpCode(code);
        orderRepository.save(orderBook);
        return orderBook;
    }

    @Override
    public void deleteOrderBookById(Integer id) {
        orderRepository.deleteOrderBookById(id);
    }


    @Override
    public OrderBook findOrderReturn(Integer id, String code) {
        return orderRepository.findOrderReturn(id,code);
    }


}
