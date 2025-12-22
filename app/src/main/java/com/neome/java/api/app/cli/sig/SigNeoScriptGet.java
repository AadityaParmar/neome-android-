// neome.ai API - do not change
//

package com.neome.java.api.app.cli.sig;

import com.neome.java.api.meta.base.SysId;
import com.neome.java.api.meta.base.Types.ArtifactId;
import com.neome.java.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigNeoScriptGet extends Sig
{
  public ArtifactId artifactId;

  @Nullable
  public SysId metaId;

  @Nullable
  public String neoScript;
}
