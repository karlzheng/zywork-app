package top.zywork.service.impl;

import com.aliyun.oss.OSSClient;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.zywork.ali.AliyunOssConfig;
import top.zywork.ali.AliyunOssUtils;
import top.zywork.common.FileUtils;
import top.zywork.common.UploadUtils;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.enums.StorageProviderEnum;
import top.zywork.enums.SysConfigEnum;
import top.zywork.qiniu.QiniuOssConfig;
import top.zywork.qiniu.QiniuOssUtils;
import top.zywork.service.SysConfigService;
import top.zywork.service.UploadService;
import top.zywork.vo.ResponseStatusVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * UploadService服务接口实现类<br/>
 * <p>
 * 创建于2019-03-29<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service
public class UploadServiceImpl implements UploadService {

    private static final Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);

    private SysConfigService sysConfigService;

    @Override
    public ResponseStatusVO uploadFile(String storageProvider, MultipartFile file, String allowedExts, long maxSize, UploadUtils.UploadOptions uploadOptions) {
        ResponseStatusVO responseStatusVO = UploadUtils.checkFile(file, allowedExts, maxSize);
        if (responseStatusVO.getCode().intValue() != ResponseStatusEnum.OK.getCode()) {
            return responseStatusVO;
        }
        if (StorageProviderEnum.LOCAL.getProvider().equals(storageProvider)) {
            return saveLocalFile(file, uploadOptions);
        }
        if (StorageProviderEnum.ALIYUN_OSS.getProvider().equals(storageProvider)) {
            return putAliyunOssFile(file, uploadOptions);
        }
        if (StorageProviderEnum.QINIU_OSS.getProvider().equals(storageProvider)) {
            return putQiniuOssFile(file, uploadOptions);
        }
        return ResponseStatusVO.dataError("StorageProvider指定错误", null);
    }

    @Override
    public ResponseStatusVO uploadFiles(String storageProvider, MultipartFile[] files, String allowedExts, long maxSize, UploadUtils.UploadOptions uploadOptions) {
        ResponseStatusVO responseStatusVO = UploadUtils.checkFiles(files, allowedExts, maxSize);
        if (responseStatusVO.getCode().intValue() != ResponseStatusEnum.OK.getCode()) {
            return responseStatusVO;
        }
        if (StorageProviderEnum.LOCAL.getProvider().equals(storageProvider)) {
            return saveLocalFiles(files, uploadOptions);
        }
        if (StorageProviderEnum.ALIYUN_OSS.getProvider().equals(storageProvider)) {
            return putAliyunOssFiles(files, uploadOptions);
        }
        if (StorageProviderEnum.QINIU_OSS.getProvider().equals(storageProvider)) {
            return putQiniuOssFiles(files, uploadOptions);
        }
        return ResponseStatusVO.dataError("StorageProvider指定错误", null);
    }

    private ResponseStatusVO saveLocalFile(MultipartFile file, UploadUtils.UploadOptions uploadOptions) {
        ResponseStatusVO responseStatusVO;
        if (uploadOptions.getCompressSizes() != null) {
            responseStatusVO = UploadUtils.uploadImg(file, uploadOptions.getUploadParentDir(), uploadOptions.getUploadDir(), uploadOptions.getCompressSizes());
        } else if (uploadOptions.getCompressScales() != null) {
            responseStatusVO = UploadUtils.uploadImg(file, uploadOptions.getUploadParentDir(), uploadOptions.getUploadDir(), uploadOptions.getCompressScales());
        } else {
            responseStatusVO = UploadUtils.uploadFile(file, uploadOptions.getUploadParentDir(), uploadOptions.getUploadDir());
        }
        if (responseStatusVO.getCode().intValue() == ResponseStatusEnum.OK.getCode().intValue()) {
            responseStatusVO.setData(uploadOptions.getDbSaveUrl() + "/" + responseStatusVO.getData());
        }
        return responseStatusVO;
    }

    private ResponseStatusVO saveLocalFiles(MultipartFile[] files, UploadUtils.UploadOptions uploadOptions) {
        ResponseStatusVO responseStatusVO;
        if (uploadOptions.getCompressSizes() != null) {
            responseStatusVO = UploadUtils.uploadImgs(files, uploadOptions.getUploadParentDir(), uploadOptions.getUploadDir(), uploadOptions.getCompressSizes());
        } else if (uploadOptions.getCompressScales() != null) {
            responseStatusVO = UploadUtils.uploadImgs(files, uploadOptions.getUploadParentDir(), uploadOptions.getUploadDir(), uploadOptions.getCompressScales());
        } else {
            responseStatusVO = UploadUtils.uploadFiles(files, uploadOptions.getUploadParentDir(), uploadOptions.getUploadDir());
        }
        if (responseStatusVO.getCode().intValue() == ResponseStatusEnum.OK.getCode().intValue()) {
            for (Object fileName : (List) responseStatusVO.getData()) {
                fileName = uploadOptions.getDbSaveUrl() + "/" + fileName;
            }
        }
        return responseStatusVO;
    }

    private ResponseStatusVO putAliyunOssFile(MultipartFile file, UploadUtils.UploadOptions uploadOptions) {
        AliyunOssConfig aliyunOssConfig = sysConfigService.getByName(SysConfigEnum.ALIYUN_OSS_CONFIG.getValue(), AliyunOssConfig.class);
        OSSClient ossClient = AliyunOssUtils.getClient(aliyunOssConfig);
        String fileName = FileUtils.newFileName(file.getOriginalFilename());
        String objectKey = StringUtils.isEmpty(uploadOptions.getUploadDir()) ? fileName : uploadOptions.getUploadDir() + "/" + fileName;
        try {
            AliyunOssUtils.putInputStream(ossClient, aliyunOssConfig.getDefaultBucket(), objectKey, file.getInputStream());
            return ResponseStatusVO.ok("上传至阿里云OSS成功", objectKey);
        } catch (IOException e) {
            logger.error("AliyunOssUtils.putInputStream error: {}", e.getMessage());
            return ResponseStatusVO.error("上传至阿里云OSS出现错误", null);
        } finally {
            AliyunOssUtils.closeClient(ossClient);
        }
    }

    private ResponseStatusVO putAliyunOssFiles(MultipartFile[] files, UploadUtils.UploadOptions uploadOptions) {
        AliyunOssConfig aliyunOssConfig = sysConfigService.getByName(SysConfigEnum.ALIYUN_OSS_CONFIG.getValue(), AliyunOssConfig.class);
        OSSClient ossClient = AliyunOssUtils.getClient(aliyunOssConfig);
        List<String> urls = new ArrayList<>();
        for (MultipartFile file : files) {
            String fileName = FileUtils.newFileName(file.getOriginalFilename());
            String objectKey = StringUtils.isEmpty(uploadOptions.getUploadDir()) ? fileName : uploadOptions.getUploadDir() + "/" + fileName;
            try {
                AliyunOssUtils.putInputStream(ossClient, aliyunOssConfig.getDefaultBucket(), objectKey, file.getInputStream());
                urls.add(objectKey);
            } catch (IOException e) {
                logger.error("AliyunOssUtils.putInputStream error: {}", e.getMessage());
                urls.add("error");
            }
        }
        AliyunOssUtils.closeClient(ossClient);
        return ResponseStatusVO.ok("上传至阿里云OSS", urls);
    }

    private ResponseStatusVO putQiniuOssFile(MultipartFile file, UploadUtils.UploadOptions uploadOptions) {
        QiniuOssConfig qiniuOssConfig = sysConfigService.getByName(SysConfigEnum.QINIU_OSS_CONFIG.getValue(), QiniuOssConfig.class);
        String fileName = FileUtils.newFileName(file.getOriginalFilename());
        String key = StringUtils.isEmpty(uploadOptions.getUploadDir()) ? fileName : uploadOptions.getUploadDir() + "/" + fileName;
        try {
            QiniuOssUtils.putInputStream(qiniuOssConfig.getZoneName(), QiniuOssUtils.getUploadCredential(qiniuOssConfig, qiniuOssConfig.getDefaultBucket()), key, file.getInputStream());
            return ResponseStatusVO.ok("上传至七牛云对象存储成功", key);
        } catch (IOException e) {
            logger.error("QiniuOssUtils.putInputStream error: {}", e.getMessage());
            return ResponseStatusVO.error("上传至七牛云对象存储出现错误", null);
        }
    }

    private ResponseStatusVO putQiniuOssFiles(MultipartFile[] files, UploadUtils.UploadOptions uploadOptions) {
        QiniuOssConfig qiniuOssConfig = sysConfigService.getByName(SysConfigEnum.QINIU_OSS_CONFIG.getValue(), QiniuOssConfig.class);
        List<String> urls = new ArrayList<>();
        for (MultipartFile file : files) {
            String fileName = FileUtils.newFileName(file.getOriginalFilename());
            String key = StringUtils.isEmpty(uploadOptions.getUploadDir()) ? fileName : uploadOptions.getUploadDir() + "/" + fileName;
            try {
                QiniuOssUtils.putInputStream(qiniuOssConfig.getZoneName(), QiniuOssUtils.getUploadCredential(qiniuOssConfig, qiniuOssConfig.getDefaultBucket()), key, file.getInputStream());
                urls.add(key);
            } catch (IOException e) {
                logger.error("QiniuOssUtils.putInputStream error: {}", e.getMessage());
                urls.add("error");
            }
        }
        return ResponseStatusVO.ok("上传至七牛云对象存储", urls);
    }

    @Autowired
    public void setSysConfigService(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }
}
