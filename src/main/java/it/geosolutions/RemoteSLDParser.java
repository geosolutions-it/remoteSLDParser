package it.geosolutions;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.styling.FeatureTypeStyle;
import org.geotools.styling.NamedLayer;
import org.geotools.styling.Rule;
import org.geotools.styling.SLDParser;
import org.geotools.styling.Style;
import org.geotools.styling.StyleFactory;
import org.geotools.styling.StyledLayer;
import org.geotools.styling.StyledLayerDescriptor;
import org.geotools.styling.UserLayer;
import org.opengis.filter.Filter;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RemoteSLDParser {
    public static void main(String[] args) throws IOException {
        // Issuing a GetStyles request, returns all the styles associated to a given layer 
        // (default, and alternative ones) as one large SLD document 
        final String location = "http://cloudsdi.geo-solutions" +
                ".it/geoserver/eumetsat/wms?service=WMS&version=1.1" +
                ".1&request=GetStyles&layers=eumetsat%3Awind_ascat";
        try (InputStream is = new URL(location).openStream()) {
            final StyledLayerDescriptor sld = parseStyleFromStream(is);

            // go one by one and extract interesting bits as a demo
            for (StyledLayer layer : sld.getStyledLayers()) {
                Style[] styles = getStyles(layer);
                for (Style style : styles) {
                    System.out.println("--- Found style " + style.getName() + " ---");
                    final List<FeatureTypeStyle> featureTypeStyles = style.featureTypeStyles();
                    System.out.println("Style has " + featureTypeStyles.size() + " feature type " +
                            "style");
                    int ftsCount = 1;
                    for (FeatureTypeStyle featureTypeStyle : featureTypeStyles) {
                        System.out.println("  FeatureTypeStyle " + ftsCount++);
                        final List<Rule> rules = featureTypeStyle.rules();
                        for (Rule rule : rules) {
                            System.out.println("    " + Optional.ofNullable(rule.getFilter()).orElse(Filter.INCLUDE));
                            System.out.println("      " + rule.symbolizers().stream().map(s -> s.getClass().getSimpleName()).collect(Collectors.joining("\n      ")));
                        }
                    }
                    System.out.println("\n");
                }
            }
        }
    }

    private static Style[] getStyles(StyledLayer layer) {
        if (layer instanceof UserLayer) {
            UserLayer userLayer = (UserLayer) layer;
            return userLayer.getUserStyles();
        } else if (layer instanceof NamedLayer) {
            return ((NamedLayer) layer).getStyles();
        }
        throw new IllegalArgumentException("Unrecognized layer type: " + layer);

    }

    private static StyledLayerDescriptor parseStyleFromStream(InputStream is) {
        final StyleFactory styleFactory = CommonFactoryFinder.getStyleFactory();
        SLDParser parser = new SLDParser(styleFactory, is);
        return parser.parseSLD();
    }
}
