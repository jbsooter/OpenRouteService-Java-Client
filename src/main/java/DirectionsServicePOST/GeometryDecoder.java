package DirectionsServicePOST;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.List;

public class GeometryDecoder {
       // https://giscience.github.io/openrouteservice/documentation/Geometry-Decoding.html
        public static List<List<Double>> decodeGeometry(String encodedGeometry, boolean inclElevation) {
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode geometry = mapper.createArrayNode();
            int len = encodedGeometry.length();
            int index = 0;
            int lat = 0;
            int lng = 0;
            int ele = 0;

            while (index < len) {
                int result = 1;
                int shift = 0;
                int b;
                do {
                    b = encodedGeometry.charAt(index++) - 63 - 1;
                    result += b << shift;
                    shift += 5;
                } while (b >= 0x1f);
                lat += (result & 1) != 0 ? ~(result >> 1) : (result >> 1);

                result = 1;
                shift = 0;
                do {
                    b = encodedGeometry.charAt(index++) - 63 - 1;
                    result += b << shift;
                    shift += 5;
                } while (b >= 0x1f);
                lng += (result & 1) != 0 ? ~(result >> 1) : (result >> 1);


                if(inclElevation){
                    result = 1;
                    shift = 0;
                    do {
                        b = encodedGeometry.charAt(index++) - 63 - 1;
                        result += b << shift;
                        shift += 5;
                    } while (b >= 0x1f);
                    ele += (result & 1) != 0 ? ~(result >> 1) : (result >> 1);
                }

                ArrayNode location = mapper.createArrayNode();
                    location.add(lat / 1E5);
                    location.add(lng / 1E5);
                    if(inclElevation){
                        location.add((float) (ele / 100));
                    }
                    geometry.add(location);
            }


            List<List<Double>> geomList = new ArrayList<>();
            for(JsonNode n: geometry)
            {
                List<Double> entry = new ArrayList<>();
                entry.add(n.get(0).asDouble());
                entry.add(n.get(1).asDouble());
                entry.add(n.get(2).asDouble());
                geomList.add(entry);
            }
            return geomList;
        }
    }

