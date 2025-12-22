// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdFieldDynamicCondition;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfFieldDynamicCondition extends StudioBase
{
  @Nullable
  public Boolean andOr;

  @Nullable
  public MetaIdFieldDynamicCondition[] keys;

  @Nullable
  public Map<MetaIdFieldDynamicCondition, StudioMapOfFieldDynamicCondition> map;

  public MetaIdFieldDynamicCondition metaId;

  @Nullable
  public StudioDtoFieldDynamicCondition statement;
}
