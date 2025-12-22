// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdGrid;
import com.neome.java.api.meta.base.Types.MetaIdPlugin;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioVarValueCondition extends StudioBase
{
  @Nullable
  public MetaIdForm inputFormId;

  @Nullable
  public MetaIdPlugin inputPluginId;

  @Nullable
  public StudioMapOfCondition node;

  @Nullable
  public MetaIdForm sourceFormId;

  @Nullable
  public MetaIdGrid sourceGridId;

  @Nullable
  public MetaIdPlugin sourcePluginId;
}
