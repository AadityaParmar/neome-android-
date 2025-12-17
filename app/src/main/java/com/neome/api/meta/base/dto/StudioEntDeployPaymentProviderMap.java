// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdPaymentProvider;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntDeployPaymentProviderMap extends StudioBase
{
  @Nullable
  public MetaIdPaymentProvider defaultPaymentProviderId;

  public MetaIdPaymentProvider[] keys;

  public Map<MetaIdPaymentProvider, StudioEntPaymentProvider> map;
}
