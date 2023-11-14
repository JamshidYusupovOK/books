package uz.tutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.tutorial.model.BookModel;

@Repository
public interface BookRepository
         extends JpaRepository<BookModel, Integer> {
}
