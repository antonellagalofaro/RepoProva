package api.share.training.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import api.share.training.model.Book;
import jakarta.transaction.Transactional;
import net.minidev.json.JSONObject;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
    
    @Query(value = "SELECT * from as_book", nativeQuery = true)
	public List<JSONObject> getAllBooks();
    
    @Query(value = "SELECT * from as_book where id=:id", nativeQuery = true)
	public JSONObject getBook(@Param("id") String id);
    
    @Transactional
	@Modifying
	@Query(value = "INSERT INTO as_book(id, title, author) VALUES (:id, :title, :author)", nativeQuery = true)
	void insertBook(@Param("id") String id, @Param("title") String title, @Param("author") String author);
	
    
    @Transactional
	@Modifying
	@Query(value="UPDATE as_book set title=:title, author=:author where id=:id", nativeQuery = true)
	public void updateBook(@Param("id") String id, @Param("title") String title, @Param("author") String author);
    
    @Transactional
	@Modifying
	@Query(value="DELETE FROM as_book WHERE id=:id", nativeQuery = true)
	public void deleteBook(@Param("id") String id);
}
