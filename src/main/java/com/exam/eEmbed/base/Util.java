package com.exam.eEmbed.base;

import com.exam.eEmbed.base.handler.DataHandler;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
public class Util {
    public static class Json {
        /**
            data 를 json 형태로 바꿔주는 함수.
        **/
        public static JSONObject parse(String data, String site) throws ParseException {
            JSONObject jsonobj;
            JSONParser parser = new JSONParser();
            jsonobj = (JSONObject) parser.parse(data);
            jsonobj.put("access_url",site);
            return jsonobj;
        }
    }
    public static class Handler {
        /**
            각 사이트마다 oEmbed 데이터를 json 형태로 반환하는 함수.
         **/
        public static JSONObject convertOEmbedDataIntoJson(String url, String oEmbedUrl, String site, DataHandler dataHandler) throws IOException, ParseException {
            String parameter = url.split(site)[1];
            String oEmbedDataUrl = oEmbedUrl + parameter;
            String data = dataHandler.oEmbedUrlGetData(oEmbedDataUrl);
            data = Handler.makeEasyProcessJson(data,site);
            JSONObject jsonData = Json.parse(data,site);
            return jsonData;
        }
        /**
            json 형태로 가공하기 쉽게 형태를 바꿔주는 함수.
         **/
        private static String makeEasyProcessJson(String data, String site) {
            // youtube 의 oEmbed 값에서 html 값이 "가 \"로 안와서 json 으로 파싱하는데 에러가 생김.
            // 그래서 html 값에서 "를 \"로 바꿔주는 곳.
            if (site.equals("youtube.com/")) {
                String [] key = new String[]{"\"title\"", "\"author_name\"", "html"};
                for(int i=0; i<key.length; i+=2){
                    if(i== key.length-1){
                        int htmlFindIndex = data.indexOf("\"html\":\"");
                        int htmlLastIndex = htmlFindIndex + "\"html\":\"".length();
                        int rightArrowIndex = data.lastIndexOf(">\"");
                        data = organizeQuote(data, htmlLastIndex, rightArrowIndex);
                    }
                    else {
                        int titleFindIndex = data.indexOf(key[i]);
                        int titleLastIndex = titleFindIndex + "title".length() + 4;
                        int authorNameIndex = data.indexOf(key[i+1])-2;
                        data = organizeQuote(data, titleLastIndex, authorNameIndex);
                    }

                }

            }
            return data;
        }
        // "를 \"로 바꿔주는 함수
        private static String organizeQuote(String data, int titleLastIndex, int authorNameIndex) {
            int cnt = 0;
            for (int j = titleLastIndex; j < authorNameIndex + cnt; j++){
                if (data.charAt(j) == '\"') {
                    data = data.substring(0,j) + "\\\"" + data.substring( j + 1);
                    cnt++;
                    j++;
                }
            }
            return data;
        }
    }
}
