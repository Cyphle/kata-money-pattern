package fr.money;

import org.junit.Test;

import java.math.BigDecimal;

import static fr.money.Currency.*;
import static fr.money.Money.money;
import static org.assertj.core.api.Assertions.assertThat;

public class WalletTest {
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

  @Test
  public void should_calculate_total_of_money_in_wallet() throws Exception {
    Wallet wallet = new Wallet();
    wallet.add(money.of(50).in(AD).build());
    wallet.add(money.of(1000).in(W).build());
    wallet.add(money.of(10000).in(F).build());
    wallet.add(money.of(170).in(W).build());
    wallet.add(money.of(10).in(F).build());
    wallet.add(money.of(25).in(P).build());
    wallet.add(money.of(10).in(HKS).build());
    wallet.add(money.of(2).in(CZK).build());
    wallet.add(money.of(11).in(US_DOLLAR).build());
    wallet.add(money.of(11).in(Y).build());
    wallet.add(money.of(0.5).in(EURO).build());

    assertThat(wallet.getMoneyAmount()).isEqualTo(money.of(45.19).in(EURO).build());
  }
}
