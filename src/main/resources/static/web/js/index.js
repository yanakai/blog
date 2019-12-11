/**
 *
 */
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
var time = null;
var width = window.innerWidth || document.documentElement.clientWidth;
if (width < 660) {
  var pagenav = '<p style="text-align:center;margin:-5px auto 20px;"><a href="javascript:void(0);" onclick="initBlogByClickMore()"><i class="fa fa-arrow-down"></i> 加载更多</a></p>';
  $(".pageMin").html(pagenav);
}

function init() {
  //实现弹出广告的效果
  //1.设置定时效果
  time = setInterval("showAd()", 12000);
}
//2.书写显示广告图片的函数
function showAd() {
  /*//3.获取广告图片的位置
  var adEle = document.getElementById("image2");
  //4.修改广告图片元素里面的属性让其显示
  adEle.style.display = "block";*/
  showAdToGitEE();
  //5.清除显示图片的定时操作
  clearInterval(time);
//6.设置隐藏图片的定时操作
//time = setInterval("hiddenAd()", 3000);
}

/*//7.书写隐藏广告图片的函数
function hiddenAd() {
  //8.获取广告图片并设置其style属性的display值为none
  document.getElementById("image2").style.display = "none";
  //9.清除隐藏广告图片的定时操作
  clearInterval(time);
}*/

function showAdToGitEE() {
  swal({
    title : '前往开源地址 :)',
    text : '此系统已在gitee/github上开源,将全面介绍此系统的管理端,技术栈;如果您觉得不错，欢迎前往gitee上 【Star，Fork】 ',
    type : 'info',
    showCancelButton : true,
    confirmButtonColor : "#1c84c6",
    confirmButtonText : "前往",
    cancelButtonText : "取消",
    timer:8000,
    closeOnConfirm : false,
    closeOnCancel: false
  }, function(isConfirm) {
    if (isConfirm) {
      window.open("https://gitee.com/yanakai/blog.git");
      swal.close()
    } else {
      swal({
        title:"确定不去看看吗？", 
        text:"你的访问就是对博主最大的支持，谢谢 ^-^", 
        type:"info",
        confirmButtonColor : "#1c84c6",
        showCancelButton : true,
        confirmButtonText : "前往",
        cancelButtonText : "取消",
        },function(isConfirm){
          if (isConfirm) {
            window.open("https://gitee.com/yanakai/blog.git");
          }
          swal.close()
      });
    }
  });
}

$(window).scroll(
  function() {
    if (isEnd == true) {
      return;
    }
    if ($(document).scrollTop() > 110 && count == 1) {
      //$(".dj").css("display", "block");
      //initBlogByClick(); //初始化点击排行5篇文章
      count++;
    }
    if ($(document).scrollTop() > 350 && count == 2) {
      $(".newblogs").css("display", "block");
      initLatestArticleList(1); //初始化最新5篇文章
      count++;
    }
    if ($(document).scrollTop() > 450 && count == 3) {
      $(".git").css("display", "block");
      count++;
    }
    if ($(document).scrollTop() > 570 && count == 4) {
      $(".weixin").css("display", "block");
      count++;
    }
    if ($(document).scrollTop() > 750 && count == 5) {
      $(".link").css("display", "block");
      initAllLinks(); //初始化所有已上架友链
      count++;
    }
    if ($(document).scrollTop() > 1050 && width > 700) {
      $(".top").addClass('cd-is-visible fadeIn');
    } else {
      $(".top").removeClass('cd-is-visible fadeOut');
    }
    if ($(document).scrollTop() > 2200 && width > 700) {
      $(".guanzhu").css("display", "block");
    } else {
      $(".guanzhu").css("display", "none");
    }
    if ($(document).scrollTop() + 100 >= $(document).height()- $(window).height()&& width > 700) {
      isEnd = true;
      $('.page').css('display', 'block');
      setTimeout(function() {
        initLatestArticleList(pageNext);
      }, 500);
    } else {
      $('.page').css('display', 'none');
    }
  });
//初始化数据
$(document).ready(function() {
  initTopArticleList(); //初始化置顶5文章
  initArticleListByHotColumn(); //初始化热点栏目的文章每个栏目最多显示7篇文章
  initRecommendedArticleList(); //初始化特别推荐6篇文章
  initArticleByClick(); //初始化点击排行5篇文章
  init();
});

function initBlogByClickMore() {
  setTimeout(function() {
    initLatestArticleList(pageNext);
  }, 200);
};

function returnAllCount() {
  if (globalCount == 2) {
    setTimeout(function() {
      $('article').css('opacity', '1');
    }, 200);
  }
};

function initTopArticleList() {
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
      var topBlog = '';
      var data = data.data;
      for (var i = 0; i < data.length; i++) {
        topBlog += '<li><a href="/web/article/details/' + data[i].articleId + '" title=' + data[i].articleTitle + ' target="_blank">' + data[i].articleTitle + '</a></li>';
      }
      // 初始化数据
      $(".notice").find("ul").html(topBlog);
      globalCount++;
      returnAllCount();
    },
    error : function() {
      layer.msg('请求太快，请稍后再试！', {
        icon : 5
      });
    }
  });
};


//查询热点栏目的文章
function initArticleListByHotColumn() {
  $.ajax({
    url : '/web/article/getArticleListByHotColumn',
    type : 'get',
    dataType : 'json',
    success : function(data) {
      var data = data.data;
      var tab_button = "";
      var newsitem = "";
      var indexTab = 0;
      for (var type in data) {
        if (indexTab == 0) {
          tab_button += "<li class='newscurrent'>" + type + "</li>"
        } else {
          tab_button += "<li>" + type + "</li>"
        }
        indexTab++;
      }
      $(".tab_buttons ul").html(tab_button);
      var index = 0;
      for (var type in data) {
        var newspic = "";
        var newslist = "";
        if (index == 0) {
          newsitem += "<div class='newsitem' style='display: block;'><div class='newspic'><ul>";
        } else {
          newsitem += "<div class='newsitem' style='display: none;'><div class='newspic'><ul>";
        }
        index++;
        newslist += "<ul class='newslist'>";
        for (var i = 0; i < data[type].length; i++) {
          var id = data[type][i].articleId;
          if (i < 2) {
            newspic += "<li><a href=\"/web/article/details/" + id + "\" target='_blank'><img src=" + data[type][i].imgPath + "> <span>" + data[type][i].articleTitle + "</span></a></li>";
          }
          if (i >= 1) {
            newslist += "<li><i></i><a href=/web/article/details/" + id + " target='_blank'>" + data[type][i].articleTitle + "<p>" + data[type][i].articleAbstract + "</p></a></li>";
          }
        }
        newspic += "</ul></div>";
        newsitem += newspic;
        newsitem += newslist;
        newsitem += "</ul></div>"
      }
      $('.newstab').html(newsitem);
    },
    error : function() {
      layer.msg('请求太快，请稍后再试！', {
        icon : 5
      });
    }
  });
};


//初始化推荐
function initRecommendedArticleList() {
  //设置参数
  var params = {
    pageSize : 6, //每页显示数量
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
      var likeBlog = '';
      var data = data.data;
      for (var i = 0; i < data.length; i++) {
        var id = data[i].articleId;
        var time = i * 0.05;
        likeBlog += '<li style="animation-delay:0.' + i + 's" class="animated fadeIn"><i class="ztpic"><a target="_blank" href="/web/article/details/' + id + '" ><img src="' + data[i].imgPath + '"></a></i><b>'
          + data[i].articleTitle
          + '</b><span>'
          + data[i].articleAbstract
          + '</span><a href="/web/article/details/' + id + '" target="_blank" class="readmore">阅读原文</a></li>'
      }
      // 初始化数据
      $(".zhuanti").find("ul").html(likeBlog);
      globalCount++;
      returnAllCount();
    },
    error : function() {
      layer.msg('请求太快，请稍后再试！', {
        icon : 5
      });
    }
  });
};

//初始化最新文章
function initLatestArticleList(page) {
  //设置参数
  var params = {
    pageSize : 5, //每页显示数量
    pageNum : page, //当前页
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
        var newBlog = '';
        var parm = "";
        var arr = [];
        var data = data.data;
        for (var i = 0; i < data.length; i++) {
          arr[i] = data[i].articleId;
          parm += data[i].articleId + ",";
          var id = data[i].articleId;
          var keyword = "";
          if (data[i].tagId != ""&& data[i].tagId != null) {
            if (data[i].tagId.search(';') != -1) {
              keyword = data[i].tagId.replace(/;/g,
                "|");
            } else {
              keyword = data[i].tagId;
            }
          }
          newBlog += '<li style="animation-delay:0.' + i + 's" class="animated fadeInDown"><h3 class="blogtitle"><a target="_blank" href="/web/article/details/' + id + '"  >'
            + data[i].articleTitle
            + '</a></h3><span class="blogpic imgscale"><a href="/web/article/details/' + id + '.html" title=""><img src="' + data[i].imgPath + '"  /></a></span><p class="blogtext">'
            + data[i].articleAbstract
            + '</p><p class="bloginfo"><i class = "avatar"><img src="images/image_.jpg" border=0 width="30" height="30"></i><span>luotf</span><span><a href="javascript:void(0);">【'
            + keyword
            + '】</a></span><span class="m_time">'
            + Format(data[i].releaseTime, "yyyy-MM-dd")
            + '</span><span  class="clicknum">浏览('
            + data[i].chickNum
            + ')</span><span class="f_r"></p><a href="/web/article/details/' + id + '.html" class="viewmore">阅读原文</a></span></li>'
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
        // 初始化数据
        if (page.pageNum >= 2) {
          $(".newblogs").find("ul").append(newBlog);
        } else {
          $(".newblogs").find("ul").html(newBlog);
        }
        if (page.total > 5) {
          var pagenav = '';
          if (page.pageNum == page.pages) {
            isEnd = true;
            pagenav = '<p style="text-align:center;margin:-5px auto 10px;"><a href="javascript:void(0);" onclick="window.scrollTo(0,0)"><i class="fa fa-arrow-up"></i> 没有更多了</a></p>';
            if (width < 660) {
              $(".pageMin").html(pagenav);
            }
          } else {
            isEnd = false;
            pageNext = page.pageNum + 1;
            pagenav = '<div style="margin:-5px auto 10px;text-align:center;"><div class="loader-inner ball-pulse"><div></div><div></div><div></div></div></div>';
          }
          $(".page").html(pagenav);
        } else {
          $(".page").html("");
        }

      },
      error : function() {
        layer.msg('请求太快，请稍后再试！', {
          icon : 5
        });
      }
    });
};

//初始化点击排行
function initArticleByClick() {
  //设置参数
  var params = {
    pageSize : 6, //每页显示数量
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
        var data = data.data;
        var time = '';
        for (var i = 0; i < data.length; i++) {
          var id = data[i].articleId;
          time = i * 0.05;
          clickBlog += '<li style="animation-delay:0.' + i + 's" class="animated fadeIn"><b><a target="_blank" href="/web/article/details/' + id + '">'
              + data[i].articleTitle
              + '</a></b><p><i><img src="' + data[i].imgPath + '"></i><span>'
              + data[i].articleAbstract + '</span></p></li>'
        }
        // 初始化数据
        $(".paihang").find("ul").html(clickBlog);
      },
      error : function() {
        layer.msg('请求太快，请稍后再试！', {
          icon : 5
        });
      }
    });
};

function initAllLinks() {
  $.ajax({
    url : '',
    type : 'get',
    data : "",
    dataType : 'json',
    success : function(data) {
      var linksAll = '';
      var data = data.linksList;
      var time = '';
      for (var i = 0; i < data.length; i++) {
        time = i * 0.05;
        linksAll += '<li style="animation-delay:0.'
          + i
          + 's;float:left;margin: 0 1% 10px 0;padding:3px;" class="animated fadeIn"><a target="_blank" href="'
          + data[i].link
          + '" target= "_blank" onclick="clickNum('
          + data[i].id + ')">' + data[i].name
          + '</a></li>';
      }
      // 初始化数据
      $(".link").find("ul").html(linksAll);
      time = time + 0.1;
      var msg = '<h5 style="animation-delay:' + time + 's" class="animated fadeIn" title="QQ:849673404">注：添加友链,请点击&nbsp;&nbsp;&nbsp;<a class="applyLinks" onclick="applyLinks()" href="javascript:void(0);" style="font-size:13px;color:#f8ac59">申请友链</a></h5>';
      $(".msg").find("a").html(msg);
    },
    error : function() {
      layer.msg('请求太快，请稍后再试！', {
        icon : 5
      });
    }
  });
};

function applyLinks() {
  swal({
    title : '互换友链',
    text : '注意：请在您的网站友链处添加本站链接后再行申请！！！！！！添加格式如下：名称&网站首页地址',
    type : 'input',
    showCancelButton : true,
    confirmButtonColor : "#1c84c6",
    confirmButtonText : "提交",
    closeOnConfirm : false
  }, function() {
    checkLinks();
  });
};

function checkLinks() {
  var inputLink = [];
  inputLink = $("fieldset").find("input").val().split("&");
  var title = '';
  var text = '';
  var type = '';
  if (inputLink.length != 2) {
    title = '格式错误',
    text = '请检查格式是否正确',
    type = 'error'
  } else {
    title = '请核对信息',
    text = '名称：' + inputLink[0].replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, "&quot;").replace(/'/g, "&#039;") + "   。" + '链接：' + inputLink[1].replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, "&quot;").replace(/'/g, "&#039;"),
    type = 'warning'
  }
  swal({
    title : title,
    text : text,
    type : type,
    showCancelButton : true,
    confirmButtonColor : "#1c84c6",
    confirmButtonText : "确定",
    closeOnConfirm : false
  }, function() {
    if (type == 'warning') {
      addLinks(inputLink[0], inputLink[1]);
    }
  });
};
function addLinks(name, link) {
  var params = {
    name : name,
    link : link,
    sort : 0,
    isapply : -1,
    prarm : '有新伙伴申请友链啦！',
  };
  $.ajax({
    url : '',
    type : 'post',
    data : params,
    dataType : 'json',
    success : function(data) {
      if (data.status == 200) {
        swal("申请成功", "等待管理审核", "success");
      }
    },
    error : function() {
      swal("申请失败", "请检查格式是否正确", "error");
    }
  });
};


//更新链接点击次数
function clickNum(id) {
  var params = {
    id : id,
  };
  $.ajax({
    url : '',
    type : 'post',
    data : params,
    dataType : 'json',
    success : function(data) {},
    error : function() {}
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
    "S" : datetime.getMilliseconds()
  //毫秒   
  };
  if (/(y+)/.test(fmt))
    fmt = fmt.replace(RegExp.$1, (datetime.getFullYear() + "")
      .substr(4 - RegExp.$1.length));
  for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt))
      fmt = fmt.replace(RegExp.$1,
        (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
          .substr(("" + o[k]).length)));
  return fmt;
}