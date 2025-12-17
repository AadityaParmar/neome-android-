// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.google.gson.JsonElement;
import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumDefnPluginResources;
import com.neome.api.meta.base.Types.MetaIdComp;
import com.neome.api.meta.base.Types.MetaIdPlugin;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntDeployPlugin extends StudioBase
{
  public MetaIdPlugin metaId;

  public Symbol name;

  @Nullable
  public Map<MetaIdComp, JsonElement> pluginConfigFormValueMap;

  @Nullable
  public EnumDefnPluginResources pluginType;
}
