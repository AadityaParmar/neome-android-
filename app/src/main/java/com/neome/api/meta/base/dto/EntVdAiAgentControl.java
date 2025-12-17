// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.GhostId;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.Types.MetaIdPipelineVar;
import com.neome.api.meta.base.Types.MetaIdVdAutoNode;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class EntVdAiAgentControl extends StudioBase
{
  @Nullable
  public StudioValueParagraph description;

  public GhostId metaId;

  @Nullable
  public StudioValueText name;

  @Nullable
  public Map<MetaIdPipelineVar, MetaIdPipelineParam> sharedParamMap;

  @Nullable
  public MetaIdVdAutoNode startNodeId;
}
