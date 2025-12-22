// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnKindActionUIUpdate;
import com.neome.java.api.meta.base.Types.MetaIdGroup;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoEntActionUIUpdate extends DtoEntAction
{
  @Nullable
  public MetaIdGroup groupId;

  public EnumDefnKindActionUIUpdate updateKind;
}
