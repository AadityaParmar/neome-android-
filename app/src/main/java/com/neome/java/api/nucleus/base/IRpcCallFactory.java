// neome.ai API - do not change
//

package com.neome.java.api.nucleus.base;

import com.neome.java.api.meta.base.Types.ArtifactId;
import com.neome.java.api.meta.base.Types.ServiceName;
import com.neome.java.api.meta.base.sig.ISig;

public interface IRpcCallFactory
{
  <S extends ISig> IRpcCall<S> create(Class<S> sigCls,
    ArtifactId artifactId,
    ServiceName serviceName,
    String apiName);
}
