package fr.money;

import org.junit.Test;

import java.math.BigDecimal;

import static fr.money.Currency.EURO;
import static fr.money.Money.money;
import static org.assertj.core.api.Assertions.assertThat;

public class WalletTest {
  @Test
  public void should_have_0_when_having_wallet() throws Exception {
    Wallet wallet = new Wallet();
    assertThat(wallet.getAmount()).isEqualTo(new BigDecimal(0));
  }

  @Test
  public void should_have_10_of_money_when_adding_10_in_wallet() throws Exception {
    Wallet wallet = new Wallet();
    wallet.add(money.of(new BigDecimal(10)).build());
    assertThat(wallet.getMoneyAmount()).isEqualTo(money.of(new BigDecimal(10)).build());
  }

  @Test
  public void should_have_10_euros_when_adding_10_euros_in_wallet() throws Exception {
    Wallet wallet = new Wallet();
    wallet.add(money.of(10).in(EURO).build());
    assertThat(wallet.getMoneyAmount()).isEqualTo(money.of(new BigDecimal(10)).in(EURO).build());
  }
}
