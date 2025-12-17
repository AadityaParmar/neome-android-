// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

import com.neome.api.meta.base.Types.EnumDefnLogOperationKind;
import com.neome.api.home.drawer.sig.SigUserAvatar;

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
