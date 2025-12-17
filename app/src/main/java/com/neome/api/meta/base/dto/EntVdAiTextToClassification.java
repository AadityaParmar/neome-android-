// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.EntVdAi;
import com.neome.api.meta.base.Types.MetaIdVar;
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter;

@SuppressWarnings("unused")
public class EntVdAiTextToClassification extends EntVdAi
{
  @Nullable
  public MetaIdVar classificationVarId;

  @Nullable
  public StudioDtoArgValueParameter inputField;
}
