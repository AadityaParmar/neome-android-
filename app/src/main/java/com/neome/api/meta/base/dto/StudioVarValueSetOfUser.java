// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdPlugin;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioVarValueSetOfUser extends StudioBase
{
  @Nullable
  public StudioMapOfUserCondition node;

  @Nullable
  public MetaIdForm sourceFormId;

  @Nullable
  public MetaIdPlugin sourcePluginId;
}
