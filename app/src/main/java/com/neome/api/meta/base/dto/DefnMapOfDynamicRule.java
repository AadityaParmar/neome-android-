// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdFieldDynamicRule;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnMapOfDynamicRule
{
  public MetaIdFieldDynamicRule[] keys;

  public Map<MetaIdFieldDynamicRule, DefnDtoDynamicRule> map;
}
