// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumPaymentProviderKind;
import com.neome.api.meta.base.Types.MetaIdPaymentProvider;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntPaymentProvider extends StudioBase
{
  public EnumPaymentProviderKind kind;

  public MetaIdPaymentProvider metaId;

  @Nullable
  public Symbol name;
}
