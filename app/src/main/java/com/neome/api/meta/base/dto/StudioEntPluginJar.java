// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdForm;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntPluginJar extends StudioBase
{
  @Nullable
  public String packageNameVar;

  @Nullable
  public MetaIdForm pluginConfigFormId;

  @Nullable
  public StudioMapOfJarFile uploadJarMap;
}
