// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnRefSetOperationKind;
import com.neome.java.api.meta.base.Types.EnumDefnSortOrder;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdFieldRefSetSet extends EntVdAutoStep
{
  @Nullable
  public StudioDtoArgValueParameter inputField;

  @Nullable
  public EnumDefnRefSetOperationKind operation;

  @Nullable
  public StudioDtoArgValueParameter outputField;

  @Nullable
  public EnumDefnSortOrder outputSortOrder;
}
