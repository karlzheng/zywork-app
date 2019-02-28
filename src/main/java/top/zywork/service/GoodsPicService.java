package top.zywork.service;

import top.zywork.dto.GoodsPicDTO;

/**
 * GoodsPicService服务接口<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface GoodsPicService extends BaseService {

    /**
     * 保存商品及图片关系，并返回带有id的对象
     * @param goodsPicDTO
     * @return
     */
    GoodsPicDTO saveObj(GoodsPicDTO goodsPicDTO);

}
