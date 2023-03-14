package api.share.training.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.share.training.model.Book;
import api.share.training.repository.BookRepository;
import net.minidev.json.JSONObject;

@Service
public class BookService {
	
	@Autowired
    private BookRepository bookRepository;
	
	public Iterable<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public List<JSONObject> findAllBooks(){
		return this.bookRepository.getAllBooks();
	}
	
	public JSONObject findBook(String id){
		return this.bookRepository.getBook(id);
	}
	
	public String insertBook(Book book){
		String id = UUID.randomUUID().toString();
		this.bookRepository.insertBook(id, book.getTitle(), book.getAuthor());
		return id;
	}
	
	public void updateBook(String id, Book book){
		this.bookRepository.updateBook(id, book.getTitle(), book.getAuthor());
	}
	
	public void deleteBook(String id){
		this.bookRepository.deleteBook(id);
	}
}
