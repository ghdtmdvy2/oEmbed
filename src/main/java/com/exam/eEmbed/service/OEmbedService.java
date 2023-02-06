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
    private final String youtube = "youtube.com/";
    private final String youtubeOEmbedUrl = "https://www.youtube.com/oembed?url=https://youtube.com/";
    private final String twitter = "twitter.com/";
    private final String twitterOEmbedUrl = "https://publish.twitter.com/oembed?url=https://twitter.com/";
    private final String vimeo = "vimeo.com/";
    private final String vimeoOEmbedUrl = "https://vimeo.com/api/oembed.json?url=https://vimeo.com/";
    private final DataHandler dataHandler;
    /**
        각 url 마다 oEmbed data 를 요청
     **/
    public JSONObject findOEmbedData(String url) {
        try {
            if (url.contains(youtube)) return Util.Handler.convertOEmbedDataIntoJson(url, youtubeOEmbedUrl ,youtube,dataHandler);
            else if (url.contains(twitter)) return Util.Handler.convertOEmbedDataIntoJson(url,twitterOEmbedUrl,twitter, dataHandler);
            else if (url.contains(vimeo)) return Util.Handler.convertOEmbedDataIntoJson(url,vimeoOEmbedUrl,vimeo, dataHandler);
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
        에러가 생겼을 때 해당 에러 창을 json 형태로 만들어주기.
     **/
    private JSONObject getError() {
        JSONObject jsonobj = new JSONObject();
        jsonobj.put("error","error");
        jsonobj.put("msg","지원하지 않거나 정확하지 않은 URL 입니다.");
        return jsonobj;
    }
}
