package fr.money;

import java.math.BigDecimal;
import java.math.MathContext;

import static fr.money.Money.money;

public class Wallet {
  private BigDecimal amount;
  private Money moneyAmount;

  public Wallet() {
    amount = new BigDecimal(0, MathContext.DECIMAL64);
    moneyAmount = money.of(0).build();
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public Money getMoneyAmount() {
    return moneyAmount;
  }

  public void add(BigDecimal amountToAdd) {
    amount = amount.add(amountToAdd);
  }

  public void add(Money amountToAdd) {
    moneyAmount = moneyAmount.add(amountToAdd);
  }
}
