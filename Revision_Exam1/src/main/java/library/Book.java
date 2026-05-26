package main.java.library;

import java.util.Objects;

@Author(name = "Student")
public class Book implements Borrowable {

	private String title, author;
	private BookStatus status;
	
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
		this.status = BookStatus.AVAILABLE;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(title, other.title);
	}

	@Override
	public void giveBack() {
		// TODO Auto-generated method stub
		this.status = BookStatus.AVAILABLE;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the status
	 */
	public BookStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(BookStatus status) {
		this.status = status;
	}

	@Override
	public void borrow() {
		// TODO Auto-generated method stub
		this.status = BookStatus.BORROWED;
	}	
}
