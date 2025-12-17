// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldHandle extends DefnFieldEditable
{
  @Nullable
  public Boolean autoPickSelf;

  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public String defaultValue;

  @Nullable
  public String defaultVar;

  @Nullable
  public String[] invalidDomainSetVar;

  @Nullable
  public String[] invalidMobileCountryCodeSetVar;

  @Nullable
  public String[] validDomainSetVar;

  @Nullable
  public String[] validMobileCountryCodeSetVar;
}
