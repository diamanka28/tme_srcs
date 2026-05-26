package test.java.library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.library.Book;
import main.java.library.BookStatus;

public class BookTest {

	@Test
	public void testBorrow() {
		Book b = new Book("java", "Martin");
		
		b.borrow();
		assertEquals(BookStatus.BORROWED, b.getStatus());
	}
}
