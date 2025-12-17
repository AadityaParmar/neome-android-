// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnKindPipelineUpdate;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdParamCreate extends EntVdAutoStepWithOutput
{
  @Nullable
  public EnumDefnKindPipelineUpdate option;

  @Nullable
  public FormRefKey outputForm;

  @Nullable
  public StudioDtoMapping outputMapping;

  @Nullable
  public MetaIdVar outputMappingVarId;
}
