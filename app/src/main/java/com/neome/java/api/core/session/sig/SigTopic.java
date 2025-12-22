// neome.ai API - do not change
//

package com.neome.java.api.core.session.sig;

import com.neome.java.api.core.base.Types.EnumTopicType;
import com.neome.java.api.meta.base.SysId;
import com.neome.java.api.meta.base.Types.ArtifactId;
import com.neome.java.api.nucleus.base.sig.Sig;

@SuppressWarnings("unused")
public class SigTopic extends Sig
{
  public SysId aboutId;

  public ArtifactId artifactId;

  public EnumTopicType type;
}
