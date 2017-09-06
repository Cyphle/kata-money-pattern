package fr.money;

import java.util.ArrayList;
import java.util.List;

import static fr.money.Currency.EURO;
import static fr.money.Money.money;

public class Wallet {
  private List<Money> moneys;

  public Wallet() {
    moneys = new ArrayList<>();
  }

  public Money getMoneyAmount() {
    return moneys.stream()
            .reduce(money.of(0).in(EURO).build(), Money::add);
  }

  public void add(Money amountToAdd) {
    moneys.add(amountToAdd);
  }
}
