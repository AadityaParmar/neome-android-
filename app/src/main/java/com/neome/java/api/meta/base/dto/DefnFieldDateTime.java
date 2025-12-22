// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.TimeZoneKey;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldDateTime extends DefnFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public DefnBuildDateTime defaultValue;

  @Nullable
  public DefnBuildDateTime defaultVar;

  @Nullable
  public String displayDateFormat;

  @Nullable
  public DefnBuildDateTime max;

  @Nullable
  public MetaIdField maxFieldId;

  @Nullable
  public DefnBuildDateTime maxVar;

  @Nullable
  public DefnBuildDateTime min;

  @Nullable
  public MetaIdField minFieldId;

  @Nullable
  public DefnBuildDateTime minVar;

  @Nullable
  public TimeZoneKey timeZone;
}
