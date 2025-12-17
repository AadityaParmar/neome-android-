// neome.ai API - do not change
//

package com.neome.api.core.base.dto;

import com.neome.api.core.base.Types.EnumTopicType;
import com.neome.api.meta.base.SysId;
import com.neome.api.meta.base.Types.ArtifactId;

@SuppressWarnings("unused")
public class DtoTopic
{
  public SysId aboutId;

  public ArtifactId artifactId;

  public EnumTopicType type;
}
