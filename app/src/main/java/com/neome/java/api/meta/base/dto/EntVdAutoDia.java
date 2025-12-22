// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.MetaIdVdAutoDia;
import com.neome.java.api.meta.base.Types.MetaIdVdAutoEdge;
import com.neome.java.api.meta.base.Types.MetaIdVdAutoNode;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class EntVdAutoDia extends EntVdDia
{
  @Nullable
  public String description;

  public Map<MetaIdVdAutoEdge, EntVdAutoEdge> edgeMap;

  @Nullable
  public String label;

  public MetaIdVdAutoDia metaId;

  public Symbol name;

  public Map<MetaIdVdAutoNode, EntVdAutoNode> nodeMap;
}
