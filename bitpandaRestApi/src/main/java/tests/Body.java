package tests;

import org.json.simple.JSONObject;

public class Body {

    public static JSONObject createBody(){
        JSONObject body = new JSONObject();
        body.put("name", "Tester");
        body.put("job", "Automation Tester");

        return body;

    }

    public static JSONObject updateBody(){
        JSONObject body = new JSONObject();
        body.put("name", "Tester");
        body.put("job", "Automation Tester");

        return body;

    }


}
