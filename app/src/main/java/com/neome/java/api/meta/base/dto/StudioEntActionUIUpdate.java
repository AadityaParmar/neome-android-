// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnKindActionUIUpdate;
import com.neome.java.api.meta.base.Types.MetaIdGroup;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntActionUIUpdate extends StudioEntAction
{
  @Nullable
  public MetaIdGroup groupId;

  @Nullable
  public EnumDefnKindActionUIUpdate updateKind;
}
