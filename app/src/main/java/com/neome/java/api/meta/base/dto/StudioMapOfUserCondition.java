// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdUserCondition;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfUserCondition extends StudioBase
{
  @Nullable
  public Boolean andOr;

  @Nullable
  public MetaIdUserCondition[] keys;

  @Nullable
  public Map<MetaIdUserCondition, StudioMapOfUserCondition> map;

  public MetaIdUserCondition metaId;

  @Nullable
  public StudioDtoUserConditionStatement statement;
}
