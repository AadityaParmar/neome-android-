// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.MetaIdPipelineVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdPipelineVar extends StudioBase
{
  public MetaIdPipelineVar metaId;

  public Symbol name;

  @Nullable
  public FormRefKey variableForm;
}
