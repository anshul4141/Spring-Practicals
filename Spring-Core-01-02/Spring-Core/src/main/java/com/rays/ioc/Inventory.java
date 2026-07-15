package com.rays.ioc;

public class Inventory {

	private int book;

	public int getBook() {
		return book;
	}

	public void setBook(int book) {
		this.book = book;
	}

	public int sold(int item) {

		if (item > book) {
			System.out.println("book is out of stock");
		} else {
			book = book - item;
			return book;
		}
		return book;
	}

}
