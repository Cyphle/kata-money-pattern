package fr.money;

import java.math.BigDecimal;

import static fr.money.Currency.EURO;
import static fr.money.Money.money;

public class Wallet {
  private Money moneyAmount;

  public Wallet() {
    moneyAmount = money.of(0).in(EURO).build();
  }

  public BigDecimal getAmount() {
    return moneyAmount.getAmount();
  }

  public Money getMoneyAmount() {
    return moneyAmount;
  }

  public void add(Money amountToAdd) {
    moneyAmount = moneyAmount.add(amountToAdd);
  }
}
