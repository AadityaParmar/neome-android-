// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

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
