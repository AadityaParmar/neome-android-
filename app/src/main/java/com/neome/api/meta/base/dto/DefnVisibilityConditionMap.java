// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdVisibilityCondition;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnVisibilityConditionMap
{
  @Nullable
  public Boolean andOr;

  @Nullable
  public MetaIdVisibilityCondition[] keys;

  @Nullable
  public Map<MetaIdVisibilityCondition, DefnVisibilityConditionMap> map;

  public MetaIdVisibilityCondition metaId;

  @Nullable
  public DefnVisibilityCondition statement;
}
