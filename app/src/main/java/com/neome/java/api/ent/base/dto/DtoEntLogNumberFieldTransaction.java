// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.home.drawer.sig.SigUserAvatar;
import com.neome.java.api.meta.base.Types.EnumDefnLogOperationKind;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class DtoEntLogNumberFieldTransaction
{
  public Date createdOn;

  @Nullable
  public String message;

  public EnumDefnLogOperationKind operationKind;

  public String transactionId;

  public SigUserAvatar userAvatar;

  public double value;
}
