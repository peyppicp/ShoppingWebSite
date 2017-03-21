package common.enums;

/**
 * Created by peyppicp on 2017/3/21.
 */
public enum UserSellerStatusEnum {

    TRUE(true), FALSE(false);

    private boolean isSeller;

    UserSellerStatusEnum(boolean isSeller) {
        this.isSeller = isSeller;
    }

    public boolean getStatus() {
        return isSeller;
    }
}
