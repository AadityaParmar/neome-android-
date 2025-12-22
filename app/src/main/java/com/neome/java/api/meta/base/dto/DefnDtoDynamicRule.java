// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnCompType;
import com.neome.java.api.meta.base.Types.MetaIdFieldDynamicRule;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoDynamicRule
{
  public DefnMapOfDynamicCondition conditionNode;

  public EnumDefnCompType fieldType;

  public MetaIdFieldDynamicRule metaId;

  @Nullable
  public DefnStudioMapOfDtoOption optionMap;
}
