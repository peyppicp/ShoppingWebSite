package controller.goods;

import common.entity.goods.Image;
import common.entity.goods.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import service.goods.IImageService;
import service.goods.IItemService;
import service.goods.IProductService;
import utils.PrimaryKeyGenerator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/9.
 */
@Controller
//Item关联的图片由advertisement中的图片提供
//Product关联的图片由后台商家上传提供
public class ImageController {

    @Autowired
    private IImageService iImageService;

    @Autowired
    private IProductService iProductService;

    @Autowired
    private IItemService iItemService;

    @RequestMapping(value = "/add-image-product.action", method = RequestMethod.POST)
    public ModelAndView doAddImage(HttpServletRequest request, HttpServletResponse response) {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        String rootPath = request.getServletContext().getRealPath("/");
        String uploadDir = "uploadImage";
        String realDir = rootPath + uploadDir + "\\";
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartRequest = multipartResolver.resolveMultipart(request);
            String itemId = multipartRequest.getParameter("itemId");
            String productId = multipartRequest.getParameter("productId");
//            删除已经存在的产品图片
            Product product = iProductService.getEntity(productId);
            List<Image> imageList = product.getImageList();
            if (imageList != null && imageList.size() != 0) {
                for (Image image1 : imageList) {
                    String image_src = image1.getImage_src();
                    File file = new File(rootPath + image_src);
                    file.delete();
                    iImageService.deleteEntity(image1);
                }
            }
            Iterator<String> inputNames = multipartRequest.getFileNames();
            while (inputNames.hasNext()) {
                String name = inputNames.next();
                MultipartFile file = multipartRequest.getFile(name);
                if (file.getSize() == 0 || file.getOriginalFilename().equals("")) {
                    continue;
                }
                String originalFilename = file.getOriginalFilename();
                String uuid = PrimaryKeyGenerator.uuid();
                String fileName = uuid + "_" + originalFilename;
                String savedFileName = "\\" + uploadDir + "\\" + fileName;
                File realFileDir = new File(realDir);
                if (!realFileDir.exists()) {
                    realFileDir.mkdir();
                }
                File realFile = new File(realFileDir, fileName);
                Image image = new Image();
                image.setImage_id(uuid);
                image.setImage_src(savedFileName);
                image.setProduct(product);
                iImageService.insertEntity(image);
                try {
                    file.transferTo(realFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return new ModelAndView("/WEB-INF/boot-back-index.html");
        }
        return null;
    }
}
