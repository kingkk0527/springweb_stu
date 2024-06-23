package kk.controller;

import kk.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @ UpLodeController :
 * @ Description:
 */

@RestController
public class UpLodeController {
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws Exception {
        // 获取源文件名
        String originalFilename = image.getOriginalFilename();
        // 构建新的文件名         uuid                                       从 .往后                   最后一个 . 索引
        String newFileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        // 将文件保存在 目录下
        image.transferTo(new File("D:\\Desktop\\code\\java\\code\\javaweb\\demo\\src\\main\\java\\kk\\pojo\\file\\upload\\" + newFileName));
        return Result.success();
    }
}
