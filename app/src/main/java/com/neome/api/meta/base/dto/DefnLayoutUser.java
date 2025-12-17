// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumDefnLayoutUserKind;
import com.neome.api.meta.base.Types.MetaIdLayoutUser;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnLayoutUser
{
  @Nullable
  public MetaIdLayoutUser[] allowToSwitchLayoutIdSet;

  @Nullable
  public MetaIdRole[] excludeRoleIdSet;

  @Nullable
  public MetaIdRole[] includeRoleIdSet;

  public EnumDefnLayoutUserKind kind;

  @Nullable
  public String label;

  public MetaIdLayoutUser metaId;

  public Symbol name;

  @Nullable
  public Boolean showMyAssistantsOnly;
}
