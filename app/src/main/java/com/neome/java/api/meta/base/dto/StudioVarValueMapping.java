// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdPlugin;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioVarValueMapping extends StudioDtoMapping
{
  @Nullable
  public MetaIdForm fromFormId;

  @Nullable
  public MetaIdPlugin fromPluginId;

  @Nullable
  public MetaIdForm toFormId;

  @Nullable
  public MetaIdPlugin toPluginId;
}
