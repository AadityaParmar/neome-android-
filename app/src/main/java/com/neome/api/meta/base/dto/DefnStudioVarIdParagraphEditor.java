// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumStudioVarKind;
import com.neome.api.meta.base.Types.MetaIdComposite;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdPlugin;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioVarIdParagraphEditor extends DefnField
{
  @Nullable
  public EnumStudioVarKind[] argBinderFilterVarKindSet;

  public MetaIdForm argBinderFormId;

  @Nullable
  public MetaIdComposite[] compositeIdSet;

  @Nullable
  public MetaIdField[] excludeFieldIdSet;

  @Nullable
  public EnumStudioVarKind[] filterVarKindSet;

  @Nullable
  public MetaIdPlugin pluginId;

  @Nullable
  public Boolean required;

  @Nullable
  public Boolean showAsEdit;
}
