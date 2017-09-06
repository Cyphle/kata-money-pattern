package fr.money;

import java.math.BigDecimal;
import java.math.MathContext;

public class Money {
  public static final MoneyBuilder money = new MoneyBuilder();
  private BigDecimal amount;

  public Money(BigDecimal amount) {
    this.amount = amount;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public Money add(Money amountToAdd) {
    return money.of(amount.add(amountToAdd.amount)).build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Money money = (Money) o;

    return amount != null ? amount.equals(money.amount) : money.amount == null;
  }

  @Override
  public int hashCode() {
    return amount != null ? amount.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Money{" +
            "amount=" + amount +
            '}';
  }

  public static class MoneyBuilder {
    private BigDecimal amount;

    public MoneyBuilder of(BigDecimal amount) {
      this.amount = amount;
      return this;
    }

    public MoneyBuilder of(double amount) {
      this.amount = new BigDecimal(amount, MathContext.DECIMAL64);
      return this;
    }

    public Money build() {
      return new Money(amount);
    }
  }
}
