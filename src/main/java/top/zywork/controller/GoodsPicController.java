package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zywork.common.BeanUtils;
import top.zywork.common.BindingResultUtils;
import top.zywork.common.StringUtils;
import top.zywork.common.UploadUtils;
import top.zywork.dto.GoodsPicDTO;
import top.zywork.dto.PagerDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.query.GoodsPicQuery;
import top.zywork.service.GoodsPicService;
import top.zywork.service.UploadService;
import top.zywork.vo.GoodsPicVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.ResponseStatusVO;

import java.util.List;

/**
 * GoodsPicController控制器类<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/goods-pic")
public class GoodsPicController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsPicController.class);

    @Value("${storage.provider}")
    private String storageProvider;

    @Value("${storage.local.compressSizes}")
    private String compressSizes;

    @Value("${storage.local.compressScales}")
    private String compressScales;

    @Value("${storage.local.goods.imgParentDir}")
    private String imgParentDir;

    @Value("${storage.local.goods.imgDir}")
    private String imgDir;
    @Value("${storage.local.goods.imgUrl}")
    private String imgUrl;

    private GoodsPicService goodsPicService;

    private UploadService uploadService;

    /**
     * 上传商品图片
     * @param goodsId 商品编号
     * @param file 图片文件
     * @return
     */
    @PostMapping("admin/upload/{goodsId}")
    public ResponseStatusVO upload(@PathVariable("goodsId") Long goodsId, MultipartFile file) {
        UploadUtils.UploadOptions uploadOptions = new UploadUtils.UploadOptions(imgParentDir, imgDir, imgUrl);
        uploadOptions.generateCompressSizes(compressSizes);
        ResponseStatusVO responseStatusVO = uploadService.uploadFile(storageProvider, file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(), uploadOptions);
        if (responseStatusVO.getCode().intValue() == ResponseStatusEnum.OK.getCode().intValue()) {
            GoodsPicDTO goodsPicDTO = new GoodsPicDTO();
            goodsPicDTO.setGoodsId(goodsId);
            goodsPicDTO.setPicUrl(responseStatusVO.getData().toString());
            goodsPicService.saveObj(goodsPicDTO);
            responseStatusVO.setData(goodsPicDTO);
        }
        return responseStatusVO;
    }

    /**
     * 上传商品图片
     * @param goodsId 商品编号
     * @param file 图片文件
     * @return
     */
    @PostMapping("user/upload/{goodsId}")
    public ResponseStatusVO userUpload(@PathVariable("goodsId") Long goodsId, MultipartFile file) {
        return upload(goodsId, file);
    }

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated GoodsPicVO goodsPicVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsPicService.save(BeanUtils.copy(goodsPicVO, GoodsPicDTO.class));
        return ResponseStatusVO.ok("添加成功", null);
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<GoodsPicVO> goodsPicVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsPicService.saveBatch(BeanUtils.copyListObj(goodsPicVOList, GoodsPicDTO.class));
        return ResponseStatusVO.ok("批量添加成功", null);
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        goodsPicService.removeById(id);
        return ResponseStatusVO.ok("删除成功", null);
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        goodsPicService.removeByIds(StringUtils.strArrayToLongArray(ids));
        return ResponseStatusVO.ok("批量删除成功", null);
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated GoodsPicVO goodsPicVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        int updateRows = goodsPicService.update(BeanUtils.copy(goodsPicVO, GoodsPicDTO.class));
        if (updateRows == 1) {
            return ResponseStatusVO.ok("更新成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在此更新前数据已被更新", null);
        }
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<GoodsPicVO> goodsPicVOList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatusVO.dataError(BindingResultUtils.errorString(bindingResult), null);
        }
        goodsPicService.updateBatch(BeanUtils.copyListObj(goodsPicVOList, GoodsPicDTO.class));
        return ResponseStatusVO.ok("批量更新成功", null);
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody GoodsPicVO goodsPicVO) {
        goodsPicService.update(BeanUtils.copy(goodsPicVO, GoodsPicDTO.class));
        return ResponseStatusVO.ok("激活或冻结成功", null);
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<GoodsPicVO> goodsPicVOList) {
        goodsPicService.updateBatch(BeanUtils.copyListObj(goodsPicVOList, GoodsPicDTO.class));
        return ResponseStatusVO.ok("批量激活或冻结成功", null);
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        GoodsPicVO goodsPicVO = new GoodsPicVO();
        Object obj = goodsPicService.getById(id);
        if (obj != null) {
            goodsPicVO = BeanUtils.copy(obj, GoodsPicVO.class);
        }
        return ResponseStatusVO.ok("查询成功", goodsPicVO);
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        PagerDTO pagerDTO = goodsPicService.listAll();
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsPicVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/all-cond")
    public ResponseStatusVO listAllByCondition(@RequestBody GoodsPicQuery goodsPicQuery) {
        PagerDTO pagerDTO = goodsPicService.listAllByCondition(goodsPicQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsPicVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody GoodsPicQuery goodsPicQuery) {
        PagerDTO pagerDTO = goodsPicService.listPageByCondition(goodsPicQuery);
        PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
        pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), GoodsPicVO.class));
        return ResponseStatusVO.ok("查询成功", pagerVO);
    }

    @Autowired
    public void setGoodsPicService(GoodsPicService goodsPicService) {
        this.goodsPicService = goodsPicService;
    }

    @Autowired
    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }
}
