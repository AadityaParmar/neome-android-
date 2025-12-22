// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldDecimal extends DefnFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public Double defaultValue;

  @Nullable
  public Double defaultVar;

  @Nullable
  public Double max;

  @Nullable
  public MetaIdField maxFieldId;

  @Nullable
  public Double maxVar;

  @Nullable
  public Double min;

  @Nullable
  public Double minDisplayValue;

  @Nullable
  public MetaIdField minFieldId;

  @Nullable
  public Double minVar;

  @Nullable
  public String numberFormat;

  @Nullable
  public Long numberOfDigitsAfterPeriod;

  @Nullable
  public MetaIdField numberOfDigitsAfterPeriodFieldId;

  @Nullable
  public Long numberOfDigitsAfterPeriodVar;
}
