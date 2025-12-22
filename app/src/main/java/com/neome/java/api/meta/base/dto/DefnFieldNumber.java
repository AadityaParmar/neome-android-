// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldNumber extends DefnFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public Long defaultValue;

  @Nullable
  public Long defaultVar;

  @Nullable
  public Long max;

  @Nullable
  public MetaIdField maxFieldId;

  @Nullable
  public Long maxVar;

  @Nullable
  public Long min;

  @Nullable
  public Long minDisplayValue;

  @Nullable
  public MetaIdField minFieldId;

  @Nullable
  public Long minVar;

  @Nullable
  public String numberFormat;
}
