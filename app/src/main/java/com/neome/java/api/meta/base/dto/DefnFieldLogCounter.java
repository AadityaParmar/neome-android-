// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldLogCounter extends DefnFieldCounter
{
  @Nullable
  public Boolean hideInfo;

  @Nullable
  public MetaIdRole[] logReadRoleSet;
}
