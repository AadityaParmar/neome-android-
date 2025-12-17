// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnVisibilityAction;
import com.neome.api.meta.base.Types.EnumDefnVisibilityActionOn;
import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.Types.MetaIdComp;
import com.neome.api.meta.base.Types.MetaIdGroup;
import com.neome.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.api.meta.base.Types.MetaIdVar;
import com.neome.api.meta.base.Types.MetaIdVisibilityAction;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnVisibilityAction
{
  @Nullable
  public MetaIdAction actionId;

  @Nullable
  public MetaIdComp[] compIdSet;

  @Nullable
  public MetaIdGroup[] groupIdSet;

  @Nullable
  public MetaIdLayoutForm[] layoutIdSet;

  @Nullable
  public MetaIdVar mappingVarId;

  public MetaIdVisibilityAction metaId;

  @Nullable
  public FieldDtoArg source;

  public EnumDefnVisibilityAction visibilityAction;

  @Nullable
  public EnumDefnVisibilityActionOn visibilityActionOn;
}
