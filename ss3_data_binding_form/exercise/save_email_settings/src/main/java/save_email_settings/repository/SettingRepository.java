package save_email_settings.repository;

import org.springframework.stereotype.Repository;
import save_email_settings.model.Setting;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SettingRepository implements ISettingRepository{
    public static List<Setting> settingList = new ArrayList<>();
    static {
        settingList.add(new Setting(1,"English",25,false,"Adam"));
        settingList.add(new Setting(2,"Chinese",15,false,"Mary"));
        settingList.add(new Setting(3,"French",5,true,"John"));
        settingList.add(new Setting(4,"Vietnamese",50,true,"Elvis"));
        settingList.add(new Setting(5,"English",25,false,"Tom"));
    }
   public static List<String> languages = new ArrayList<>();
        static {
            languages.add("English");
            languages.add("French");
            languages.add("German");
            languages.add("Chinese");
            languages.add("Vietnamese");
        }

        public static List<Integer> pageSize = new ArrayList<>();
        static {
            pageSize.add(5);
            pageSize.add(10);
            pageSize.add(15);
            pageSize.add(25);
            pageSize.add(50);
            pageSize.add(100);
        }


    @Override
    public void createSetting(Setting setting) {
        settingList.add(setting);
    }

    @Override
    public void updateSetting(Setting setting) {
        for(Setting item:settingList){
            if(item.getId()==setting.getId()){
                item.setLanguages(setting.getLanguages());
                item.setPageSize(setting.getPageSize());
                item.setSpamsFilter(setting.isSpamsFilter());
                item.setSignature(setting.getSignature());
            }
        }
    }

    @Override
    public Setting getSetting(Integer id) {
        for (int i = 0; i <settingList.size() ; i++) {
            if(settingList.get(i).getId()==id){
                return settingList.get(i);
            }
        }
        return null;
    }
}
