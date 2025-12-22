// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdPipelineVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntPipelineVar extends StudioBase
{
  @Nullable
  public MetaIdForm formId;

  public MetaIdPipelineVar metaId;

  public Symbol name;
}
