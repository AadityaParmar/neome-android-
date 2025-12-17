// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Symbol;

@SuppressWarnings("unused")
public class DtoEntRole
{
  @Nullable
  public String description;

  @Nullable
  public String label;

  public Symbol name;

  public MetaIdRole roleId;
}
