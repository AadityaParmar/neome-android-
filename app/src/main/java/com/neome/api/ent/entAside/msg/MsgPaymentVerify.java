// neome.ai API - do not change
//

package com.neome.api.ent.entAside.msg;

import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgPaymentVerify extends Msg
{
  public String invoiceId;

  public String paymentId;

  public String signature;
}