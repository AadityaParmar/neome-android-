// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.CurrencyKey;
import com.neome.java.api.meta.base.Types.EnumDefnPaymentMethodKind;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntPaymentProviderRazorPay extends StudioEntPaymentProvider
{
  @Nullable
  public EnumDefnPaymentMethodKind[] allowedPaymentMethodSet;

  @Nullable
  public String apiKey;

  @Nullable
  public String apiSecret;

  @Nullable
  public CurrencyKey defaultCurrency;

  @Nullable
  public String webhookSecret;
}
