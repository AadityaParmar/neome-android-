// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnCompType;
import com.neome.java.api.meta.base.Types.MetaIdComposite;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdForm;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioPickFieldId extends DefnFieldEditable
{
  @Nullable
  public MetaIdComposite[] compositeIdSet;

  @Nullable
  public MetaIdField[] excludeFieldIdSet;

  @Nullable
  public EnumDefnCompType[] filterFieldTypeSet;

  public MetaIdForm formId;

  @Nullable
  public MetaIdField[] includeFieldIdSet;

  @Nullable
  public DefnStudioMapOfDtoOption includeOptionMap;

  @Nullable
  public Boolean showCompositeName;
}
