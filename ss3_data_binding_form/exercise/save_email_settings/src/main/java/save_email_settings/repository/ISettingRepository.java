package save_email_settings.repository;

import save_email_settings.model.Setting;

import java.util.List;

public interface ISettingRepository {
   void createSetting(Setting setting);
   void updateSetting(Setting setting);
   Setting getSetting(Integer id);
}
