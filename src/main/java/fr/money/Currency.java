package fr.money;

import java.math.BigDecimal;
import java.math.MathContext;

public enum Currency {
  EURO(new BigDecimal(1, MathContext.DECIMAL64)),
  US_DOLLAR(new BigDecimal(0.84, MathContext.DECIMAL64));

  public final BigDecimal conversionRate;

  Currency(BigDecimal conversionRate) {
    this.conversionRate = conversionRate;
  }
}
