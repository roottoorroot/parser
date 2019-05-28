package parser;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;

public class ParserTxt implements Parser {

    private static final Logger log = Logger.getLogger(parser.ParserTxt.class);


    @Override
    public List<Map<String, String>> parse() throws IOException, Exception {

        ArrayList<String> lines = new ArrayList<String>();
        String line = " ";
        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
        List<Map<String, String>> errorMap = new ArrayList<Map<String, String>>();

        try {
            BufferedReader reader = new BufferedReader( new FileReader("test/agbank_report.txt"));

            while ((line = reader.readLine()) != null) {
                lines.add(line.replaceAll("[\\s]{2,}", " "));
            }

            for (int i = 2; i < lines.size(); i++) {
                String[] temp = lines.get(i).split(" ");
                String[] temp_key = lines.get(0).split(" ");

                Map<String, String> map = new HashMap<String, String>();

                for (int j = 0; j < temp_key.length; j++) {
                    String key = temp_key[j];
                    String value = temp[j];

                    map.put(key, value);
                }

                listMap.add(map);
            }
        } catch (Exception ex) {
            log.error(ex.toString());
        }

        return listMap;
    }

}
