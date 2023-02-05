function search(){
    const url = document.getElementById("search").value;
    $.ajax({
        type: 'POST',
        url: "/oEmbed/search",
        data:{"url":url},
        dataType:'json',
        success:function (data){
            resultHtml(data);
        },
        error:function(error){
            console.log(error);
        }
    })
}
function resultHtml(data) {
    if (data.error==="error"){
        alert(data.msg)
    }
    else if(data.access_url=="youtube") {
        var html ="<table style='width:1000px;'>"
        html += "<div class='div_4'>"
        html += "<div> " + "<span style='background-color:#f4f4f4 '>title</span><span style='font-weight: bold; background-color:#f4f4f4 '>" + data.title + "</span></div>"
        html +=  "<div>" + "<span>type</span><span>" + data.type + "</span></div>"
        html +=  "<div>" + "<span style='background-color:#f4f4f4 '>version</span><span style='background-color:#f4f4f4 '>" + data.version + "</span></div>"
        html +=  "<div>" + "<span>provider_name</span><span>" + data.provider_name + "</span></div>"
        html +=  "<div>" + "<span style='background-color:#f4f4f4'>provider_url</span><span style='background-color:#f4f4f4'>" +"<a href="+ data.provider_url + ">"+data.provider_url+"</a></span></div>"
        html +=  "<div>" + "<span>author_name</span><span>" + data.author_name + "</span></div>"
        html+=  "<div>" + "<span style='background-color:#f4f4f4'>author_url</span><span style='background-color:#f4f4f4'>" +"<a href="+ data.author_url + ">"+data.author_url+"</a></span></div>"
        html+= "<div>" + "<span style='height:200px'>html<br/>(" + data.width + "/" + data.height + ")</span>" +
            "<span style='height:200px;'><xmp>" + data.html + "</xmp>"+ data.html + "</span></div>";
        html +=  "<div>" + "<span style='background-color:#f4f4f4'>width</span><span style='background-color:#f4f4f4'>" + data.width + "</span></div>"
        html +=  "<div>" + "<span>height</span><span>" + data.height + "</span></div>"
        html+="<div>" + "<span style='height: 500px; background-color: #f4f4f4'>thumbnail_url<br/>(" + data.thumbnail_width + "/" + data.thumbnail_height + ")</span><span style='height: 500px; background-color: #f4f4f4'><a href='" +data.thumbnail_url+"'>" + data.thumbnail_url + "</a><br/><br/><img src='"+data.thumbnail_url+"'/></span></div>";
        html +=  "<div>" + "<span>thumbnail_width</span><span>" + data.thumbnail_width + "</span></div>"
        html +=  "<div>" + "<span style='background-color:#f4f4f4 '>thumbnail_height</span><span style='background-color: #f4f4f4'>" + data.thumbnail_height + "</span></div>"
        html+="</div>"
        $("#content").empty();
        $("#content").append(html);
    }
    else if(data.access_url=="twitter"){
        var html ="<table style='width:1000px;'>"
        html += "<div class='div_4'>"
        html +=  "<div>" + "<span>type</span><span>" + data.type + "</span></div>"
        html +=  "<div>" + "<span style='background-color:#f4f4f4 '>version</span><span style='background-color:#f4f4f4 '>" + data.version + "</span></div>"
        html +=  "<div>" + "<span>provider_name</span><span>" + data.provider_name + "</span></div>"
        html +=  "<div>" + "<span style='background-color:#f4f4f4'>provider_url</span><span style='background-color:#f4f4f4'>" +"<a href="+ data.provider_url + ">"+data.provider_url+"</a></span></div>"
        html +=  "<div>" + "<span>author_name</span><span>" + data.author_name + "</span></div>"
        html+=  "<div>" + "<span style='background-color:#f4f4f4'>author_url</span><span style='background-color:#f4f4f4'>" +"<a href="+ data.author_url + ">"+data.author_url+"</a></span></div>"
        html+= "<div>" + "<span style='height:1000px'>html<br/>(" + data.width + "/" + data.height + ")</span>" +
            "<span style='height:1000px;'><xmp style='display: inline-table;'>" + data.html + "</xmp>"+ data.html + "</span></div>";
        html +=  "<div>" + "<span style='background-color:#f4f4f4'>width</span><span style='background-color:#f4f4f4'>" + data.width + "</span></div>"
        html +=  "<div>" + "<span>height</span><span>" + data.height + "</span></div>"
        html +=  "<div>" + "<span style='background-color:#f4f4f4 '>cache_age</span><span style='background-color:#f4f4f4'>" + data.cache_age + "</span></div>"
        html +=  "<div>" + "<span>description</span><span>" + data.description + "</span></div>"
        html+=  "<div>" + "<span style='background-color:#f4f4f4'>url</span><span style='background-color:#f4f4f4'>" +"<a href="+ data.url + ">"+data.url+"</a></span></div>"
        html+="</div>"
        $("#content").empty();
        $("#content").append(html);
    }
    else if(data.access_url=="vimeo"){
        var html ="<table style='width:1000px;'>"
        html += "<div class='div_4'>"
        html += "<div> " + "<span style='background-color:#f4f4f4 '>title</span><span style='font-weight: bold; background-color:#f4f4f4 '>" + data.title + "</span></div>"
        html +=  "<div>" + "<span>type</span><span>" + data.type + "</span></div>"
        html +=  "<div>" + "<span style='background-color:#f4f4f4 '>version</span><span style='background-color:#f4f4f4 '>" + data.version + "</span></div>"
        html +=  "<div>" + "<span>provider_name</span><span>" + data.provider_name + "</span></div>"
        html +=  "<div>" + "<span style='background-color:#f4f4f4'>provider_url</span><span style='background-color:#f4f4f4'>" +"<a href="+ data.provider_url + ">"+data.provider_url+"</a></span></div>"
        html +=  "<div>" + "<span>author_name</span><span>" + data.author_name + "</span></div>"
        html+=  "<div>" + "<span style='background-color:#f4f4f4'>author_url</span><span style='background-color:#f4f4f4'>" +"<a href="+ data.author_url + ">"+data.author_url+"</a></span></div>"
        html+= "<div>" + "<span style='height:700px'>html<br/>(" + data.width + "/" + data.height + ")</span>" +
            "<span style='height:700px;'><xmp>" + data.html + "</xmp>"+ data.html + "</span></div>";
        html +=  "<div>" + "<span style='background-color:#f4f4f4'>width</span><span style='background-color:#f4f4f4'>" + data.width + "</span></div>"
        html +=  "<div>" + "<span>height</span><span>" + data.height + "</span></div>"
        html +=  "<div>" + "<span style='background-color:#f4f4f4 '>duration</span><span style='background-color:#f4f4f4'>" + data.duration + "</span></div>"
        html +=  "<div>" + "<span>description</span><span>" + data.description + "</span></div>"
        html+="<div>" + "<span style='height: 700px; background-color: #f4f4f4'>thumbnail_url<br/>(" + data.thumbnail_width + "/" + data.thumbnail_height + ")</span><span style='height: 700px; background-color: #f4f4f4'><a href='" +data.thumbnail_url+"'>" + data.thumbnail_url + "</a><br/><br/><img src='"+data.thumbnail_url+"'/></span></div>";
        html +=  "<div>" + "<span>thumbnail_width</span><span>" + data.thumbnail_width + "</span></div>"
        html +=  "<div>" + "<span style='background-color:#f4f4f4 '>thumbnail_height</span><span style='background-color: #f4f4f4'>" + data.thumbnail_height + "</span></div>"
        html +=  "<div>" + "<span style='height: 100px;'>thumbnail_url_with_<br/>play_button</span><span style='height: 100px;'>" +"<a href="+ data.thumbnail_url_with_play_button + ">"+data.thumbnail_url_with_play_button+"</a></span></div>"
        html +=  "<div>" + "<span style='background-color:#f4f4f4'>upload_date</span><span style='background-color:#f4f4f4 '>" + data.upload_date + "</span></div>"
        html +=  "<div>" + "<span>video_id</span><span>" + data.video_id + "</span></div>"
        html +=  "<div>" + "<span style='background-color:#f4f4f4 '>uri</span><span style='background-color:#f4f4f4'>" + data.uri + "</span></div>"
        html+="</div>"
        $("#content").empty();
        $("#content").append(html);
    }

}