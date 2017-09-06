package fr.money;

import org.junit.Test;

import static fr.money.Currency.EURO;
import static fr.money.Currency.US_DOLLAR;
import static fr.money.Money.money;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
  @Test
  public void should_get_amount_in_euros_when_having_money_in_euros() throws Exception {
    Money currentMoney = money.of(10).in(EURO).build();

    assertThat(currentMoney.toEuros()).isEqualTo(money.of(10).in(EURO).build());
  }

  @Test
  public void should_get_money_in_us_dollars_when_having_money_in_euros() throws Exception {
    Money currentMoney = money.of(10).in(EURO).build();

    assertThat(currentMoney.getAmountIn(US_DOLLAR)).isEqualTo(money.of(8.40).in(US_DOLLAR).build());
  }
}
