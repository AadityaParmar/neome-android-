// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoOptionPermission extends StudioBase
{
  public MetaIdRole metaId;

  @Nullable
  public Symbol name;

  public String[] optionIdSet;
}
