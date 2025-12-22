// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnKindPipelineUpdate;
import com.neome.java.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdParamUpdate extends EntVdAutoStep
{
  @Nullable
  public EnumDefnKindPipelineUpdate option;

  @Nullable
  public StudioDtoMapping outputMapping;

  @Nullable
  public MetaIdVar outputMappingVarId;

  @Nullable
  public MetaIdPipelineParam pipelineParamId;
}
