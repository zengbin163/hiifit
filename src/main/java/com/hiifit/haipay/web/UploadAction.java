package com.hiifit.haipay.web;

import java.io.File;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.cmcc.common.util.ParamUtil;
import com.google.common.collect.Maps;
import com.hiifit.haipay.enumEntity.ReturnCodeEnum;
import com.hiifit.haipay.util.http.HttpUtils;
import com.hiifit.haipay.util.image.FileCopyUtil;
import com.hiifit.haipay.util.image.ImageCompressUtil;
import com.hiifit.haipay.util.image.ImagePathUtil;

@SuppressWarnings("serial")
@Results({ @Result(name = "index", location = "../../../index.jsp") })
public class UploadAction extends BaseAction {
    Logger logger = LoggerFactory.getLogger(getClass());
    // 要和客户端添加字段时的关键字保持一致！！
    private String imgFileName;
    private File img;
    /**
     * 图片分类 1：头像；2：心情贴;
     */
    private static final int[] types = { 1, 2 };
    
    /**
     * <pre>
     *   上传图片，返回图片路径
     * </pre>
     * @param type（图片类型    1:头像     2:微博图片 ）
     * @param userId（用户id ）
     * @return  图片路径（_R原图     _M缩略图）
     * @throws Exception
     */
    public String upload() throws Exception {
        String filePath = StringUtils.EMPTY, fileType, imgUrl;
        Map<String, Object> rtnMap = Maps.newHashMap();
        // 图片分类
        Integer type = ParamUtil.getIntParameter(request, "type", 0);
        // 用户id
        Integer userId = ParamUtil.getIntParameter(request, "userId", 0);
        // 上传的图片类别不在图片分类列表中
        Assert.isTrue(filterType(type), "图片类型错误");
        // 获取相关路径
        String path = request.getSession().getServletContext().getRealPath("/");
        path = path.substring(0, path.indexOf("/webapps") + 8);
        String typePath = ImagePathUtil.getSavePath(type);
        path = path + ImagePathUtil.PATH_USER_ROOT + "/" + userId + typePath;
        String[] array = imgFileName.split("\\.");
        fileType = array[array.length - 1];
        imgFileName = typePath.substring(1) + "_" + ImagePathUtil.getImageName();
        // 用户上传的是头像 或心情图片
        if (type == ImagePathUtil.USER_HEAD_PHOTO || type == ImagePathUtil.USER_PIC_WEIBO) {
            String orginImgName = imgFileName;
            imgFileName = imgFileName + "_R";// 图片后缀加上_R表示是原图
            // 图片压缩 用户上传的是图片，需要保存三种格式的数据，后缀名分别是：原图(_R)、缩略图(_M)、大图(_L)
            filePath = FileCopyUtil.copyFile(fileType, img, path, imgFileName);
            ImageCompressUtil.compressAndCutPic(img, path + "/", orginImgName + "_M." + fileType,
                200, 200);
        }
        imgUrl = HttpUtils.getServerPath(request)
                 + filePath.substring(filePath.indexOf("/share"), filePath.length());
        // 若用户上传的是头像 或心情图片，则返回的地址是图片名称+"_X"的形式，X代表 M、L、R(缩略图、大图、原图)，用户请求时拼接相应的后缀
        if (type == ImagePathUtil.USER_HEAD_PHOTO || type == ImagePathUtil.USER_PIC_WEIBO) {
            imgUrl = imgUrl.replace("_R", "_X");
        }
        rtnMap.put("path", imgUrl);
        rtnMap.put("msg", ReturnCodeEnum.SUCCESS.getString());
        rtnMap.put("recode", ReturnCodeEnum.SUCCESS.getCode());
        returnSingleFastJSON(rtnMap);
        return null;
    }
    
    /**
     * 图片分类1:头像；2：图片
     * 
     * @param fileType
     * @return
     */
    protected boolean filterType(int fileType) {
        boolean isFileType = false;
        for (int type : types) {
            if (type == fileType) {
                isFileType = true;
                break;
            }
        }
        return isFileType;
    }
    
    public String getImgFileName() {
        return imgFileName;
    }
    
    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }
    
    public File getImg() {
        return img;
    }
    
    public void setImg(File img) {
        this.img = img;
    }
    
    public String uploadIndex() {
        
        return "index";
    }
    
}
