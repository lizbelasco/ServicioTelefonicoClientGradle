/**
 * 
 */
package com.soa.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.soa.dto.CrearReporteRequest;
import com.soa.dto.CrearReporteResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Clase que genera el método de ejecución de un servicio web.
 */
public class PhoneServiceClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(PhoneServiceClient.class);

    public CrearReporteResponse execute() {

        CrearReporteRequest request = new CrearReporteRequest();
        request.setNoTelefonico("1");

        log.info("Executing WS");

        CrearReporteResponse response = (CrearReporteResponse) 
                getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:9080/crear", request, 
                new SoapActionCallback("http://soa.com/CrearReporteRequest"));

        return response;
    }

}