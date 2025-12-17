// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.GhostId;

import java.util.Map;

@SuppressWarnings("unused")
public class EntVdWorkflowControlMap extends StudioBase
{
  public GhostId[] keys;

  public Map<GhostId, EntVdWorkflowControl> map;
}
