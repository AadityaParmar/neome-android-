// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdCondition;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnMapOfCondition
{
  @Nullable
  public Boolean andOr;

  @Nullable
  public MetaIdCondition[] keys;

  @Nullable
  public Map<MetaIdCondition, DefnMapOfCondition> map;

  public MetaIdCondition metaId;

  @Nullable
  public DefnDtoConditionStatement statement;
}
