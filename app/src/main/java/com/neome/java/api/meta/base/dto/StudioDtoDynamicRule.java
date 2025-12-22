// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.EnumStudioCompType;
import com.neome.java.api.meta.base.Types.MetaIdFieldDynamicRule;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoDynamicRule extends StudioBase
{
  @Nullable
  public StudioMapOfFieldDynamicCondition conditionNode;

  public EnumStudioCompType fieldType;

  public MetaIdFieldDynamicRule metaId;

  public Symbol name;

  @Nullable
  public MetaIdVar sourceVarId;
}
