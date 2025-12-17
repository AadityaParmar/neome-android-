// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.EnumDefnKindActionUIUpdate;
import com.neome.api.meta.base.Types.MetaIdGroup;
import com.neome.api.meta.base.dto.StudioEntAction;

@SuppressWarnings("unused")
public class StudioEntActionUIUpdate extends StudioEntAction
{
  @Nullable
  public MetaIdGroup groupId;

  @Nullable
  public EnumDefnKindActionUIUpdate updateKind;
}
