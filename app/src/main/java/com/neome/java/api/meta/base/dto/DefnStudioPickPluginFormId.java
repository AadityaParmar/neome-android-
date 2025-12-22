// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdPlugin;
import com.neome.java.api.meta.base.Types.PluginApiId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioPickPluginFormId extends DefnStudioPickFormId
{
  @Nullable
  public PluginApiId pluginApiId;

  @Nullable
  public MetaIdPlugin pluginId;
}
