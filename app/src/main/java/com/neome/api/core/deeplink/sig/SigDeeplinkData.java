// neome.ai API - do not change
//

package com.neome.api.core.deeplink.sig;

import com.neome.api.core.base.Types.EnumDeeplinkActionType;
import com.neome.api.core.base.dto.DeeplinkDataPayload;
import com.neome.api.core.base.dto.DtoDeeplinkWebPreview;
import com.neome.api.meta.base.Types.ArtifactId;
import com.neome.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigDeeplinkData extends Sig
{
  public ArtifactId artifactId;

  public EnumDeeplinkActionType deeplinkActionType;

  @Nullable
  public DeeplinkDataPayload payload;

  @Nullable
  public DtoDeeplinkWebPreview preview;

  public boolean requiredSignIn;
}
