// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnPaymentMethodKind;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdGrid;
import com.neome.java.api.meta.base.Types.MetaIdPipelineParam;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepGeneratePaymentLink extends StudioEntAutomationStep
{
  @Nullable
  public EnumDefnPaymentMethodKind[] allowedPaymentMethodSet;

  @Nullable
  public StudioBuildArgBinder amountValue;

  @Nullable
  public StudioBuildArgBinder currencyValue;

  @Nullable
  public StudioBuildArgBinder descriptionValue;

  @Nullable
  public StudioBuildArgBinder expiryDurationValue;

  @Nullable
  public MetaIdPipelineParam inputFormPipelineVarId;

  @Nullable
  public StudioValueVarIdCondition iterateOnGridFilterVarId;

  @Nullable
  public MetaIdGrid iterateOnGridId;

  @Nullable
  public MetaIdPipelineParam outputFormPipelineVarId;

  @Nullable
  public MetaIdField paymentLinkFieldId;

  @Nullable
  public MetaIdField referenceIdFieldId;

  @Nullable
  public MetaIdField spreadsheetRowIdFieldId;
}
