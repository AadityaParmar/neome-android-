// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.CurrencyKey;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldCurrency extends DefnFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public CurrencyKey defaultValue;

  @Nullable
  public CurrencyKey defaultVar;
}
