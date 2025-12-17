// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.AnyEmailId;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldEmail extends StudioFieldEditable
{
  @Nullable
  public Boolean autoPickSelf;

  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public AnyEmailId defaultValue;

  @Nullable
  public MetaIdVar defaultVarId;

  @Nullable
  public MetaIdVar invalidDomainVarId;

  @Nullable
  public MetaIdVar validDomainVarId;
}
