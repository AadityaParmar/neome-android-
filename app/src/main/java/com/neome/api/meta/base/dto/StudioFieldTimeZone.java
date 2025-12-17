// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;
import com.neome.api.meta.base.Types.TimeZoneKey;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldTimeZone extends StudioFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public TimeZoneKey defaultValue;

  @Nullable
  public MetaIdVar defaultVarId;
}
