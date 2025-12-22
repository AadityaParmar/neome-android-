// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Types.CurrencyKey;
import com.neome.java.api.meta.base.Types.EnumDefnPaymentMethodKind;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoPaymentProviderRazorpay extends DtoPaymentProvider
{
  @Nullable
  public EnumDefnPaymentMethodKind[] allowedPaymentMethodSet;

  public String apiKey;

  public CurrencyKey defaultCurrency;
}
