package cj.netos.market.future.contract.program.ports;

import cj.netos.market.future.contract.ports.ICashierPorts;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.CircuitException;
import org.apache.log4j.Logger;

import java.util.Map;

@CjService(name = "/ports/cashier")
public class CashierPorts implements ICashierPorts {
    Logger logger = Logger.getLogger(getClass());

    @Override
    public void doReceivables(String customerUID, String merchantUID, long money, Map<String, String> props) throws CircuitException {
        logger.debug(String.format("-----%s", customerUID));
        //产生四份合约，顾客是买入卖出两份对冲合约；商家是买入卖出两份对冲合约；对冲合约是期货市场套期保值的常用手段
        //顾客取得这两份合约需支付消费款给平台，并记入合约款已付，并记入该商家合约号；商家获得买入卖出两份合约，记账为该顾客，且记入顾客合约号。
        //在商家的合约成交后，结算中心将根据商家的合约号分账给商家
        //消费行为是由系统根据撮合系统的期货现价自动生成双方合约的，
        //算法：将帑市现价乘于100，便变成了整数。如果1点现价12.10元，顾客消费的钱是100元，则可购点数为：100/12.10元，再除以2便是生成对冲合约的点数
        //对冲合约是开仓买、开仓卖。何时平仓是撮合系统发现商家和顾客都成交后，通知结算系统平仓，结算分账给商家后通知帑银孵化器生成期市帑。同时结算系统通知下单系统合约已被处理。
    }
}
