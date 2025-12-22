// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnHttpMethod;
import com.neome.java.api.meta.base.Types.KeychainId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdEventRpcCall extends EntVdEvent
{
  @Nullable
  public KeychainId[] allowedKeychainIdSet;

  @Nullable
  public EnumDefnHttpMethod apiMethod;

  @Nullable
  public String apiName;

  @Nullable
  public Boolean executeAsync;

  @Nullable
  public FormRefKey inputForm;

  @Nullable
  public FormRefKey outputForm;

  @Nullable
  public StudioPluginApiBody requestBody;

  @Nullable
  public StudioPluginApiBody responseBody;
}
