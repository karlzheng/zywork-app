package top.zywork.service;

import org.springframework.web.multipart.MultipartFile;
import top.zywork.common.UploadUtils;
import top.zywork.vo.ResponseStatusVO;

/**
 * UploadService服务接口<br/>
 * <p>
 * 创建于2019-03-29<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface UploadService {

    /**
     * 单文件上传
     *
     * @param storageProvider 存储提供者
     * @param file                单个文件
     * @param allowedExts         允许的后缀
     * @param maxSize             最大文件大小，单位byte
     * @param uploadOptions       本地上传选项
     * @return
     */
    ResponseStatusVO uploadFile(String storageProvider, MultipartFile file, String allowedExts, long maxSize, UploadUtils.UploadOptions uploadOptions);

    /**
     * 多文件上传
     *
     * @param storageProvider 存储提供者
     * @param files               多个文件
     * @param allowedExts         允许的后缀
     * @param maxSize             最大文件大小，单位byte
     * @param uploadOptions       本地上传选项
     * @return
     */
    ResponseStatusVO uploadFiles(String storageProvider, MultipartFile[] files, String allowedExts, long maxSize, UploadUtils.UploadOptions uploadOptions);

}
