// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioCompArray extends DefnField
{
  @Nullable
  public MetaIdField[] fieldIdSet;

  @Nullable
  public Boolean hideAddDeleteBtn;

  @Nullable
  public Long selectedIndex;

  @Nullable
  public Boolean showSeparator;
}
