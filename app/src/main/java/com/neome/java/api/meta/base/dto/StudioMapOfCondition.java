// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdCondition;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfCondition extends StudioBase
{
  @Nullable
  public Boolean andOr;

  @Nullable
  public MetaIdCondition[] keys;

  @Nullable
  public Map<MetaIdCondition, StudioMapOfCondition> map;

  public MetaIdCondition metaId;

  @Nullable
  public StudioDtoConditionStatement statement;
}
