package book_management.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class BookAspect {
    private  static long count;
    @AfterThrowing("execution(* book_management.controller.BookController.borrow(..))")
    public void checkOrder(){
        System.out.println("----------");
        System.out.println("No book left!");
    }
    @After("execution(* book_management.controller.BookController.borrow(..))")
    public  void logOrderDone(){
        System.out.println("----------");
        System.out.println("Book borrowed successfully!");
    }
    @After("execution(* book_management.controller.BookController.*(..))")
  public void  logAfterAllMethods(JoinPoint joinPoint){
        count++;
        String nameMethod = joinPoint.getSignature().getName();
        System.out.println("Method accessed " + nameMethod + " at: " + LocalDateTime.now());
        System.out.println("Access number"+count);
    }

}
