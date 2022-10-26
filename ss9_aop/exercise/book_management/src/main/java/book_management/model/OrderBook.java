package book_management.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class OrderBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String otpCode;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public OrderBook() {
    }

    public OrderBook(Integer id, String otpCode, LocalDate borrowDate, LocalDate returnDate, Book book) {
        this.id = id;
        this.otpCode = otpCode;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
