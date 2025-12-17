// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class StudioFieldChipSetDate extends StudioFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public Date[] defaultValue;

  @Nullable
  public MetaIdVar defaultVarId;

  @Nullable
  public String displayDateFormat;
}
