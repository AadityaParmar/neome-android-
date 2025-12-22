// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.GhostId;

import java.util.Map;

@SuppressWarnings("unused")
public class EntVdPromptMap extends StudioBase
{
  public GhostId[] keys;

  public Map<GhostId, EntVdPrompt> map;
}
