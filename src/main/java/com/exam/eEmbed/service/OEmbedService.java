package com.exam.eEmbed.service;

import com.exam.eEmbed.base.Util;
import com.exam.eEmbed.base.handler.DataHandler;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class OEmbedService {
    private final String youtube = "youtube.com";
    private final String twitter = "twitter.com";
    private final String vimeo = "vimeo.com";
    private final DataHandler dataHandler;
    /**
      각 url 마다 oEmbed data 를 json 형태로 값을 받기 위한 처리.
     **/
    public JSONObject urlConnector(String url) {
        try {
            if (url.contains(youtube)) return Util.Handler.youtube(url, dataHandler);
            else if (url.contains(twitter)) return Util.Handler.twitter(url, dataHandler);
            else if (url.contains(vimeo)) return Util.Handler.vimeo(url, dataHandler);
        } catch (NullPointerException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getError();
    }
    /**
        에러가 생겼을 때 해당 에러 창을 뜨게 해주는 함수.
     **/
    private JSONObject getError() {
        JSONObject jsonobj = new JSONObject();
        jsonobj.put("error","error");
        jsonobj.put("msg","지원하지 않거나 정확하지 않은 URL 입니다.");
        return jsonobj;
    }
}
