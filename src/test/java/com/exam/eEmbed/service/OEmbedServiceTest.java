package com.exam.eEmbed.service;

import com.exam.eEmbed.OEmbedTaskApplication;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = OEmbedTaskApplication.class)
class OEmbedServiceTest {
    @Autowired
    OEmbedService oEmbedService;

    @Test
    @DisplayName("vimeo oEmbed data 요청")
    void vimeoFindOEmbedData() {
        // Given
        final String vimeoUrl = "https://vimeo.com/20097015";
        // when
        JSONObject vimeoOEmbedJsonData = oEmbedService.findOEmbedData(vimeoUrl);
        // then
        assertThat(vimeoOEmbedJsonData.get("author_name").equals("Depict_tk")).isTrue();
        assertThat(vimeoOEmbedJsonData.get("account_type").equals("basic")).isTrue();
        assertThat(vimeoOEmbedJsonData.get("thumbnail_url_with_play_button").equals("https://i.vimeocdn.com/filter/overlay?src0=https%3A%2F%2Fi.vimeocdn.com%2Fvideo%2F128068226-3e88e664fc0805498112c738d3a44fe6319a6385f63e3a2af526b35440a15ed5-d_640&src1=http%3A%2F%2Ff.vimeocdn.com%2Fp%2Fimages%2Fcrawler_play.png")).isTrue();
        assertThat(vimeoOEmbedJsonData.get("access_url").equals("vimeo.com/")).isTrue();
        assertThat(vimeoOEmbedJsonData.get("description").equals("concepts: playzoo\n" +
                "codes: purpleworks\n" +
                "\n" +
                "openFrameworks (Linux) / Logitech HD webcam / Turntable")).isTrue();
        assertThat(vimeoOEmbedJsonData.get("provider_url").equals("https://vimeo.com/")).isTrue();
        assertThat(vimeoOEmbedJsonData.get("type").equals("video")).isTrue();
        assertThat(vimeoOEmbedJsonData.get("thumbnail_height").equals(480L)).isTrue();
        assertThat(vimeoOEmbedJsonData.get("duration").equals(314L)).isTrue();
        assertThat(vimeoOEmbedJsonData.get("author_url").equals("https://vimeo.com/user5346842")).isTrue();
        assertThat(vimeoOEmbedJsonData.get("is_plus").equals("0")).isTrue();
        assertThat(vimeoOEmbedJsonData.get("width").equals(640L)).isTrue();
        assertThat(vimeoOEmbedJsonData.get("thumbnail_width").equals(640L)).isTrue();
        assertThat(vimeoOEmbedJsonData.get("html").equals("<iframe src=\"https://player.vimeo.com/video/20097015?h=08095da358&amp;app_id=122963\" width=\"640\" height=\"480\" frameborder=\"0\" allow=\"autoplay; fullscreen; picture-in-picture\" allowfullscreen title=\"A Time Artifact - work in progress\"></iframe>")).isTrue();
        assertThat(vimeoOEmbedJsonData.get("provider_name").equals("Vimeo")).isTrue();
        assertThat(vimeoOEmbedJsonData.get("height").equals(480L)).isTrue();
        assertThat(vimeoOEmbedJsonData.get("upload_date").equals("2011-02-18 05:31:51")).isTrue();
        assertThat(vimeoOEmbedJsonData.get("video_id").equals(20097015L)).isTrue();
    }
    @Test
    @DisplayName("youtube oEmbed data 요청")
    void youtubeFindOEmbedData() {
        // Given
        final String youtubeUrl = "https://www.youtube.com/watch?v=dBD54EZIrZo";
        // when
        JSONObject youtubeOEmbedJsonData = oEmbedService.findOEmbedData(youtubeUrl);
        // then
        assertThat(youtubeOEmbedJsonData.get("author_name").equals("핑크퐁 (인기 동요・동화)")).isTrue();
        assertThat(youtubeOEmbedJsonData.get("access_url").equals("youtube.com/")).isTrue();
        assertThat(youtubeOEmbedJsonData.get("title").equals("언제 어디서나! 핑크퐁 BEST 모음 80분 | 차에서 듣는 동요 | 아기상어, 상어가족 외 70곡 | + 모음집 | 핑크퐁! 인기동요")).isTrue();
        assertThat(youtubeOEmbedJsonData.get("type").equals("video")).isTrue();
        assertThat(youtubeOEmbedJsonData.get("thumbnail_url").equals("https://i.ytimg.com/vi/dBD54EZIrZo/hqdefault.jpg")).isTrue();
        assertThat(youtubeOEmbedJsonData.get("version").equals("1.0")).isTrue();
        assertThat(youtubeOEmbedJsonData.get("thumbnail_height").equals(360L)).isTrue();
        assertThat(youtubeOEmbedJsonData.get("html").equals("<iframe width=\"200\" height=\"113\" src=\"https://www.youtube.com/embed/dBD54EZIrZo?feature=oembed\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen title=\"언제 어디서나! 핑크퐁 BEST 모음 80분 | 차에서 듣는 동요 | 아기상어, 상어가족 외 70곡 | + 모음집 | 핑크퐁! 인기동요\"></iframe>")).isTrue();
        assertThat(youtubeOEmbedJsonData.get("width").equals(200L)).isTrue();
        assertThat(youtubeOEmbedJsonData.get("thumbnail_width").equals(480L)).isTrue();
        assertThat(youtubeOEmbedJsonData.get("provider_name").equals("YouTube")).isTrue();
        assertThat(youtubeOEmbedJsonData.get("height").equals(113L)).isTrue();
    }
    @Test
    @DisplayName("twitter oEmbed data 요청")
    void twitterFindOEmbedData() {
        // Given
        final String twitterUrl = "https://twitter.com/hellopolicy/status/867177144815804416";
        // when
        JSONObject twitterOEmbedJsonData = oEmbedService.findOEmbedData(twitterUrl);
        // then
        assertThat(twitterOEmbedJsonData.get("author_name").equals("대한민국 정부")).isTrue();
        assertThat(twitterOEmbedJsonData.get("author_url").equals("https://twitter.com/hellopolicy")).isTrue();
        assertThat(twitterOEmbedJsonData.get("cache_age").equals("3153600000")).isTrue();
        assertThat(twitterOEmbedJsonData.get("access_url").equals("twitter.com/")).isTrue();
        assertThat(twitterOEmbedJsonData.get("width").equals(550L)).isTrue();
        assertThat(twitterOEmbedJsonData.get("html").equals("""
                <blockquote class="twitter-tweet"><p lang="ko" dir="ltr">정책요정 폴리씨가 정부 정책을 알기 쉽고 공감할 수 있게 소개해드립니다! 대한민국 정부 대표 채널 &#39;폴리씨&#39; 국민여러분과 소통할 수 있도록 더욱 노력하겠습니다. <a href="https://t.co/eXKCjQIFJ2">pic.twitter.com/eXKCjQIFJ2</a></p>&mdash; 대한민국 정부 (@hellopolicy) <a href="https://twitter.com/hellopolicy/status/867177144815804416?ref_src=twsrc%5Etfw">May 24, 2017</a></blockquote>
                <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
                """)).isTrue();
        assertThat(twitterOEmbedJsonData.get("provider_url").equals("https://twitter.com")).isTrue();
        assertThat(twitterOEmbedJsonData.get("type").equals("rich")).isTrue();
        assertThat(twitterOEmbedJsonData.get("provider_name").equals("Twitter")).isTrue();
        assertThat(twitterOEmbedJsonData.get("version").equals("1.0")).isTrue();
        assertThat(twitterOEmbedJsonData.get("url").equals("https://twitter.com/hellopolicy/status/867177144815804416")).isTrue();
        assertThat(twitterOEmbedJsonData.get("height")).isNull();
    }
    @Test
        @DisplayName("유효하지 않은 URL oEmbed data 요청")
    void InvalidURLFindOEmbedData() {
        // Given
        final String youtubeUrl = "https://Invalid.com/";
        // when
        JSONObject jsonObject = oEmbedService.findOEmbedData(youtubeUrl);
        // then
        assertThat(jsonObject.get("error").equals("error")).isTrue();
        assertThat(jsonObject.get("msg").equals("지원하지 않거나 정확하지 않은 URL 입니다.")).isTrue();
    }
}