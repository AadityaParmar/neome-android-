// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdAutomation;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntAutomationMap extends StudioBase
{
  public MetaIdAutomation[] keys;

  public Map<MetaIdAutomation, StudioEntAutomation> map;
}
