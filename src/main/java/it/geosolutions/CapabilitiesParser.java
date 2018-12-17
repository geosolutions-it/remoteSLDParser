package it.geosolutions;

import org.geotools.data.ows.Layer;
import org.geotools.data.ows.WMSCapabilities;
import org.geotools.data.wms.WebMapServer;
import org.geotools.ows.ServiceException;

import java.io.IOException;
import java.net.URL;
import java.util.stream.Collectors;

public class CapabilitiesParser {
    public static void main(String[] args) throws IOException, ServiceException {
        // Issuing a GetCapabilities request 
        final String location = "http://cloudsdi.geo-solutions" +
                ".it/geoserver/wms?service=WMS&version=1.1" +
                ".1&request=GetCapabilities";
        WebMapServer wms = new WebMapServer(new URL(location));
        WMSCapabilities capabilities = wms.getCapabilities();
        for (Layer layer : capabilities.getLayerList()) {
            printLayer(layer, "");
        }
    }

    private static void printLayer(Layer layer, String indent) {
        if (layer.getName() != null) {
            System.out.println(indent + layer.getName() + ": " + layer.getStyles().stream().map(l -> l.getName()).collect(Collectors.joining()));
            if (layer.getChildren() != null) {
                for (Layer child : layer.getChildren()) {
                    printLayer(child, indent + "    ");
                }
            }
        }
    }

}
