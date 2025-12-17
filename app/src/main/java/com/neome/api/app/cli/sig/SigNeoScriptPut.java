// neome.ai API - do not change
//

package com.neome.api.app.cli.sig;

import com.neome.api.meta.base.Types.ArtifactId;
import com.neome.api.meta.base.dto.DtoLogItemList;
import com.neome.api.nucleus.base.sig.Sig;

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
