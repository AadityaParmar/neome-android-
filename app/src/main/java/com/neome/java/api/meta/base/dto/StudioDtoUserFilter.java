// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoUserFilter extends StudioBase
{
  @Nullable
  public MetaIdPipelineParam userPipelineParamId;

  @Nullable
  public MetaIdVar userVarId;

  @Nullable
  public StudioBuildArgBinder users;
}
