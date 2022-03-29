package converter.service.impl;

import converter.service.ConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService {
    @Override
    public int convertUSDToVND(int usd) {
         int vnd = usd * 23000;
        return vnd;
    }
}
