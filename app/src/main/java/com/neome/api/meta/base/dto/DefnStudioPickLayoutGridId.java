// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdLayoutGrid;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioPickLayoutGridId extends DefnFieldEditable
{
  public MetaIdLayoutGrid[] excludeLayoutGridIdSet;

  @Nullable
  public EnumDefnLayoutGridKind[] filterLayoutKindSet;

  public MetaIdForm formId;

  @Nullable
  public MetaIdGrid gridId;
}
