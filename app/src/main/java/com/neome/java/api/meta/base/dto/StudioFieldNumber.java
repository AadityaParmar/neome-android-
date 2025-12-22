// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldNumber extends StudioFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public Long defaultValue;

  @Nullable
  public MetaIdVar defaultVarId;

  @Nullable
  public Long max;

  @Nullable
  public MetaIdField maxFieldId;

  @Nullable
  public MetaIdVar maxVarId;

  @Nullable
  public Long min;

  @Nullable
  public Long minDisplayValue;

  @Nullable
  public MetaIdField minFieldId;

  @Nullable
  public MetaIdVar minVarId;

  @Nullable
  public String numberFormat;
}
