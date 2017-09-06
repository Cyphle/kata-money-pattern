package fr.money;

import java.util.ArrayList;
import java.util.List;

import static fr.money.Currency.EURO;
import static fr.money.Money.money;

class Wallet {
  private final List<Money> moneys;

  Wallet() {
    moneys = new ArrayList<>();
  }

  Money getMoneyAmount() {
    return moneys.stream()
            .reduce(money.of(0).in(EURO).build(), Money::add);
  }

  void add(Money amountToAdd) {
    moneys.add(amountToAdd);
  }
}
