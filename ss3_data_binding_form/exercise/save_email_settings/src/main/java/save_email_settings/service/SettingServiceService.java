package save_email_settings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import save_email_settings.model.Setting;
import save_email_settings.repository.ISettingRepository;
import save_email_settings.repository.SettingRepository;

import java.util.List;

@Service
public class SettingServiceService implements ISettingService {
    @Autowired
    ISettingRepository settingRepository;

    @Override
    public void createSetting(Setting setting) {
        List<Setting> settingList = SettingRepository.settingList;
        Integer id = settingList.get(settingList.size()-1).getId();
        id+=1;
        setting.setId(id);
        settingRepository.createSetting(setting);
    }

    @Override
    public void updateSetting(Setting setting) {
        settingRepository.updateSetting(setting);
    }

    public Setting getSetting(Integer id){
        return settingRepository.getSetting(id);
    }

}
