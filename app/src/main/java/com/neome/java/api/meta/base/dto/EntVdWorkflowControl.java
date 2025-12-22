// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.GhostId;
import com.neome.java.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.java.api.meta.base.Types.MetaIdPipelineVar;
import com.neome.java.api.meta.base.Types.MetaIdVdAutoNode;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class EntVdWorkflowControl extends StudioBase
{
  @Nullable
  public MetaIdPipelineParam inputParamId;

  public GhostId metaId;

  @Nullable
  public MetaIdPipelineVar outputParamId;

  @Nullable
  public Map<MetaIdPipelineVar, MetaIdPipelineParam> sharedParamMap;

  @Nullable
  public MetaIdVdAutoNode startNodeId;
}
