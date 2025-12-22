// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdPipelineParam;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdAiWithOutput extends EntVdAi
{
  @Nullable
  public MetaIdPipelineParam outputParamId;

  @Nullable
  public String outputParamName;
}
