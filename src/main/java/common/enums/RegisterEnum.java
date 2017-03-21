package common.enums;

/**
 * Created by peyppicp on 2017/3/21.
 */
public enum RegisterEnum {

    UNKNOWEN(-1, "Internal Error"), EXISTED(0, "Already Exist"), FAILED(1, "Failed"), SUCCESS(2, "Success");

    private int code;
    private String message;

    private RegisterEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
