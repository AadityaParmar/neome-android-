// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdGrid;
import com.neome.java.api.meta.base.Types.MetaIdPlugin;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioMapOfMapping extends DefnFieldEditable
{
  @Nullable
  public MetaIdForm fromFormId;

  @Nullable
  public MetaIdGrid fromGridId;

  @Nullable
  public MetaIdPlugin fromPluginId;

  public MetaIdForm toFormId;

  @Nullable
  public MetaIdGrid toGridId;

  @Nullable
  public MetaIdPlugin toPluginId;
}
