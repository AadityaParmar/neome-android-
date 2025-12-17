// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.EntVdAi;
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter;

@SuppressWarnings("unused")
public class EntVdAiTextToJSON extends EntVdAi
{
  @Nullable
  public StudioDtoArgValueParameter inputField;

  @Nullable
  public StudioDtoArgValueParameter outputField;
}
