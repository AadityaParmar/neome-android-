// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdPlugin;
import com.neome.api.meta.base.Types.PluginApiId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdExecutePlugin extends EntVdAutoStepWithOutputAndError
{
  @Nullable
  public PluginApiId pluginApiId;

  @Nullable
  public MetaIdPlugin pluginId;
}
