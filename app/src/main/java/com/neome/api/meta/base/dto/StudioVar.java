// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnDeploy;
import com.neome.api.meta.base.Types.EnumStudioVarKind;
import com.neome.api.meta.base.Types.MetaIdVar;

@SuppressWarnings("unused")
public class StudioVar extends StudioBase
{
  public EnumDefnDeploy deploy;

  public StudioDetails details;

  public EnumStudioVarKind kind;

  public MetaIdVar metaId;
}
