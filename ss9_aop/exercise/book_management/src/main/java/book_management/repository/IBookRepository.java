package book_management.repository;

import book_management.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Transactional
    @Query(value = "select * from book join order_book on book.id = order_book.book_id where book.id= :id and order_book.otp_code= :code", nativeQuery = true)
    Book findBookReturn(@Param("id")Integer id,@Param("code") String code);
}
