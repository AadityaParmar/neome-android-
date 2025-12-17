// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumContactCopyField;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnFieldRefContact extends DefnField
{
  @Nullable
  public Map<MetaIdField, EnumContactCopyField> copyFieldMap;

  @Nullable
  public EnumContactCopyField[] editableContactFieldSet;
}
