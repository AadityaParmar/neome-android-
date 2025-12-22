// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.AnyEmailId;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldEmail extends DefnFieldEditable
{
  @Nullable
  public Boolean autoPickSelf;

  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public AnyEmailId defaultValue;

  @Nullable
  public AnyEmailId defaultVar;

  @Nullable
  public String[] invalidDomainSetVar;

  @Nullable
  public String[] validDomainSetVar;
}
