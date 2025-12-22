// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnDurationUnit;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldDuration extends StudioFieldEditable
{
  @Nullable
  public Boolean autoFormatValue;

  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public FieldDtoDuration defaultValue;

  @Nullable
  public MetaIdVar defaultVarId;

  @Nullable
  public EnumDefnDurationUnit[] excludeDurationUnits;

  @Nullable
  public FieldDtoDuration max;

  @Nullable
  public MetaIdField maxFieldId;

  @Nullable
  public MetaIdVar maxVarId;

  @Nullable
  public FieldDtoDuration min;

  @Nullable
  public MetaIdField minFieldId;

  @Nullable
  public MetaIdVar minVarId;
}
