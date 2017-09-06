package fr.money;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class WalletTest {
  @Test
  public void should_have_0_when_having_wallet() throws Exception {
    Wallet wallet = new Wallet();
    assertThat(wallet.getAmount()).isEqualTo(new BigDecimal(0));
  }
}
