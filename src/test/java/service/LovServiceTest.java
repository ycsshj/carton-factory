package service;

import com.alibaba.fastjson.JSON;
import com.carton.SpringBootRunApplication;
import com.carton.model.Lov;
import com.carton.service.LovService;
import com.carton.vo.LovVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-26 11:04
 ************************************************************/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRunApplication.class)
public class LovServiceTest {
    @Autowired
    private LovService lovService;

    @Test
    public void testQuery() {
        List<LovVO> lovByCondition = lovService.getLovByCondition("CARTON_CATEGORY", null, null);
        System.out.println(lovByCondition);
    }

    @Test
    public void testInsert() {
        List<LovVO> lovVOList = new ArrayList<>();

        generatorLovVO("CARTON_CATEGORY", "CARTON_CATEGORY_KA_TONG",
                "卡通箱", null, lovVOList);

        generatorLovVO("CARTON_CATEGORY", "CARTON_CATEGORY_CHUANG",
                "床箱", null, lovVOList);

        generatorLovVO("CARTON_CATEGORY", "CARTON_CATEGORY_ZHI_PIAN",
                "纸片", null, lovVOList);

        generatorLovVO("CARTON_CATEGORY", "CARTON_CATEGORY_KA_TONG_THREE",
                "三层", "CARTON_CATEGORY_KA_TONG", lovVOList);

        generatorLovVO("CARTON_CATEGORY", "CARTON_CATEGORY_CHUANG_THREE",
                "三层", "CARTON_CATEGORY_CHUANG", lovVOList);

        generatorLovVO("CARTON_CATEGORY", "CARTON_CATEGORY_KA_TONG_FIVE",
                "五层", "CARTON_CATEGORY_KA_TONG", lovVOList);

        generatorLovVO("CARTON_CATEGORY", "CARTON_CATEGORY_CHUANG_FIVE",
                "五层", "CARTON_CATEGORY_CHUANG", lovVOList);

        generatorLovVO("CARTON_CATEGORY", "CARTON_CATEGORY_BAN_GONG_TAI",
                "办公台", "CARTON_CATEGORY_ZHI_PIAN", lovVOList);

        generatorLovVO("CARTON_CATEGORY", "CARTON_CATEGORY_ZHONG_FENG",
                "中封", "CARTON_CATEGORY_ZHI_PIAN", lovVOList);

        lovService.batchInsertLov(lovVOList);
        System.out.println(JSON.toJSONString(lovVOList));
    }

    private void generatorLovVO(String category, String lovCode, String lovValue, String parentCode, List<LovVO> lovVOList) {
        LovVO lovVO = new LovVO();
        lovVO.setCategory(category);
        lovVO.setLovCode(lovCode);
        lovVO.setLovValue(lovValue);
        lovVO.setParentCode(parentCode);
        lovVO.setValid(true);
        lovVOList.add(lovVO);
    }

}
