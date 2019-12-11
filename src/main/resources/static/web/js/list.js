var globalCount = 0;
  $(".top").click(function() {
    $('body,html').animate({
      scrollTop : 0
    }, 1000);
    return false;
  });
  var pageNext = 1;
  var count = 1;
  var isEnd = false;
 
  var width = window.innerWidth || document.documentElement.clientWidth;
  if (width < 960) {
    var pagenav = '<p style="text-align:center;margin:-5px auto 20px;"><a href="javascript:void(0);" onclick="initBlog()"><i class="fa fa-arrow-down"></i> 加载更多</a></p>';
    $(".pageMin").html(pagenav);
    $(".tag").css('display', 'none');
  }
  $(window).scroll(function() {
    if (isEnd == true) {
      return;
    }
    if ($(document).scrollTop() > 200 && count == 1) {
      $(".dj").css("display", "block");
      initArticleByClick();//初始化点击排行
      count++;
    }
    
    if ($(document).scrollTop() > 1300 && width > 700) {
      $(".top").addClass('cd-is-visible fadeIn');
      $(".guanzhu").css("display", "block");
    } else {
      $(".top").removeClass('cd-is-visible fadeOut');
      $(".guanzhu").css("display", "none");
    }
    if ($(document).scrollTop() + 50 >= $(document).height() - $(window).height() && width > 700) {
      isEnd = true;
      $('.page').css('display', 'block');
      setTimeout(function() {
        initLatestArticleList(pageNext);
      }, 500);
    }
  });
  var initBlog = function() {
    setTimeout(function() {
      initLatestArticleList(pageNext);
    }, 100);
  };
  
  $(document).ready(function() {
    initColumnList();//初始化栏目类别信息
    initRecommendedArticleList();//初始化推荐文章
    initLatestArticleList(1);//初始化技术博客文章
  });
  
  function initLatestArticleList(pageNum) {
    //设置参数
    var params = {
      pageSize : 8, //每页显示数量
      pageNum : pageNum, //当前页
      deleteStatus:0, //删除状态 0 标识未删除
      topStatus : 1, //1 表示置顶
      releaseStatus : 1, //发布状态 1标识文章已发布
      orderByColumn : "release_time", //排序字段
      isAsc : "DESC" //排序规则
    };
    $.ajax({
      url : '/web/article/getList',
      type : 'get',
      data : params,
      dataType : 'json',
      success : function(data) {
        var blogList = '';
        var total = data.total;//获取文章总数
        var data = data.rows;
        if (data.length > 0) {
          var parm = "";
          var arr = [];
          for (var i = 0; i < data.length; i++) {
            arr[i] = data[i].articleId;
            parm += data[i].articleId + ",";
            var id = data[i].articleId;
            var keyword = "";
            if (data[i].tagId != "" && data[i].tagId != null) {
              if (data[i].tagId.search(';') != -1) {
                keyword = data[i].tagId.replace(/;/g, "|");
              } else {
                keyword = data[i].tagId;
              }
            }
            blogList += '<li style="animation-delay:0.' + i + 's" class="animated fadeInDown"><h3 class="blogtitle"><a target="_blank" href="/web/article/details/' + id + '"  >'
            + data[i].articleTitle
            + '</a></h3><span class="blogpic imgscale"><a href="/web/article/details/' + id + '" title=""><img src="' + data[i].imgPath + '"  /></a></span><p class="blogtext">'
            + data[i].articleAbstract
            + '</p><p class="bloginfo"><i class = "avatar"><img src="images/image_.jpg" border=0 width="30" height="30"></i><span>luotf</span><span><a href="javascript:void(0);">【'
            + keyword
            + '】</a></span><span class="m_time">'
            + Format(data[i].releaseTime, "yyyy-MM-dd")
            + '</span><span  class="clicknum">浏览('
            + data[i].chickNum
            + ')</span><span class="f_r"></p><a href="/web/article/details/' + id + '" class="viewmore">阅读原文</a></span></li>'
          
          }
          var p = {
            client_id : 'cytzg9rLH',
            topic_source_id : parm
          };
          $.ajax({
            url : 'http://changyan.sohu.com/api/2/topic/count',
            type : 'get',
            data : p,
            dataType : 'jsonp',
            success : function(pl) {
              for (var i = 0; i < arr.length; i++) {
                $('.' + arr[i]).html(pl.result[arr[i]].comments);
              }
            },
            error : function() {
              layer.msg('出错啦', {
                icon : 2
              });
            }
          });
        } else {
          blogList = "<h1 style='font-size:110px;text-align:center;margin:20px;'>404</h1><h3 style='text-align:center;' class='font-bold'>抱歉，你所访问的资源不存在~</h3><h4 style='margin-bottom:110px;margin-top:55px;text-align:center;'><a style='background-color: #676a6c;padding: 5px 10px;color: #fff;border-radius: 10px;' href='index.jsp'>去首页</a></h4>";
        }
        if (pageNum >= 2) {
          $(".newblogs").find("ul").append(blogList);
        } else {
          $(".newblogs").find("ul").html(blogList);
        }
        if (total > params.pageSize) {
          var pagenav = '';
          if (pageNum == Math.ceil(total/params.pageSize)) {
            isEnd = true;
            pagenav = '<p style="text-align:center;margin:-5px auto 10px;"><a href="javascript:void(0);" onclick="window.scrollTo(0,0)"><i class="fa fa-arrow-up"></i> 没有更多了</a></p>';
            if (width < 960) {
              $(".pageMin").html(pagenav);
            }
          } else {
            isEnd = false;
            pageNext = pageNum + 1;
            pagenav = '<div style="margin:-5px auto 10px;text-align:center;"><div class="loader-inner ball-pulse"><div></div><div></div><div></div></div></div>';
          }
          $(".page").html(pagenav);
        } else {
          isEnd = true;
          $('.page').css('display', 'block');
          $(".page").html('<p style="text-align:center;margin:-5px auto 10px;"><a href="javascript:void(0);" onclick="window.scrollTo(0,0)"><i class="fa fa-arrow-up"></i> 没有更多了</a></p>');
          if (width < 960) {
            $(".pageMin").html("");
          }
        }
      },
      error : function() {
        layer.msg('请求太快，请稍后再试！', {
          icon : 5
        });
      }
    });
  };

  //初始化所有类别信息
  var initColumnList = function() {
    //查询出文章类别
    //设置参数，表示查询所有的类别
    var params = {
    };
    $.ajax({
      url : '/web/article/getColumnList',
      type : 'post',
      data : params,
      dataType : 'json',
      success : function(data) {
        var typeName = '';
        var data =data.data;
        for (var i = 0; i < data.length; i++) {
          var time = i * 0.03;
          typeName += '<a style="animation-delay:' + time + 's" class="animated fadeIn" onclick="searchType(' + data[i].columnId + ')" href="javascript:void(0);">' + data[i].columnName + '</a> '
        }
        var length = '';
        var keyTitle = '';
        if (data.length > 5) {
          length = 5;
        } else {
          length = data.length;
        }
        for (var i = 0; i < length; i++) {
          keyTitle += '<a href="javascript:void(0);" onclick="searchType(' + data[i].columnId + ')">' + data[i].columnName + '</a>'
        }
  
        // 初始化数据
        $(".cloud").find('ul').html(typeName);
        $(".tagTitle").html(keyTitle);
      },
      error : function() {
        layer.msg('请求太快，请稍后再试！', {
          icon : 5
        });
      }
    });
  };
  
  var searchType = function(type_id, typename) {
    $(".type_id").val(type_id);
    var index = '';
    layer.ready(function() {
      index = layer.load(2, {
        shade : [ 0.1, '#eee' ] //0.1透明度的白色背景
      });
    });
    initLatestArticleList(1);
    setTimeout(function() {
      layer.close(index);
    }, 200);
  
  
  };
  
  //初始化推荐
  var initRecommendedArticleList = function() {
    //设置参数
    var params = {
      pageSize : 5, //每页显示数量
      pageNum : 1, //当前页
      deleteStatus:0, //删除状态 0 标识未删除
      topStatus : 1, //1 表示置顶
      releaseStatus : 1, //发布状态 1标识文章已发布
      orderByColumn : "release_time", //排序字段
      isAsc : "DESC" //排序规则
    };
    $.ajax({
      url : '/web/article/getList',
      type : 'get',
      data : params,
      dataType : 'json',
      success : function(data) {
        var likeBlog_1 = '';
        var likeBlog_2 = '';
        var data = data.rows;
        var time = '';
  
        for (var i = 0; i < data.length; i++) {
          if (data[i].articleTitle.length > 25) {
            data[i].articleTitle = data[i].articleTitle.substring(0, 25) + "...";
          }
          var id = data[i].articleId;
          time = i * 0.03;
          if (i == 1) {
            likeBlog_1 = '<i ><a target="_blank" href="/web/article/details/' + id + '"><img src="' + data[i].imgPath + '"></i><p>' + data[i].articleTitle + '</p></a>'
          } else {
            likeBlog_2 += '<li style="animation-delay:' + time + 's" class="animated fadeIn"> <i><img src="' + data[i].imgPath + '"></i><p><a href="/web/article/details/' + id + '">' + data[i].articleTitle + '</a></p><span>[' + Format(data[i].releaseTime, "yyyy-MM-dd") + ']</span> </li>';
          }
        }
        // 初始化数据
        $(".tuijian2").find(".tjpic").html(likeBlog_1);
        $(".tuijian2").find(".sidenews").html(likeBlog_2);
      },
      error : function() {
        layer.msg('请求太快，请稍后再试！', {
          icon : 5
        });
      }
    });
  };
  
  //初始化点击排行
  var initArticleByClick = function() {
    //设置参数
    var params = {
      pageSize : 9, //每页显示数量
      pageNum : 1, //当前页
      deleteStatus:0, //删除状态 0 标识未删除
      releaseStatus : 1, //发布状态 1标识文章已发布
      orderByColumn : "chick_num", //排序字段
      isAsc : "DESC" //排序规则
    };
    $.ajax({
      url : '/web/article/getList',
      type : 'get',
      data : params,
      dataType : 'json',
      success : function(data) {
        var clickBlog = '';
        var data = data.rows;
  
        for (var i = 0; i < data.length; i++) {
          if (data[i].articleTitle.length > 20) {
            data[i].articleTitle = data[i].articleTitle.substring(0, 20) + "...";
          }
          var id = data[i].articleId;
          time = i * 0.05;
          clickBlog += '<li style="animation-delay:0.' + i + 's" class="animated fadeIn"><i></i><a target="_blank" href="/web/article/details/' + id + '">'
            + data[i].articleTitle
            + '</a></li>'
        }
        // 初始化数据
        $(".dj").find(".click").html(clickBlog);
      },
      error : function() {
        layer.msg('请求太快，请稍后再试！', {
          icon : 5
        });
      }
    });
  };
  
  //格式化时间
  function Format(datetime, fmt) {
    if (parseInt(datetime) == datetime) {
      if (datetime.length == 10) {
        datetime = parseInt(datetime) * 1000;
      } else if (datetime.length == 13) {
        datetime = parseInt(datetime);
      }
    }
    datetime = new Date(datetime);
    var o = {
      "M+" : datetime.getMonth() + 1, //月份   
      "d+" : datetime.getDate(), //日   
      "h+" : datetime.getHours(), //小时   
      "m+" : datetime.getMinutes(), //分   
      "s+" : datetime.getSeconds(), //秒   
      "q+" : Math.floor((datetime.getMonth() + 3) / 3), //季度   
      "S" : datetime.getMilliseconds() //毫秒   
    };
    if (/(y+)/.test(fmt))
      fmt = fmt.replace(RegExp.$1, (datetime.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
      if (new RegExp("(" + k + ")").test(fmt))
        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
  }
