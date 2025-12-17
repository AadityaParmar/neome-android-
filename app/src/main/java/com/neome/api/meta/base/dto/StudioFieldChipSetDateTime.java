// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class StudioFieldChipSetDateTime extends StudioFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public Date[] defaultValue;

  @Nullable
  public String displayDateFormat;
}
