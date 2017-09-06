package fr.money;

import java.math.BigDecimal;
import java.math.MathContext;

public class Wallet {
  private BigDecimal amount;

  public Wallet() {
    amount = new BigDecimal(0, MathContext.DECIMAL64);
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void add(BigDecimal amountToAdd) {
    amount = amount.add(amountToAdd);
  }
}
