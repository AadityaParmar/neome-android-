// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.meta.base.Types.MetaIdVdAutoDia;
import com.neome.api.meta.base.Types.MetaIdVdAutoNode;

import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class DtoWorkflowDebugConfig
{
  public Map<MetaIdVdAutoDia, Set<MetaIdVdAutoNode>> breakpointMap;

  @Nullable
  public EntUserId defaultDebugEntUserId;
}
