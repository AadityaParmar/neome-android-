// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnPaymentMethod;
import com.neome.api.meta.base.Types.EnumDefnPaymentPlan;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class StudioEntDeployPayment extends StudioBase
{
  @Nullable
  public String communityMemId;

  @Nullable
  public String currency;

  @Nullable
  public EnumDefnPaymentPlan currentPlan;

  @Nullable
  public Date freeTrialDate;

  @Nullable
  public Long maximumMessagesPerMonth;

  @Nullable
  public Long messagesPerSecond;

  @Nullable
  public String paymentGatewayToken;

  @Nullable
  public EnumDefnPaymentMethod paymentMethod;

  @Nullable
  public Double totalPricePerMonth;

  @Nullable
  public Long totalStorageGB;
}
