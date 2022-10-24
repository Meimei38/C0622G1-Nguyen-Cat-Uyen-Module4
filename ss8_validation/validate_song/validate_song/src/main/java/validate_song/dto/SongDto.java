package validate_song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;

public class SongDto implements Validator {
    private Integer id;
    @NotEmpty
    private String songName;
    @NotEmpty
    private String artist;
    @NotEmpty
    private String genre;

    public SongDto() {
    }

    public SongDto(Integer id, String songName, String artist, String genre) {
        this.id = id;
        this.songName = songName;
        this.artist = artist;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if(!songDto.getSongName().isEmpty()){
            if(songDto.getSongName().length()>800 ){
                errors.rejectValue("songName","songName.length.failed","Không vượt quá 800 ký tự");
            }
            if(!songDto.getSongName().matches("^[a-zA-Z0-9]*$")){
                errors.rejectValue("songName","songName.regex.failed","Không chứa các kí tự đặc biệt như @ ; , . = - + , ….");
            }
        }
        if(!songDto.getArtist().isEmpty()){
            if(songDto.getArtist().length()>300 ){
                errors.rejectValue("artist","artistName.length.failed","Không vượt quá 300 ký tự");
            }
            if(!songDto.getArtist().matches("^[a-zA-Z0-9]*$")){
                errors.rejectValue("artist","artistName.regex.failed","Không chứa các kí tự đặc biệt như @ ; , . = - + , ….");
            }
        }
        if(!songDto.getGenre().isEmpty()){
            if(songDto.getGenre().length()>1000  ){
                errors.rejectValue("genre","genre.length.failed","Không vượt quá 300 ký tự");
            }
            if(!songDto.getArtist().matches("^[a-zA-Z0-9 \\,]*$")){
                errors.rejectValue("genre","genre.regex.failed","Không chứa các kí tự đặc biệt như @ ;  . = - + , ….");
            }
        }

    }
}
