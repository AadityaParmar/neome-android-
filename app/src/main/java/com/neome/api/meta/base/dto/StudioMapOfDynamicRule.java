// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdFieldDynamicRule;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfDynamicRule extends StudioBase
{
  public MetaIdFieldDynamicRule[] keys;

  public Map<MetaIdFieldDynamicRule, StudioDtoDynamicRule> map;
}
