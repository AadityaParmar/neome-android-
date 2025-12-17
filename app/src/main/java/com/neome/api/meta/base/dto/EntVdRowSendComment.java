// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.EntVdAutoStepWithError;
import com.neome.api.meta.base.dto.StudioBuildArgBinder;
import com.neome.api.meta.base.dto.StudioDtoRowIdPointer;
import com.neome.api.meta.base.dto.StudioValueParagraph;

@SuppressWarnings("unused")
public class EntVdRowSendComment extends EntVdAutoStepWithError
{
  @Nullable
  public StudioValueParagraph message;

  @Nullable
  public StudioDtoRowIdPointer rowIdPointer;

  @Nullable
  public StudioBuildArgBinder sender;
}
