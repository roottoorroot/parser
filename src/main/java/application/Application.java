package application;

import convert.ConvertToJson;
import org.json.JSONObject;
import parser.Parser;
import parser.ParserTxt;
import sending.Send;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws IOException, Exception {

        Parser parser = new ParserTxt();
        ConvertToJson convert = new ConvertToJson();
        Send send = new Send();

        List<Map<String, String>> listMap = parser.parse();

        JSONObject json = convert.convertToJSONobj(listMap);

        send.sendJsonToServer(json);

        int o = 0;

    }
}
