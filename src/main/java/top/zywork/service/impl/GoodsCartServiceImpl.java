package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.GoodsCartDAO;
import top.zywork.dos.GoodsCartDO;
import top.zywork.dto.GoodsCartDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GoodsCartService;

import javax.annotation.PostConstruct;

/**
 * GoodsCartServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-03-06<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "goodsCartService")
public class GoodsCartServiceImpl extends AbstractBaseService implements GoodsCartService {

    private GoodsCartDAO goodsCartDAO;

    @Autowired
    public void setGoodsCartDAO(GoodsCartDAO goodsCartDAO) {
        super.setBaseDAO(goodsCartDAO);
        this.goodsCartDAO = goodsCartDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GoodsCartDO.class, GoodsCartDTO.class);
    }
}
