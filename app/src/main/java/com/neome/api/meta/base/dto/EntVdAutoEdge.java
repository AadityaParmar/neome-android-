// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnKindAutoEdge;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.Types.MetaIdVdAutoEdge;
import com.neome.api.meta.base.Types.MetaIdVdAutoNode;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdAutoEdge extends VdBase
{
  @Nullable
  public String fromNodeHandleId;

  public MetaIdVdAutoNode fromNodeId;

  public EnumDefnKindAutoEdge kind;

  public MetaIdVdAutoEdge metaId;

  @Nullable
  public MetaIdPipelineParam outputPipelineParamId;

  public MetaIdVdAutoNode toNodeId;

  @Nullable
  public String value;
}
