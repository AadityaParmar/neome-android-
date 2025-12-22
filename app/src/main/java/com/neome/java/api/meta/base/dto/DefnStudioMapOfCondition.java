// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdGrid;
import com.neome.java.api.meta.base.Types.MetaIdPlugin;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioMapOfCondition extends DefnField
{
  @Nullable
  public MetaIdVar[] excludeVarIdSet;

  @Nullable
  public MetaIdForm inputFormId;

  public MetaIdForm sourceFormId;

  @Nullable
  public MetaIdGrid sourceGridId;

  @Nullable
  public MetaIdPlugin sourcePluginId;
}
