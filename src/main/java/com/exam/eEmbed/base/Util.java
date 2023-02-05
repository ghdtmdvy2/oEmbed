package com.exam.eEmbed.base;

import com.exam.eEmbed.base.handler.DataHandler;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
public class Util {
    public static class Json {
        /**
            oEmbed 에서 받아온 데이터를 json 형태로 바꿔주는 함수.
        **/
        public static JSONObject parsing(String data, String site) throws ParseException {
            // youtube 의 oEmbed 값에서 html 값이 "가 \"로 안와서 json 파싱하는데 에러가 생김.
            // 그래서 html 값에서 "를 \"로 바꿔주는 곳.
            if (site.equals("youtube")) {
                int htmlFindIndex = data.indexOf("\"html\":\"");
                int htmlLastIndex = htmlFindIndex + "\"html\":\"".length();
                int rightArrowIndex = data.lastIndexOf(">\"");
                int cnt = 0;
                for (int i = htmlLastIndex; i < rightArrowIndex + cnt; i++){
                    if (data.charAt(i) == '\"') {
                        data = data.substring(0,i) + "\\\"" + data.substring( i + 1);
                        cnt++;
                        i++;
                    }
                }
            }
            JSONObject jsonobj;
            JSONParser parser = new JSONParser();
            jsonobj = (JSONObject) parser.parse(data);
            jsonobj.put("access_url",site);
            return jsonobj;
        }
    }
    public static class Handler {
        /**
          각 사이트마다 Oembed 데이터를 받을 수 있는 곳을 알려주는 함수.
         **/
        public static JSONObject youtube(String url, DataHandler dataHandler) throws IOException, ParseException {
            String firstUrl = "https://www.youtube.com/oembed?url=https://youtube.com/";
            String twoUrl = url.split("youtube.com/")[1];
            String data = oEmbedDataUnicodeDecoding(firstUrl,twoUrl,dataHandler);
            return Json.parsing(data,"youtube");
        }
        public static JSONObject twitter(String url, DataHandler dataHandler) throws IOException, ParseException {
            String firstUrl = "https://publish.twitter.com/oembed?url=https://twitter.com/";
            String twoUrl = url.split("twitter.com/")[1];
            String data = oEmbedDataUnicodeDecoding(firstUrl,twoUrl,dataHandler);
            return Json.parsing(data,"twitter");
        }
        public static JSONObject vimeo(String url, DataHandler dataHandler) throws IOException, ParseException {
            String firstUrl = "https://vimeo.com/api/oembed.json?url=https://vimeo.com/";
            String twoUrl = url.split("vimeo.com/")[1];
            String data = oEmbedDataUnicodeDecoding(firstUrl,twoUrl,dataHandler);
            return Json.parsing(data,"vimeo");
        }
        private static String oEmbedDataUnicodeDecoding(String firstUrl, String twoUrl, DataHandler dataHandler) throws IOException {
            String oEmbedDataUrl = firstUrl + twoUrl;
            String data = dataHandler.getData(oEmbedDataUrl);
            return data;
        }
    }
}
