// neome.ai API - do not change
//

package com.neome.api.app.cli.sig;

import com.neome.api.meta.base.SysId;
import com.neome.api.meta.base.Types.ArtifactId;
import com.neome.api.nucleus.base.sig.Sig;

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
