// neome.ai API - do not change
//

package com.neome.api.home.drawer.sig;

import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.meta.base.dto.EnvValidationError;
import com.neome.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class SigBulkUserAvatar extends Sig
{
  @Nullable
  public Map<EntUserId, EnvValidationError> errorMap;

  @Nullable
  public Map<EntUserId, SigUserAvatar> resultMap;
}
