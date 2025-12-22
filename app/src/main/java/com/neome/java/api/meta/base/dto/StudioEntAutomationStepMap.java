// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdStep;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntAutomationStepMap extends StudioBase
{
  public MetaIdStep[] keys;

  public Map<MetaIdStep, StudioEntAutomationStep> map;
}
