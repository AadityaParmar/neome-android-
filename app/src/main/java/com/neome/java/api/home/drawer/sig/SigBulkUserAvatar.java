// neome.ai API - do not change
//

package com.neome.java.api.home.drawer.sig;

import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.dto.EnvValidationError;
import com.neome.java.api.nucleus.base.sig.Sig;

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
