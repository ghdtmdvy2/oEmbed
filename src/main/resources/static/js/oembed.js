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

    var html ="<table style='width:1000px;'>"
    html += "<div class='div_4'>"
    if (data.error==="error"){
        alert(data.msg)
        return;
    }
    else if(data.access_url=="youtube") {
        $.each(data, function(key, value){
            if (key === "access_url") {
                return true;
            }
            else if (key === "html") {
                html+= "<div>" + "<span style='height:200px'>html<br/>(" + data.width + "/" + data.height + ")</span>" +
                    "<span style='height:200px;'><xmp>" + data.html + "</xmp>"+ data.html + "</span></div>";
            } else if (key === "thumbnail_url"){
                html+="<div>" + "<span style='height: 500px;'>thumbnail_url<br/>(" + data.thumbnail_width + "/" + data.thumbnail_height + ")</span><span style='height: 500px;'><a href='" +data.thumbnail_url+"'>" + data.thumbnail_url + "</a><br/><br/><img src='"+data.thumbnail_url+"'/></span></div>";
            } else if (key === "author_url" || key === "provider_url"){
                html +=  "<div>" + "<span>" + key + "</span><span>" +"<a href="+ value + ">"+value+"</a></span></div>"
            }else {
                html += "<div> " + "<span>"+ key +"</span><span style='font-weight: bold;'>" + value + "</span></div>"
            }
        });
    }
    else if(data.access_url=="twitter"){
        $.each(data, function(key, value){
            if (key === "html") {
                html+= "<div>" + "<span style='height:1500px'>html<br/>(" + data.width + "/" + data.height + ")</span>" +
                    "<span style='height:1500px;'><xmp style='display: inline-table;'>" + data.html + "</xmp>"+ data.html + "</span></div>";
            } else if (key === "thumbnail_url"){
                html+="<div>" + "<span style='height: "+data.thumbnail_height+"px; margin-bottom: 30'>thumbnail_url<br/>(" + data.thumbnail_width + "/" + data.thumbnail_height + ")</span><span style='height: "+data.thumbnail_height+"px; margin-bottom: 30'><a href='" +data.thumbnail_url+"'>" + data.thumbnail_url + "</a><br/><br/><img src='"+data.thumbnail_url+"'/></span></div>";
            } else if (key === "author_url" || key === "provider_url" || key === "url"){
                html +=  "<div>" + "<span>" + key + "</span><span>" +"<a href="+ value + ">"+value+"</a></span></div>"
            }else {
                html += "<div> " + "<span>"+ key +"</span><span style='font-weight: bold;'>" + value + "</span></div>"
            }
        });
    }
    else if(data.access_url=="vimeo"){
        $.each(data, function(key, value){
            if (key === "html") {
                html+= "<div>" + "<span style='height:"+data.height+"px; margin-bottom: 75'>html<br/>(" + data.width + "/" + data.height + ")</span>" +
                    "<span style='height:"+data.height+"px; margin-bottom: 75'><xmp>" + data.html + "</xmp>"+ data.html + "</span></div>";
            } else if (key === "thumbnail_url"){
                html+="<div>" + "<span style='height: 500px;'>thumbnail_url<br/>(" + data.thumbnail_width + "/" + data.thumbnail_height + ")</span><span style='height: 500px;'><a href='" +data.thumbnail_url+"'>" + data.thumbnail_url + "</a><br/><br/><img src='"+data.thumbnail_url+"'/></span></div>";
            } else if (key === "author_url" || key === "provider_url"){
                html +=  "<div>" + "<span>" + key + "</span><span>" +"<a href="+ value + ">"+value+"</a></span></div>"
            } else if (key === "thumbnail_url_with_play_button"){
                html +=  "<div>" + "<span style='height: 100px;'>thumbnail_url_with_<br/>play_button</span><span style='height: 100px;'>" +"<a href="+ data.thumbnail_url_with_play_button + ">"+data.thumbnail_url_with_play_button+"</a></span></div>"
            } else {
                html += "<div> " + "<span>"+ key +"</span><span style='font-weight: bold;'>" + value + "</span></div>"
            }
        });
    }
    html+="</div>"
    $("#content").empty();
    $("#content").append(html);
}