// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnPaymentMethodKind;
import com.neome.java.api.meta.base.Types.EnumPaymentProviderKind;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdGeneratePaymentLink extends EntVdAutoStepWithError
{
  @Nullable
  public EnumDefnPaymentMethodKind[] allowedPaymentMethodSet;

  @Nullable
  public StudioBuildArgBinder amount;

  @Nullable
  public StudioBuildArgBinder currency;

  @Nullable
  public StudioBuildArgBinder expiryDuration;

  @Nullable
  public StudioDtoArgValueParameter outputField;

  @Nullable
  public StudioBuildArgBinder paymentDescription;

  @Nullable
  public EnumPaymentProviderKind paymentProvider;

  @Nullable
  public StudioDtoArgValueParameter referenceIdField;

  @Nullable
  public StudioDtoArgValueParameter spreadsheetRowIdField;
}
