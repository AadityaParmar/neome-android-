// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnDurationUnit;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldDuration extends DefnFieldEditable
{
  @Nullable
  public Boolean autoFormatValue;

  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public FieldDtoDuration defaultValue;

  @Nullable
  public FieldDtoDuration defaultVar;

  @Nullable
  public EnumDefnDurationUnit[] excludeDurationUnits;

  @Nullable
  public String[] filterOptionSet;

  @Nullable
  public FieldDtoDuration max;

  @Nullable
  public MetaIdField maxFieldId;

  @Nullable
  public FieldDtoDuration maxVar;

  @Nullable
  public FieldDtoDuration min;

  @Nullable
  public MetaIdField minFieldId;

  @Nullable
  public FieldDtoDuration minVar;
}
