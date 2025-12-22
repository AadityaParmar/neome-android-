// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldDecimal extends StudioFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public Double defaultValue;

  @Nullable
  public MetaIdVar defaultVarId;

  @Nullable
  public Double max;

  @Nullable
  public MetaIdField maxFieldId;

  @Nullable
  public MetaIdVar maxVarId;

  @Nullable
  public Double min;

  @Nullable
  public Double minDisplayValue;

  @Nullable
  public MetaIdField minFieldId;

  @Nullable
  public MetaIdVar minVarId;

  @Nullable
  public String numberFormat;

  @Nullable
  public Long numberOfDigitsAfterPeriod;

  @Nullable
  public MetaIdField numberOfDigitsAfterPeriodFieldId;

  @Nullable
  public MetaIdVar numberOfDigitsAfterPeriodVarId;
}
