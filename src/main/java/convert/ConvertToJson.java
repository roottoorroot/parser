package convert;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class ConvertToJson {

    private static final Logger log = Logger.getLogger(ConvertToJson.class);

    public JSONObject convertToJSONobj(List<Map<String, String>> maplist) {
        JSONObject jsonObject = new JSONObject();
        try {
            if (maplist.size() != 0) {
                for (int i = 0; i < maplist.size(); i++) {
                    JSONObject tempJson = new JSONObject(maplist.get(i));
                    jsonObject.put("report_" + i, tempJson);
                }
            } else {
                log.error("NULL List of map");
            }
        } catch (Exception e) {
            log.error("error with JSON: " + e.toString());
        }

        return jsonObject;
    }
}
