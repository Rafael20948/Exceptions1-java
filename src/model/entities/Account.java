package model.entities;

import model.exceptions.Exce;
import model.exceptions.Excecao;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithDrawLimit() {
		return withDrawLimit;
	}

	public void setWithDrawLimit(Double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}	
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withDraw(Double amount) {
		balance -= amount;
	}
	
	public void exception(Double balance, Double withDrawLimit, Double withDraw) throws Excecao {
		if (withDraw > withDrawLimit || withDraw > balance) {
			throw new Excecao("The amount exceeds withdraw limit");
		}
	}
	
	public void exce(Double balance, Double withDraw,  Double withDrawLimit) throws Exce {
		if (balance < withDraw && balance < withDrawLimit) {
			throw new Exce("Not ebough balance");
		}
	}
	
	@Override
	public String toString() {
		return String.format("%.2f", balance);
	}

}
