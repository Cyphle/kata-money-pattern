package fr.money;

import org.junit.Test;

import static fr.money.Currency.*;
import static fr.money.Money.money;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
  @Test
  public void should_get_amount_in_euros_when_having_money_in_euros() throws Exception {
    Money currentMoney = money.of(10).in(EURO).build();

    assertThat(currentMoney.getAmountIn(EURO)).isEqualTo(money.of(10).in(EURO).build());
  }

  @Test
  public void should_get_money_in_us_dollars_when_having_money_in_euros() throws Exception {
    Money currentMoney = money.of(10).in(EURO).build();

    assertThat(currentMoney.getAmountIn(US_DOLLAR)).isEqualTo(money.of(11.90).in(US_DOLLAR).build());
  }

  @Test
  public void should_get_money_in_us_dollar_when_having_money_in_hkd() throws Exception {
    Money currentMoney = money.of(100).in(HKS).build();

    assertThat(currentMoney.getAmountIn(US_DOLLAR)).isEqualTo(money.of(13.09).in(US_DOLLAR).build());
  }

  @Test
  public void should_add_dollars_to_hkd() throws Exception {
    Money currentMoney = money.of(10000).in(Y).build();
    Money addedMoney = currentMoney.add(money.of(100).in(HKS).build());

    assertThat(addedMoney.getAmountIn(Y)).isEqualTo(money.of(11447.36).in(Y).build());
    assertThat(addedMoney.getAmountIn(US_DOLLAR)).isEqualTo(money.of(103.57).in(US_DOLLAR).build());
  }
}
