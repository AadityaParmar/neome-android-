// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdFieldDynamicRule;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfDynamicRule extends StudioBase
{
  public MetaIdFieldDynamicRule[] keys;

  public Map<MetaIdFieldDynamicRule, StudioDtoDynamicRule> map;
}
