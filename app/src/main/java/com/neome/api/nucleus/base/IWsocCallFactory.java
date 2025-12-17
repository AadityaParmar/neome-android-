// neome.ai API - do not change
//

package com.neome.api.nucleus.base;

import com.neome.api.meta.base.Types.ArtifactId;
import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.meta.base.sig.ISig;

public interface IWsocCallFactory
{
  <S extends ISig> IWsocCall<S> create(Class<S> sigCls,
    ArtifactId artifactId,
    ServiceName serviceName,
    String apiName);
}
