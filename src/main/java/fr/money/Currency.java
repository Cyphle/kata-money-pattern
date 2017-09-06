package fr.money;

import java.math.BigDecimal;
import java.math.MathContext;

public enum Currency {
  EURO(new BigDecimal(1, MathContext.DECIMAL64)),
  US_DOLLAR(new BigDecimal(0.84, MathContext.DECIMAL64)),
  HKS(new BigDecimal(0.11, MathContext.DECIMAL64)),
  Y(new BigDecimal(0.0076, MathContext.DECIMAL64)),
  AD(new BigDecimal(0.00072, MathContext.DECIMAL64)),
  W(new BigDecimal(0.00075, MathContext.DECIMAL64)),
  F(new BigDecimal(0.0033, MathContext.DECIMAL64)),
  P(new BigDecimal(0.0109, MathContext.DECIMAL64)),
  CZK(new BigDecimal(0.03831, MathContext.DECIMAL64));

  public final BigDecimal conversionRate;

  Currency(BigDecimal conversionRate) {
    this.conversionRate = conversionRate;
  }
}
