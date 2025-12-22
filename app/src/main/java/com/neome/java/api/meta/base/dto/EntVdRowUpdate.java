// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnKindPipelineUpdate;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdRowUpdate extends EntVdAutoStepWithOutputAndError
{
  @Nullable
  public EnumDefnKindPipelineUpdate option;

  @Nullable
  public StudioDtoMapping outputMapping;

  @Nullable
  public MetaIdVar outputMappingVarId;

  @Nullable
  public Boolean overwriteRow;

  @Nullable
  public StudioDtoRowIdPointer rowIdPointer;
}
