package kk.controller;

import kk.pojo.Result;
import kk.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ UpLodeController :
 * @ Description:
 */
@Slf4j
@RestController
public class UpLodeController {
@Autowired
public AliOSSUtils aliOSSUtils;
    /**
     * 本地上传
     * @param image  图片
     * @return 成功 返回url
     * @throws Exception 抛
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws Exception {
        log.info("文件上传，文件名：{}",image.getOriginalFilename());
        // 调用 阿里云OSS工具类文件上传
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，url：{}",url);

        return Result.success(url);
    }




    /**
     * 本地上传
     * @param image  图片
     * @return 成功
     * @throws Exception 抛
     */
//    @PostMapping("/upload")
//    public Result upload(MultipartFile image) throws Exception {
//        // 获取源文件名
//        String originalFilename = image.getOriginalFilename();
//        // 构建新的文件名         uuid                                       从 .往后                   最后一个 . 索引
//        String newFileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
//        // 将文件保存在 目录下
//        image.transferTo(new File("D:\\Desktop\\code\\java\\code\\javaweb\\demo\\src\\main\\java\\kk\\pojo\\file\\upload\\" + newFileName));
//        return Result.success();
//    }
}
