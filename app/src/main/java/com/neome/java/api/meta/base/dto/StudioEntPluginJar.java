// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdForm;

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
