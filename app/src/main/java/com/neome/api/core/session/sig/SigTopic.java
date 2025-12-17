// neome.ai API - do not change
//

package com.neome.api.core.session.sig;

import com.neome.api.core.base.Types.EnumTopicType;
import com.neome.api.meta.base.SysId;
import com.neome.api.meta.base.Types.ArtifactId;
import com.neome.api.nucleus.base.sig.Sig;

@SuppressWarnings("unused")
public class SigTopic extends Sig
{
  public SysId aboutId;

  public ArtifactId artifactId;

  public EnumTopicType type;
}
