// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldHandle extends StudioFieldEditable
{
  @Nullable
  public Boolean autoPickSelf;

  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public String defaultValue;

  @Nullable
  public MetaIdVar defaultVarId;

  @Nullable
  public MetaIdVar invalidDomainVarId;

  @Nullable
  public MetaIdVar invalidMobileCountryCodeSetVarId;

  @Nullable
  public MetaIdVar validDomainVarId;

  @Nullable
  public MetaIdVar validMobileCountryCodeSetVarId;
}
