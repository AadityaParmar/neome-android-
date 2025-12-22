// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdVdAutoDia;
import com.neome.java.api.meta.base.Types.MetaIdVdAutoNode;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdWorkflowPointer extends StudioBase
{
  @Nullable
  public MetaIdVdAutoDia autoDiaId;

  @Nullable
  public MetaIdVdAutoNode startNodeId;
}
