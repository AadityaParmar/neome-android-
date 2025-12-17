// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumStudioVarKind;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioPickVarId extends DefnFieldEditable
{
  @Nullable
  public MetaIdVar[] excludeVarIdSet;

  @Nullable
  public String[] filterOptionSet;

  @Nullable
  public MetaIdForm formId;

  @Nullable
  public Boolean showAsEdit;

  @Nullable
  public EnumStudioVarKind varKind;

  @Nullable
  public EnumStudioVarKind[] varKindSet;
}
