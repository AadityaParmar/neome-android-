// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldLogNumber extends DefnFieldNumber
{
  @Nullable
  public Boolean hideInfo;

  @Nullable
  public MetaIdRole[] logReadRoleSet;
}
