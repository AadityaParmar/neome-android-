// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.CurrencyKey;
import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnPaymentConfig
{
  @Nullable
  public EnumDefnPaymentMethodKind[] allowedPaymentMethodSet;

  @Nullable
  public MetaIdField amountFieldId;

  @Nullable
  public CurrencyKey currency;

  @Nullable
  public MetaIdField currencyFieldId;

  @Nullable
  public MetaIdField customerContactFieldId;

  @Nullable
  public MetaIdField customerEmailFieldId;

  @Nullable
  public MetaIdField customerNameFieldId;

  @Nullable
  public MetaIdField descriptionFieldId;

  @Nullable
  public Boolean enablePayment;

  @Nullable
  public MetaIdField referenceIdFieldId;
}
