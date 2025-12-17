// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdPlugin;
import com.neome.api.meta.base.Types.PluginApiId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoPluginApi extends StudioBase
{
  @Nullable
  public MetaIdPlugin metaIdPlugin;

  @Nullable
  public PluginApiId pluginApiId;
}
