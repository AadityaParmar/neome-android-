// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.DefnFieldEditable;
import com.neome.api.meta.base.Types.EnumDefnQuarter;
import com.neome.api.meta.base.Types.MetaIdField;

@SuppressWarnings("unused")
public class DefnFieldQuarter extends DefnFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public EnumDefnQuarter defaultValue;

  @Nullable
  public EnumDefnQuarter defaultVar;
}
