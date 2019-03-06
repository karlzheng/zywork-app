package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserGoodsCartDAO;
import top.zywork.dos.UserGoodsCartDO;
import top.zywork.dto.UserGoodsCartDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserGoodsCartService;

import javax.annotation.PostConstruct;

/**
 * UserGoodsCartServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-03-06<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "userGoodsCartService")
public class UserGoodsCartServiceImpl extends AbstractBaseService implements UserGoodsCartService {

    private UserGoodsCartDAO userGoodsCartDAO;

    @Autowired
    public void setUserGoodsCartDAO(UserGoodsCartDAO userGoodsCartDAO) {
        super.setBaseDAO(userGoodsCartDAO);
        this.userGoodsCartDAO = userGoodsCartDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserGoodsCartDO.class, UserGoodsCartDTO.class);
    }
}
