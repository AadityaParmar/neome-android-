// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdGrid;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioMapOfLayoutGrid extends DefnField
{
  public MetaIdForm formId;

  public MetaIdGrid gridId;

  @Nullable
  public Boolean isPluginForm;
}
