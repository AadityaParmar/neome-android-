// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdRowGetHistory extends EntVdAutoStepWithOutput
{
  @Nullable
  public StudioDtoArgValueParameter offset;

  @Nullable
  public Long pageSize;

  @Nullable
  public StudioDtoRowIdPointer rowIdPointer;
}
