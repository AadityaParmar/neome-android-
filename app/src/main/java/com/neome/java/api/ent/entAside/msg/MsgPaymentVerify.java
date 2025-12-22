// neome.ai API - do not change
//

package com.neome.java.api.ent.entAside.msg;

import com.neome.java.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgPaymentVerify extends Msg
{
  public String invoiceId;

  public String paymentId;

  public String signature;
}
