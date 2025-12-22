// neome.ai API - do not change
//

package com.neome.java.api.nucleus.base.dto;

import com.neome.java.api.meta.base.Types.RequestId;
import com.neome.java.api.meta.base.Types.ServiceName;
import com.neome.java.api.meta.base.sig.ISig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EnvSignal<S extends ISig>
{
  @Nullable
  public Boolean cookieRememberMe;

  @Nullable
  public String cookieValue;

  @Nullable
  public EnvError error;

  @Nullable
  public RequestId requestId;

  @Nullable
  public String serverName;

  @Nullable
  public Long serverTime;

  @Nullable
  public ServiceName serviceName;

  @Nullable
  public S sig;

  @Nullable
  public String sigName;
}
