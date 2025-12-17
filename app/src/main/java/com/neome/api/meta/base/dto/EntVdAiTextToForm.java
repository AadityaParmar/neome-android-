// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.EntVdAiWithOutput;
import com.neome.api.meta.base.dto.FormRefKey;
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter;

@SuppressWarnings("unused")
public class EntVdAiTextToForm extends EntVdAiWithOutput
{
  @Nullable
  public StudioDtoArgValueParameter inputField;

  @Nullable
  public FormRefKey outputForm;
}
