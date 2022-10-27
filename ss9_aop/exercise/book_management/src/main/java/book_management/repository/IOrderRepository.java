package book_management.repository;

import book_management.model.Book;
import book_management.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

@Repository
 @Transactional
public interface IOrderRepository extends JpaRepository<OrderBook,Integer> {

    void deleteOrderBookById(Integer id);
    @Query(value = "select * from order_book join book on order_book.book_id = book.id where book.id= :id and order_book.otp_code= :code", nativeQuery = true)
    OrderBook findOrderReturn(@Param("id")Integer id, @Param("code") String code);
}
