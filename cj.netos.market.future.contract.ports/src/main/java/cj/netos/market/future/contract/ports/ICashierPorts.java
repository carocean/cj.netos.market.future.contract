package cj.netos.market.future.contract.ports;

import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.InRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.Map;

@CjOpenports(usage = "商户收银台。接收收银事件请求，生成双方的合约")
public interface ICashierPorts extends IOpenportService {
    @CjOpenport(usage = "收款", command = "post")
    void doReceivables(@CjOpenportParameter(usage = "顾额uid", name = "customerUID") String customerUID, @CjOpenportParameter(usage = "商户uid", name = "merchantUID") String merchantUID, @CjOpenportParameter(usage = "收到的钱，单位为分，因此为整型", name = "money") long money, @CjOpenportParameter(usage = "其它属性", name = "props", in = InRequest.content) Map<String, String> props) throws CircuitException;
}
