// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.EntVdAutoStepWithError;
import com.neome.api.meta.base.dto.StudioDtoRowIdPointer;

@SuppressWarnings("unused")
public class EntVdRowRemove extends EntVdAutoStepWithError
{
  @Nullable
  public StudioDtoRowIdPointer rowIdPointer;
}
