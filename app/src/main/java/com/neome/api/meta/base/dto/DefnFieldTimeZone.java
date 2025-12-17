// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.TimeZoneKey;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldTimeZone extends DefnFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public TimeZoneKey defaultValue;

  @Nullable
  public TimeZoneKey defaultVar;
}
