// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnPluginApiMethod;
import com.neome.api.meta.base.Types.MetaIdPlugin;
import com.neome.api.meta.base.Types.PluginApiId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioPickImportPluginApiId extends DefnFieldEditable
{
  @Nullable
  public PluginApiId[] excludePluginApiIdSet;

  @Nullable
  public EnumDefnPluginApiMethod[] filterApiMethodSet;

  public MetaIdPlugin metaIdPlugin;
}
