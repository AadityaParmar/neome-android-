// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldSymbol extends DefnFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public Symbol defaultValue;

  @Nullable
  public Symbol defaultVar;
}
