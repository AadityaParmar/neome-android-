// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdVisibilityCondition;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfVisibilityCondition extends StudioBase
{
  @Nullable
  public Boolean andOr;

  @Nullable
  public MetaIdVisibilityCondition[] keys;

  @Nullable
  public Map<MetaIdVisibilityCondition, StudioMapOfVisibilityCondition> map;

  public MetaIdVisibilityCondition metaId;

  @Nullable
  public StudioDtoVisibilityCondition statement;
}
