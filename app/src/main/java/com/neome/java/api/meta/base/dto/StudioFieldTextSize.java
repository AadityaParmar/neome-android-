// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnTextSize;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldTextSize extends StudioFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public EnumDefnTextSize defaultValue;

  @Nullable
  public MetaIdVar defaultVarId;
}
