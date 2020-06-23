package netease.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import netease.dao.ProvinceDao;
import netease.dao.impl.ProvinceDaoImpl;
import netease.domain.Province;
import netease.service.ProvinceService;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        Jedis jedis = new Jedis();
        String provinceJson = jedis.get("province");
        if (provinceJson == null || provinceJson.length() == 0) {
            List<Province> list = this.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                provinceJson = objectMapper.writeValueAsString(list);
                jedis.set("province", provinceJson);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } finally {
                jedis.close();
            }
        }
        return provinceJson;
    }
}
