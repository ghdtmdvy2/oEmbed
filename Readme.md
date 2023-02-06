# oEmbed 데이터 수집 서비스 만들기

## 작동 설명서

- Java 17
- gradle
- spring boot

## 구조

- 2계층 - 컨트롤러, 서비스

### **Controller : MainController**

**APIs**

- GET : /
    - oEmbed 데이터를 검색할 수 있는 곳으로 redirect 해주는 곳.
    - Response : /oEmbed/ 로 redirect

### **Controller : OEmbedController**

**APIs**

- GET : /oEmbed/
    - oEmbed 데이터를 검색할 수 있는 곳
    - Response : HTTP 상태 코드 2xx (성공 응답)
- POST : /oEmbed/ `body= {url: String}`
    - oEmbed 데이터를 가져오는 곳
    - Response : 해당 사이트에 oEmbed json

### **Service**

**1) OEmbedService**

OEmbedService는 oEmbed data를 관리를 담당합니다.

### Entities

#### 1. Youtube oEmbed 정보

```java
String author_name; // The name of the author/owner of the resource.
String provider_url; // The url of the resource provider.
String title; // A text title, describing the resource.
String type; // The resource type.
String thumbnail_url; // A URL to a thumbnail image representing the resource. 
String version; // The oEmbed version number. This must be 1.0.
Long thumbnail_height; // The height of the optional thumbnail. 
String author_url; // A URL for the author/owner of the resource.
Long width; // The width in pixels of the image specified in the url parameter.
Long thumbnail_width; // The width of the optional thumbnail.
String html; // The HTML required to embed a video player.
String provider_name; // The name of the resource provider.
Long height; // The height in pixels of the image specified in the url parameter.
```
#### 참고 문헌
- [https://oembed.com/](https://oembed.com/)
  
#### 1. vimeo oEmbed 정보

```java
String author_name; // The name of the author/owner of the resource.
String account_type; // The video owner's membership type on Vimeo.
String thumbnail_url_with_play_button; // For information about the image format of the thumbnail, see our Working with Thumbnail Uploads guide.
String description; // The description of the video.
String provider_url; // The url of the resource provider.
String type; // The resource type.
String title; // A text title, describing the resource.
String thumbnail_url; // A URL to a thumbnail image representing the resource. 
String version; // The oEmbed version number. This must be 1.0.
String uri; // The URI of the video.
Long thumbnail_height; // The height of the optional thumbnail. 
Long duration; // The duration of the video in seconds.
String author_url; // A URL for the author/owner of the resource.
String is_plus; // This field is deprecated.
Long width; // The width in pixels of the image specified in the url parameter.
Long thumbnail_width; // The width of the optional thumbnail.
String html; // The HTML required to embed a video player.
Long height; // The height in pixels of the image specified in the url parameter.
String upload_date; // The date and time when the video was uploaded.
Long video_id; // The ID of the video.
```
#### 참고 문헌
- [https://developer.vimeo.com/api/oembed/videos](https://developer.vimeo.com/api/oembed/videos)
- [https://oembed.com/](https://oembed.com/)

#### twitter oEmbed 정보

```java
String author_name; // The name of the author/owner of the resource.
String author_url; // A URL for the author/owner of the resource.
String cache_age; // The timeline markup is meant to be cached on your servers for up to the suggested cache lifetime specified by the cache_age property.
Long width; // The width in pixels of the image specified in the url parameter.
String html; // The HTML required to embed a video player.
String provider_url; // The url of the resource provider.
String type; // The resource type.
String provider_name;// The name of the resource provider.
String version; // The oEmbed version number. This must be 1.0.
String url; // The URL to retrieve embedding information for.
Long height; // The height in pixels of the image specified in the url parameter.
```
#### 참고 문헌
- [https://developer.twitter.com/en/docs/twitter-for-websites/timelines/guides/oembed-api](https://developer.twitter.com/en/docs/twitter-for-websites/timelines/guides/oembed-api)
- [https://oembed.com/](https://oembed.com/)