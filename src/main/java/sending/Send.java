package sending;

import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class Send {

    private static final Logger log = Logger.getLogger(Send.class);

    public void sendJsonToServer(JSONObject jsonObj) throws Exception {

        String url = "http://localhost:8000/";

        URL obj = new URL(url);
        //HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        URLConnection con = obj.openConnection();

        //add request header
        con.setConnectTimeout(60000);
        con.setRequestProperty("Method", "POST");
        con.setRequestProperty("Content-Type", "text/json");

        String urlParameters = jsonObj.toString();

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        //int responseCode = con.getResponseCode();
        log.info("\nSending 'POST' request to URL : " + url);
        log.info("Post parameters : " + urlParameters);
        //log.info("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        log.info(response.toString());
    }
}
