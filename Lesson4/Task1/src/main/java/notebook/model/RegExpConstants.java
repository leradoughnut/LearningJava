package notebook.model;

public interface RegExpConstants {
    String NAME_EN = "^[A-Z][A-Za-z`-]+$";
    String NAME_RU = "^[А-ЯЁ][А-ЯЁа-яё-]+$";
    String NAME_UA = "^[А-ЩЬЮЯҐІЇЄ][А-ЩЬЮЯҐІЇЄа-щьюяґіїє']+$";
    String EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
}
