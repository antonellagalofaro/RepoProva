package api.share.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.share.training.model.Book;
import api.share.training.model.dto.ResponseMessage;
import api.share.training.service.BookService;
import net.minidev.json.JSONObject;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    /***************************************************************************************************************************/
    /*
     * Prendiamo il caso di GET Mapping che voglia restituire tutti i libri.
     * Si può arrivare allo stesso risultato in tre modi:
     * 	1. Usando le classi di Java e facendo interrogazione al repository -> output: classe Java (che viene tradotta in JSON)
     * 	2a. Usando i JSON e le native query -> output: classe JSON
     * 	2b. Usando i JSON e le native query -> output: classe ResponseEntity -> si può manipolare il pacchetto HTTP
     * */
    
    //Metodo 1
    @GetMapping
    public Iterable<Book> findAll() {
        return this.bookService.findAll();
    }
    
    //Metodo 2a
    @GetMapping
    public List<JSONObject> findAllBooks() {
        return this.bookService.findAllBooks();
    }
    
    //Metodo 2b
	@GetMapping
    public ResponseEntity<List<JSONObject>> findAllBooksEntity() {
        return new ResponseEntity<List<JSONObject>>(this.bookService.findAllBooks(),HttpStatus.OK);
    }

    /***************************************************************************************************************************/
    
    @GetMapping("/{id}")
    public ResponseEntity<JSONObject> findOne(@PathVariable String id) {
    	return new ResponseEntity<JSONObject>(this.bookService.findBook(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> insertBook(@RequestBody Book book) {
    	
    	//Creo un book sul db e ritorno id (primary_key)
    	String id = this.bookService.insertBook(book);
    	
    	//Creo un message di risposta per ouput
    	ResponseMessage res = new ResponseMessage("Book added",id);
    	
    	//return
		return new ResponseEntity<ResponseMessage>(res,HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> updateBook(@RequestBody Book book, @PathVariable String id) {
    	
    	this.bookService.updateBook(id, book);
    	
    	ResponseMessage res = new ResponseMessage("Book updated",id);
    	
		return new ResponseEntity<ResponseMessage>(res,HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteBook(@PathVariable String id) {
    	
    	this.bookService.deleteBook(id);
    	
    	ResponseMessage res = new ResponseMessage("Book updated",id);
    	
		return new ResponseEntity<ResponseMessage>(res,HttpStatus.OK);
    }

    
}
