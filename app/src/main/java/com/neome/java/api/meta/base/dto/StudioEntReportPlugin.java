// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntReportPlugin extends StudioEntReport
{
  @Nullable
  public MetaIdVar inputFormMappingVarId;

  @Nullable
  public MetaIdVar outputFormMappingVarId;

  @Nullable
  public StudioDtoPluginApi pluginApi;
}
