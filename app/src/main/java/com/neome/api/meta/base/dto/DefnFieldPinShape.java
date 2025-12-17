// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.DefnFieldEditable;
import com.neome.api.meta.base.Types.EnumDefnMapPinShape;
import com.neome.api.meta.base.Types.MetaIdField;

@SuppressWarnings("unused")
public class DefnFieldPinShape extends DefnFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public EnumDefnMapPinShape defaultValue;

  @Nullable
  public EnumDefnMapPinShape defaultVar;
}
