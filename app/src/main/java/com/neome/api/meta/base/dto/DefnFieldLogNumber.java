// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldLogNumber extends DefnFieldNumber
{
  @Nullable
  public Boolean hideInfo;

  @Nullable
  public MetaIdRole[] logReadRoleSet;
}
