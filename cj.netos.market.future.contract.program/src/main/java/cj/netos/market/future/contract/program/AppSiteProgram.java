package cj.netos.market.future.contract.program;

import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.CircuitException;
import cj.studio.gateway.socket.Destination;
import cj.studio.gateway.socket.app.GatewayAppSiteProgram;
import cj.studio.gateway.socket.app.ProgramAdapterType;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.LoggerFactory;

@CjService(name = "$.cj.studio.gateway.app", isExoteric = true)
public class AppSiteProgram extends GatewayAppSiteProgram {

	@Override
	protected void onstart(Destination destination, String homeDir, ProgramAdapterType arg2) throws CircuitException {
		PropertyConfigurator.configure(String.format("%s/log4j.properties",homeDir));
	}

}
