package fr.money;

import java.math.BigDecimal;
import java.math.MathContext;

import static fr.money.Currency.EURO;

public class Money {
  public static final MoneyBuilder money = new MoneyBuilder();
  private BigDecimal amount;
  private Currency currency;

  public Money(BigDecimal amount, Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public BigDecimal getAmountIn(Currency wantedCurrency) {
    return null;
  }

  public Money add(Money amountToAdd) {
    return money.of(amount.add(amountToAdd.amount)).build();
  }

  public Money toEuros() {
    return money.of(amount).in(EURO).build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Money money = (Money) o;

    if (amount != null ? !amount.equals(money.amount) : money.amount != null) return false;
    return currency == money.currency;
  }

  @Override
  public int hashCode() {
    int result = amount != null ? amount.hashCode() : 0;
    result = 31 * result + (currency != null ? currency.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Money{" +
            "amount=" + amount +
            ", currency=" + currency +
            '}';
  }

  public static class MoneyBuilder {
    private BigDecimal amount;
    private Currency currency = EURO;

    public MoneyBuilder of(BigDecimal amount) {
      this.amount = amount;
      return this;
    }

    public MoneyBuilder of(double amount) {
      this.amount = new BigDecimal(amount, MathContext.DECIMAL64);
      return this;
    }

    public MoneyBuilder in(Currency currency) {
      this.currency = currency;
      return this;
    }

    public Money build() {
      return new Money(amount, currency);
    }
  }
}
