package com.blog.sys.common;

import com.blog.sys.common.base.BaseController;
import com.blog.sys.common.base.ResponseData;
import com.blog.sys.common.config.Global;
import com.blog.sys.common.config.ServerConfig;
import com.blog.sys.common.utils.file.FileUploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: blog
 * @Package: com.yk.blog.common
 * @ClassName: CommonController
 * @Description: 公共controller
 * @Author: yanakai@126.com
 * @CreateDate: 2019/9/26 22:59
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2019/9/26 22:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {

    /**
     * 服务配置类
     */
    @Resource
    private ServerConfig serverConfig;

    @RequestMapping("/upload")
    @ResponseBody
    public ResponseData updateFile(MultipartFile file){
        ResponseData data = operateFailed("上传失败！");
        try {
            //获取上传文件路径
            String fielPath = Global.getUploadPath();
            //上传并返回新的文件名称
            String fileName = FileUploadUtils.upload(fielPath,file);
            //获取新的文件路劲
            String url = serverConfig.getUrl() + fileName;
            Map<String,Object> map = new HashMap<>();
            map.put("fileName", fileName);
            map.put("url", url);
            data = operateSucess("上传成功！");
            data.setData(map);
        }catch (IOException e){
            e.printStackTrace();
        }

        return data;

    }

}
