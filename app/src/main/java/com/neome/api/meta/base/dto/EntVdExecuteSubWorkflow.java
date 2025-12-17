// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.Types.MetaIdPipelineVar;
import com.neome.api.meta.base.Types.MetaIdVdAutoNode;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class EntVdExecuteSubWorkflow extends EntVdAutoStepWithOutputAndError
{
  @Nullable
  public Map<MetaIdPipelineVar, MetaIdPipelineParam> sharedParamMap;

  @Nullable
  public MetaIdVdAutoNode startNodeId;
}
