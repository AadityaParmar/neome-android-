// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdAutomation;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioEntAutomation;

@SuppressWarnings("unused")
public class StudioEntAutomationMap extends StudioBase
{
  public MetaIdAutomation[] keys;

  public Map<MetaIdAutomation, StudioEntAutomation> map;
}
