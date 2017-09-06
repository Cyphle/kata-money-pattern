package fr.money;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.BigDecimal.ROUND_FLOOR;

public class Money {
  static final MoneyBuilder money = new MoneyBuilder();
  private final BigDecimal amount;
  private final Currency currency;

  private Money(BigDecimal amount, Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }

  Money getAmountIn(Currency wantedCurrency) {
    return money.of(toEuros().divide(wantedCurrency.conversionRate, MathContext.DECIMAL64).setScale(2, ROUND_FLOOR)).in(wantedCurrency).build();
  }

  Money add(Money amountToAdd) {
    BigDecimal totalEuros = toEuros().add(amountToAdd.toEuros(), MathContext.DECIMAL64);
    BigDecimal totalInBaseCurrency = totalEuros.divide(currency.conversionRate, MathContext.DECIMAL64).setScale(2, ROUND_FLOOR);
    return money.of(totalInBaseCurrency).in(currency).build();
  }

  private BigDecimal toEuros() {
    return amount.multiply(currency.conversionRate);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Money money = (Money) o;

    if (amount != null ? !amount.setScale(2, ROUND_FLOOR).equals(money.amount.setScale(2, ROUND_FLOOR)) : money.amount != null) return false;
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

  static class MoneyBuilder {
    private BigDecimal amount;
    private Currency currency;

    MoneyBuilder of(BigDecimal amount) {
      this.amount = amount;
      return this;
    }

    MoneyBuilder of(double amount) {
      this.amount = new BigDecimal(amount, MathContext.DECIMAL64).setScale(2, ROUND_FLOOR);
      return this;
    }

    MoneyBuilder in(Currency currency) {
      this.currency = currency;
      return this;
    }

    Money build() {
      return new Money(amount, currency);
    }
  }
}
