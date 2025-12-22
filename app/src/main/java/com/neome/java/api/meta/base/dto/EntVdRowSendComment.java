// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

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
