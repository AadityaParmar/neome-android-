// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdVdAutoDia;
import com.neome.api.meta.base.Types.MetaIdVdAutoNode;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdWorkflowPointer extends StudioBase
{
  @Nullable
  public MetaIdVdAutoDia autoDiaId;

  @Nullable
  public MetaIdVdAutoNode startNodeId;
}
