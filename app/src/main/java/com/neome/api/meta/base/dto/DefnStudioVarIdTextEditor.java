// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnArgBinder;
import com.neome.api.meta.base.Types.EnumStudioVarKind;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdPlugin;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioVarIdTextEditor extends DefnField
{
  @Nullable
  public EnumStudioVarKind[] argBinderFilterVarKindSet;

  @Nullable
  public MetaIdForm argBinderFormId;

  @Nullable
  public MetaIdField[] excludeFieldIdSet;

  @Nullable
  public String[] filterContextOptionSet;

  @Nullable
  public EnumDefnArgBinder[] filterKindSet;

  @Nullable
  public EnumStudioVarKind[] filterVarKindSet;

  @Nullable
  public MetaIdForm inputFormId;

  @Nullable
  public MetaIdForm pluginConfigFormId;

  @Nullable
  public MetaIdPlugin pluginId;

  @Nullable
  public Boolean showAsEdit;
}
