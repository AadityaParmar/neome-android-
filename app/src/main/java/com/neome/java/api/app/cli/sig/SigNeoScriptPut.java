// neome.ai API - do not change
//

package com.neome.java.api.app.cli.sig;

import com.neome.java.api.meta.base.Types.ArtifactId;
import com.neome.java.api.meta.base.dto.DtoLogItemList;
import com.neome.java.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigNeoScriptPut extends Sig
{
  @Nullable
  public DtoLogItemList appendItemList;

  @Nullable
  public String cliCodeId;

  @Nullable
  public String lastArtifactName;

  @Nullable
  public ArtifactId lastDeployUnitId;
}
