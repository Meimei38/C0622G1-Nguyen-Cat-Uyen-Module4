package save_email_settings.service;

import save_email_settings.model.Setting;

import java.util.List;

public interface ISettingService {
    void createSetting(Setting setting);
    void updateSetting(Setting setting);
    Setting getSetting(Integer id);

}
