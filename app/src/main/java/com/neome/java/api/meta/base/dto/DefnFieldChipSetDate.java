// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.TimeZoneKey;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class DefnFieldChipSetDate extends DefnFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public Date[] defaultValue;

  @Nullable
  public Date[] defaultVar;

  @Nullable
  public String displayDateFormat;

  @Nullable
  public TimeZoneKey timeZone;
}
