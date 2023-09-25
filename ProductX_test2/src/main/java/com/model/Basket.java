package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Basket {

	@SequenceGenerator(name = "basket_seq", initialValue = 101, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "basket_seq")
	private int basketId;

	@OneToOne
	@JoinColumn(name = "username")
	private User user;

	public Basket() {
		super();

	}

	public Basket(int basketId) {
		super();
		this.basketId = basketId;
	}

	public int getBasketId() {
		return basketId;
	}

	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}

}
