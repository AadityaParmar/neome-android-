// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdVisibilityRule;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioVisibilityRuleMap extends StudioBase
{
  public MetaIdVisibilityRule[] keys;

  public Map<MetaIdVisibilityRule, StudioVisibilityRule> map;
}
