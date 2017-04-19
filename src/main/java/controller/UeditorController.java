package controller;

import com.baidu.ueditor.ActionEnter;
import common.entity.goods.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import service.goods.IImageService;
import utils.PrimaryKeyGenerator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by peyppicp on 2017/4/1.
 */
@Controller
public class UeditorController {

    @Autowired
    private IImageService iImageService;

    @RequestMapping(value = "/ue.action")
    public void onUe(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");
            String rootPath = request.getServletContext().getRealPath("/");
            response.getWriter().write(new ActionEnter(request, rootPath).exec());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @RequestMapping(value = "/ue-image-upload.action")
//    public void onImageUpload(HttpServletRequest request, HttpServletResponse response){
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//        String rootPath = request.getServletContext().getRealPath("/");
//        String uploadDir = "uploadImage";
//        String realDir = rootPath + uploadDir + "\\";
//        if(multipartResolver.isMultipart(request)){
//            MultipartHttpServletRequest multipartRequest = multipartResolver.resolveMultipart(request);
//            MultipartFile image = multipartRequest.getFile("upfile");
//            Image image1 = new Image();
//            String uuid = PrimaryKeyGenerator.uuid();
//            File realFileDir = new File(realDir);
//            if (!realFileDir.exists()) {
//                realFileDir.mkdir();
//            }
//            String filename = "";
//            File file = new File(realFileDir, filename);
//        }
//    }
}
