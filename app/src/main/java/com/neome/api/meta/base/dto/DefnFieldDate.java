// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.TimeZoneKey;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldDate extends DefnFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public DefnBuildDate defaultValue;

  @Nullable
  public DefnBuildDate defaultVar;

  @Nullable
  public String displayDateFormat;

  @Nullable
  public DefnBuildDate max;

  @Nullable
  public MetaIdField maxFieldId;

  @Nullable
  public DefnBuildDate maxVar;

  @Nullable
  public DefnBuildDate min;

  @Nullable
  public MetaIdField minFieldId;

  @Nullable
  public DefnBuildDate minVar;

  @Nullable
  public TimeZoneKey timeZone;
}
