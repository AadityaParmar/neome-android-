// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.PluginApiId;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioPluginApiMap extends StudioBase
{
  public PluginApiId[] keys;

  public Map<PluginApiId, StudioPluginApi> map;

  @Nullable
  public MetaIdForm pluginConfigFormId;
}
