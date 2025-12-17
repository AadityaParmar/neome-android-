// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnKindAiProvider;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdAi extends EntVdAutoStepWithError
{
  @Nullable
  public StudioValueParagraph aiInstructions;

  @Nullable
  public EnumDefnKindAiProvider aiProvider;
}
